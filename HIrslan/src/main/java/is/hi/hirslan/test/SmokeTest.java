package is.hi.hirslan.test;

import static org.assertj.core.api.Assertions.assertThat;

import is.hi.hirslan.RESTController.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem athugar hvort UserController keyrir
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController userController;

    /**
     * Aðferð til að athuga hvort controllerin hefur verið búinn til
     *
     * @throws Exception
     */
    @Test
    public void userControllerShouldExist() throws Exception {
        assertThat(userController).isNotNull();
    }
}