package com.lagou.mapper;

import com.lagou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-02 09:57:29
 */
@Service
public interface UserDao {

    User login(@Param("phone") String phone,@Param("password") String password);

    /**
     * 检查手机号是否注册
     * @param phone
     * @return 0：未注册 ！0：已注册
     */
    Integer checkPhone(String phone);

    /**
     * 注册
     * @param phone
     * @param password
     * @return 受影响行数
     */
    Integer register(@Param("phone") String phone,@Param("password") String password);

    /**
     * 更新用户信息
     * @return
     */
    Integer updateUserInfo(@Param("id") int id,@Param("portrait") String portrait,@Param("name") String name);

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    Integer updatePassword(@Param("id") int id, @Param("password") String password);
}

