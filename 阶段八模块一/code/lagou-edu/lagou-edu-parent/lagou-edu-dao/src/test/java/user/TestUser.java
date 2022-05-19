package user;

import com.lagou.entity.User;
import com.lagou.mapper.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject:user
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class TestUser {
    @Autowired
    private UserDao userDao;

    @Test
    public void login(){
//        User login = userDao.login("110", "123");
//        System.out.println(login);
    }
//
    @Test
    public void checkPhone(){
//        Integer integer = userDao.checkPhone("111");
//        System.out.println(integer);
    }
//
    @Test
    public void register(){
//        Integer i = userDao.register("115", "123");
//        System.out.println("i = "+i);
    }

    @Test
    public void updateUserInfo(){
//        Integer i = userDao.updateUserInfo(100030024, "aaaa", "无敌");
//        System.out.println(i);
    }
    @Test
    public void updatePassword(){
//        Integer i = userDao.updatePassword(100030024, "123456");
//        System.out.println(i);
    }
}
