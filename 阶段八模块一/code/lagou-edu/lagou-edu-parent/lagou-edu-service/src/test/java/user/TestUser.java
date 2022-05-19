package user;


import com.lagou.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lagou.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class TestUser {
    @Autowired
    private UserService userService;

    @Test
    public void login(){
//        User login = userService.login("110", "123");
//        System.out.println(login);
    }

    @Test
    public void checkPhone(){
//        Integer i = userService.checkPhone("111");
//        System.out.println(i);
    }
}
