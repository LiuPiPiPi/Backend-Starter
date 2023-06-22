package com.lpxz.cmsauth.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lpxz.cmsauth.constant.UserConstants;
import com.lpxz.cmsauth.mapper.UserMapper;
import com.lpxz.cmsauth.model.User;
import com.lpxz.cmsauth.model.dto.PhoneLoginDTO;
import com.lpxz.cmsauth.service.AuthService;
import com.lpxz.cmsauth.service.UserService;
import com.lpxz.cmscommon.base.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private AuthService authService;

    @Override
    public User findById(Long id){
        return userMapper.findById(id);
    }

    @Override
    public PageInfo<User> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PageInfo.of(userMapper.findByPage());
    }

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public void update(User user){
        userMapper.update(user);
    }

    @Override
    public void deleteById(Long id){
        userMapper.deleteById(id);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public String checkAccountUnique(String userAccount) {
        if (userMapper.checkAccountUnique(userAccount) > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkPhoneUnique(User user) {
        Long userId = ObjectUtil.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkPhoneUnique(user.getUserPhone());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkEmailUnique(User user) {
        Long userId = ObjectUtil.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkEmailUnique(user.getUserEmail());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        String username = user.getUserAccount(), password = user.getUserPassword();
        if (StrUtil.isEmpty(username)) {
            throw new BaseException("用户名不能为空");
        } else if (StrUtil.isEmpty(password)) {
            throw new BaseException("用户密码不能为空");
        } else if (UserConstants.NOT_UNIQUE.equals(checkAccountUnique(username))) {
            throw new BaseException("保存用户[" + username + "]失败，注册账号已存在");
        } else {
            // todo
//            user.setUserPassword(passwordService.encryptPassword(user.getUserAccount(), user.getUserPassword(), user.getSalt()));
        }
        return userMapper.insert(user) > 0;
    }

    @Override
    public User login(PhoneLoginDTO phoneLoginDTO) {
        // todo
        if (authService.verifyCode(phoneLoginDTO.getCaptcha(), phoneLoginDTO.getPhone())) {
            return findUserByPhone(phoneLoginDTO.getPhone());
        }
        return null;
    }
}
