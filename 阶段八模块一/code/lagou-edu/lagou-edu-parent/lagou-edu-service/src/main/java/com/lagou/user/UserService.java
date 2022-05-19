package com.lagou.user;

import com.lagou.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-05-02 09:57:37
 */
public interface UserService {

    User login(String phone,String password);

    Integer checkPhone(String phone);


    /**
     * 注册
     * @param phone
     * @param password
     * @return 受影响行数
     */
    Integer register(@Param("phone") String phone, @Param("password") String password);

    /**
     * 更新用户信息
     * @return
     */
    Integer updateUserInfo(int id,String portrait,String name);

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    Integer updatePassword(@Param("id") int id, @Param("password") String password);


}
