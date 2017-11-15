package is.hi.hirslan.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Prófunarklasi sem sendir URL á test web client
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Aðferð til að athuga hvort virkar að senda HttpRequest á signup slóðina og
     * fá til baka síðu sem inniheldur Nýskráning
     *
     * @throws Exception
     */
    @Test
    public void signupShouldContainNyskraningText() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/signup",
                String.class)).contains("Nýskráning");
    }
}