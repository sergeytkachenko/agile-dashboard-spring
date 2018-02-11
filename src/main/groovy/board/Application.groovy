package board

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

import javax.annotation.PostConstruct

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Kiev"))
    }
}
