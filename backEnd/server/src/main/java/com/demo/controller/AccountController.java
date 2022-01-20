package com.demo.controller;


import com.demo.pojo.Account;
import com.demo.pojo.AccountLoginParam;
import com.demo.pojo.ResponseBean;
import com.demo.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wangjunliang
 * @since 22-01-19 01:56
 */
@Api(tags = "账户相关接口")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation("登录之后返回token")
    @PostMapping("/login")
    public ResponseBean login(@RequestBody AccountLoginParam accountLoginParam, HttpServletRequest request)
    {
        return accountService.login(accountLoginParam.getUsername(),
                accountLoginParam.getPassword()
                ,accountLoginParam.getCode(),request);
    }

    @ApiOperation("获取当前用户信息")
    @GetMapping("/getAccountInfo")
    public ResponseBean getAccountInfo(Principal principal)
    {
        if(principal==null)
        {
            return null;
        }
        String username=principal.getName();
        Account account=accountService.getAccountByUserName(username);
        account.setPassword(null);
        return ResponseBean.success("获取成功",account);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public ResponseBean logout()
    {
        return ResponseBean.success("注销成功！");
    }
}
