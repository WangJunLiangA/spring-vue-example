package com.demo.config.security;

import com.demo.pojo.ResponseBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 当访问接口没有权限时，自定义返回结果
 * @Author WangJunLiang
 * @Date 2022/1/19 15:39
 **/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        ResponseBean responseBean=ResponseBean.error("权限不足，请联系管理员！");
        responseBean.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(responseBean));
        out.flush();
        out.close();
    }
}