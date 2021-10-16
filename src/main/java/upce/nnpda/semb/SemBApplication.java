package upce.nnpda.semb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import upce.nnpda.semb.generator.GeneratorData;

@SpringBootApplication
public class SemBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SemBApplication.class, args);
        GeneratorData.generator();
    }
}
