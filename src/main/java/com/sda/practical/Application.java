package com.sda.practical;


import com.sda.practical.order.domain.Order;
import com.sda.practical.order.OrderRepository.OrderRepository;
import com.sda.practical.order.domain.OrderStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
        @Bean
        public Docket productApi() {
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.basePackage("com.sda.practical")).build();
        }

    @Bean
    CommandLineRunner initDatabase(OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(Order.of("Order1 Tallinn to Riga", OrderStatus.COMPLETED));
            orderRepository.save(Order.of("Order2 From Tallinn to Tartu", OrderStatus.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {

            });
        };
    }

        }





