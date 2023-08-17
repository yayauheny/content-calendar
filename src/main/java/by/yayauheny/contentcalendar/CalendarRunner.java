package by.yayauheny.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class CalendarRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CalendarRunner.class, args);
    }

}
