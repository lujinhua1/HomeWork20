package com.lagou.user;

import com.lagou.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject:com.lagou.user
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
public interface UserService {
    /**
     * @param phone    手机号
     * @param password 密码
     * @return 用户对象
     */
    User login(String phone, String password);

    /**
     * 检查手机号是否注册
     * @param phone
     * @return
     */
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
