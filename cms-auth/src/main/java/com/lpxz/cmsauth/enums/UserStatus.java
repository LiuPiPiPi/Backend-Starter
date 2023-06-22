package com.lpxz.cmsauth.enums;

/**
 * @author LPxz
 * @date 2023/6/3
 */
public enum UserStatus {
    // todo 针对 status 的修改
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
