package is.hi.hirslan.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem framkvæmir prófanir án þess að þurfa að kalla á þjóninn
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;


    /**
     *  Aðferð til að athuga hvort virkar að senda HttpRequest á /signup og fá
     *  til baka signup.html síðuna sem inniheldur strenginn Nýskráning
     * @throws Exception
     */
    @Test
    public void shouldContainNyskraning() throws Exception {
        this.mockMvc.perform(get("/signup")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Nýskráning")));
    }
}