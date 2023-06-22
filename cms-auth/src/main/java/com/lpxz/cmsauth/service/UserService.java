package com.lpxz.cmsauth.service;

import com.github.pagehelper.PageInfo;
import com.lpxz.cmsauth.model.User;
import com.lpxz.cmsauth.model.dto.PhoneLoginDTO;

/**
 * 用户
 */
public interface UserService {

    /**
     * 通过ID查询单个用户
     *
     * @param id ID
     * @return {@link User}
     */
    User findById(Long id);

    /**
     * 分页查询用户
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link User}
     */
    PageInfo<User> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户
     *
     * @param user User
     */
    int insert(User user);

    /**
     * 修改用户
     *
     * @param user User
     */
    void update(User user);

    /**
     * 通过ID删除单个用户
     *
     * @param id ID
     */
    void deleteById(Long id);

    /**
     * 通过电话查询单个用户
     *
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);

    /**
     * 检查账号是否唯一
     *
     * @param userAccount
     * @return
     */
    String checkAccountUnique(String userAccount);

    /**
     * 检查电话是否唯一
     *
     * @param user
     * @return
     */
    String checkPhoneUnique(User user);

    /**
     * 检查邮箱是否唯一
     *
     * @param user
     * @return
     */
    String checkEmailUnique(User user);

    User login(PhoneLoginDTO phoneLoginDTO);

}
