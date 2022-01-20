package com.demo.config.security;

import com.demo.pojo.ResponseBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 当未登录或者token失效访问接口时，自定义的结果返回
 * @Author WangJunLiang
 * @Date 2022/1/19 15:36
 **/
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        ResponseBean responseBean=ResponseBean.error("未登录，请登录！");
        responseBean.setCode(401);
        out.write(new ObjectMapper().writeValueAsString(responseBean));
        out.flush();
        out.close();
    }
}