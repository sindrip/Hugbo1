package is.hi.hirslan.test;

import is.hi.hirslan.Application;
import is.hi.hirslan.RESTController.UserController;
import is.hi.hirslan.security.WebSecurity;
import is.hi.hirslan.services.CourseService;
import is.hi.hirslan.services.ReviewService;
import is.hi.hirslan.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem framkvæmir prófanir á weblayer og notar WebMvcTest og
 * Mockito til að prófa service klasa
 */

@RunWith(SpringRunner.class)
@WebMvcTest
@Import({WebSecurity.class, Application.class})
public class WebMockTest {

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
     * Aðferð sem prófar /lifir á ClientController en með
     * erALifi() true. Ættum að fá til baka login.html síðuna
     */
    @Test
    public void testaLifirTrue() throws Exception {
        when(courseService.erALifi()).thenReturn(true);
        this.mockMvc.perform(get("/lifir"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content()
                        .string(containsString("Innskráning")));

    }
    /**
     * Aðferð sem prófar /lifir á ClientController en með
     * erALifi() false. Ættum að fá til baka logout.html síðuna
     */
    @Test
    public void testaLifirFalse() throws Exception {

        // Prófið ætti að takast - prófum ósönnu leiðina í if-setningunni
        when(courseService.erALifi()).thenReturn(false);
        this.mockMvc.perform(get("/lifir")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Skrái notanda út")));
    }

}
