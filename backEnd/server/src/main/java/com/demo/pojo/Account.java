package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wangjunliang
 * @since 22-01-19 01:56
 */
@Getter
@Setter
@TableName("account")
@ApiModel(value = "Account对象", description = "")
public class Account implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "手机号码(国内)")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "头像(暂定)")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "是否启用账户")
    @TableField("enable")
    private Boolean enable;

    @ApiModelProperty(value = "住宅电话")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty(value = "住址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    //实现uerDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
