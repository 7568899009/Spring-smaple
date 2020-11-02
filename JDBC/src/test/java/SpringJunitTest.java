import com.jdbc.config.SpringCore_Config;
import com.jdbc.entity.User;
import com.jdbc.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:ApplicationContext.xml")
@ContextConfiguration(classes = {SpringCore_Config.class})
public class SpringJunitTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void Test() {
        List<User> users = userService.queryUser();
        users.forEach(System.out::println);

    }
}
