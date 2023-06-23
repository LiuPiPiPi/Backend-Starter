package com.lpxz.cmsauth.enums;

/**
 * @author LPxz
 * @date 2023/6/3
 */
public enum UserStatus {
    OK(0, "正常"), DISABLE(1, "停用"), DELETED(2, "删除");

    private final int code;
    private final String info;

    UserStatus(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
