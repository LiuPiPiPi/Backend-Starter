package com.lpxz.cmsauth.mapper;

import com.github.pagehelper.Page;
import com.lpxz.cmsauth.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 */
@Mapper
public interface UserMapper {
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
     * @return {@link User}
     */
    Page<User> findByPage();

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
    User findByPhone(String phone);

    /**
     * 检查账号是否唯一
     *
     * @param userAccount
     * @return
     */
    int checkAccountUnique(String userAccount);

    /**
     * 检查电话是否唯一
     *
     * @param userPhone
     * @return
     */
    User checkPhoneUnique(String userPhone);

    /**
     * 检查邮箱是否唯一
     *
     * @param userEmail
     * @return
     */
    User checkEmailUnique(String userEmail);
}
