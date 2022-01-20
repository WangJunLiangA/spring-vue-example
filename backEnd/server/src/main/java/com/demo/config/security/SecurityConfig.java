package com.demo.config.security;

import com.demo.pojo.Account;
import com.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description Security配置类
 * @Author WangJunLiang
 * @Date 2022/1/19 14:51
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private RestAuthorizationEntryPoint authorizationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler accessDeniedHandler;

    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //使用jwt，不需要csrf
        http.csrf().disable()
                //基于token，不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //允许登录访问
                //.antMatchers("/account/login","/account/logout")
                //.permitAll()
                //.antMatchers("/doc.html","/css/**","/js/**","favicon.ico","/webjars/**","/swagger-resources/**","/v2/api-docs/**")
                //.permitAll()
                //出了上面，所有请求都要求认证
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .cacheControl();
        //添加jwt,登录授权过滤器
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录的结果返回
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authorizationEntryPoint);

    }

    /**
     * 也可通过该方法放行
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/doc.html",
                "/css/**",
                "/js/**",
                "favicon.ico",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/account/login",
                "/account/logout",
                "/captcha/getCaptcha"
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
      return username -> {
          Account account = accountService.getAccountByUserName(username);
          if (null != account){
              return  account;
          }
          return null;
      };
    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter(){
        return new JwtAuthencationTokenFilter();
    }
}
