package is.hi.hirslan.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sun.deploy.util.SessionState;
import is.hi.hirslan.Application;
import is.hi.hirslan.ClientController.ClientController;
import is.hi.hirslan.RESTController.CourseController;
import is.hi.hirslan.RESTController.ReviewController;
import is.hi.hirslan.RESTController.UserController;
import is.hi.hirslan.model.Course;
import is.hi.hirslan.security.UserDetailsServiceImpl;
import is.hi.hirslan.security.WebSecurity;
import is.hi.hirslan.services.CourseService;
import is.hi.hirslan.services.ReviewService;
import is.hi.hirslan.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest
 */

@RunWith(SpringRunner.class)
@WebMvcTest
@Import({WebSecurity.class, Application.class})
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CourseService courseService;
    @MockBean
    ReviewService reviewService;
    @MockBean
    UserController userController;
    @MockBean
    UserDetailsService userDetailsService;


    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á signup
     * og fá til baka signup.html síðuna
     */
    @Test
    public void shouldReturnNyskraning() throws Exception {
        this.mockMvc.perform(get("/signup")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Nýskráning")));
    }

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á login
     * og fá til baka login.html síðuna
     */
    @Test
    public void shouldReturnInnskraning() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Innskráning")));
    }
}