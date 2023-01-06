package shop.itbook.itbookdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ItbookDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItbookDeliveryApplication.class, args);
    }

}
