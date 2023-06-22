package com.lpxz.cmsauth.exception;

import com.lpxz.cmscommon.base.BaseException;

/**
 * @author LPxz
 * @date 2023/6/22
 */
public class LoginException extends BaseException {

    private static final long serialVersionUID = 1L;

    public LoginException() {}

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable e) {
        super(message, e);
    }
}
