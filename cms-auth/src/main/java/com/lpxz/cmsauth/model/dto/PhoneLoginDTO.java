package com.lpxz.cmsauth.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author LPxz
 * @date 2023/6/14
 */
@Data
public class PhoneLoginDTO {

    @NotNull
    private String phone;

    @NotBlank
    private String captcha;
}
