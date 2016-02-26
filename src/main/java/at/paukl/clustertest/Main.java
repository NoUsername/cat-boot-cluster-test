package at.paukl.clustertest;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Configuration
@RestController
@EnableAutoConfiguration
public class Main {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/")
    public Object testAction(HttpSession httpSession) {
        String value = Objects.toString(httpSession.getAttribute("foo"), "");
        httpSession.setAttribute("foo", value + "x");
        return value;
    }

}
