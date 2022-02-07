package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.demo.config.security.JwtTokenUtil;
import com.demo.pojo.Account;
import com.demo.mapper.AccountMapper;
import com.demo.pojo.ResponseBean;
import com.demo.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wangjunliang
 * @since 22-01-19 01:56
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    AccountMapper accountMapper;

    @Override
    public ResponseBean login(String username, String password,String code, HttpServletRequest request) {
        String captcha=(String)request.getSession().getAttribute("captcha");
        System.out.println(captcha);
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code))
        {
            return ResponseBean.error("验证码输入错误，请重新输入！");
        }
        //登录
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        System.out.println(userDetails.getPassword());
        System.out.println(password);
        System.out.println(passwordEncoder.matches(password,passwordEncoder.encode(userDetails.getPassword())));
        System.out.println(null==userDetails);
        System.out.println(!userDetails.isEnabled());
        if(null==userDetails||!passwordEncoder.matches(password,passwordEncoder.encode(userDetails.getPassword())))
        {
            return ResponseBean.error("用户名或密码不正确");
        }
        if(!userDetails.isEnabled())
        {
            return ResponseBean.error("账号被禁用，请联系管理员");
        }
        System.out.println(userDetails.getPassword());
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(
                        userDetails,null,
                        userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token=jwtTokenUtil.generateToken(userDetails);
        Map<String,String>tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return ResponseBean.success("登录成功",tokenMap);
    }

    @Override
    public Account getAccountByUserName(String username) {
        return  accountMapper.selectOne(new QueryWrapper<Account>().eq("username",username).eq("enable",1));
    }
}
