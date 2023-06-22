package com.lpxz.cmsauth.model;

import com.lpxz.cmscommon.base.BaseEntity;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
* 用户
*/
@Data
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 用户ID
    */
    @NotNull
    private Long userId;

    /**
    * 用户账号
    */
    @NotNull(message = "用户账号不能为空")
    private String userAccount;

    /**
    * 用户名称
    */
    @NotNull(message = "用户名称不能为空")
    private String userName;

    /**
    * 用户密码
    */
    private String userPassword;

    /**
    * 用户联系方式
    */
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式有误")
    private String userPhone;

    /**
    * 用户电子邮箱
    */
    @Email
    private String userEmail;

    /**
    * 用户状态
    */
    private Integer userStatus;
}