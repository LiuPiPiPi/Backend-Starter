package com.lpxz.cmsauth.service;

import com.lpxz.cmsauth.model.User;
import com.lpxz.cmscommon.base.BaseException;
import org.springframework.stereotype.Service;

/**
 * @author LPxz
 * @date 2023/6/22
 */
@Service
public class PasswordService {

//    public void validate(User user, String password) {
//        String account = user.getUserAccount();
//        if (!matches(user, password)) {
//            throw new BaseException();
//        } else {
//        }
//    }
//
//    private boolean matches(User user, String password) {
//        return user.getUserPassword().equals(encryptPassword(user.getUserAccount(), password, user.getSalt()));
//    }
//
//    public String encryptPassword(String userAccount, String password, String salt) {
//        return new Md5Hash(userAccount + password + salt).toHex();
//    }
}
