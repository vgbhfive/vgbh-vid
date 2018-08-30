package cn.vgbhfive.vid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cn.vgbhfive.vid")
public class VidApplication {

    public static void main(String[] args) {
        SpringApplication.run(VidApplication.class, args);
    }

}
