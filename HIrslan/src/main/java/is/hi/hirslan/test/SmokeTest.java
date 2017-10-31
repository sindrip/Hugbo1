package is.hi.hirslan.test;

import static org.assertj.core.api.Assertions.assertThat;

import is.hi.hirslan.RESTController.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController userCntroller;

    @Test
    public void userControllerShouldExist() throws Exception {
        assertThat(userCntroller).isNotNull();
    }
}