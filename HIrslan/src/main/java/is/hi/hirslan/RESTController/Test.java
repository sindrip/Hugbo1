package is.hi.hirslan.RESTController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Test {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}