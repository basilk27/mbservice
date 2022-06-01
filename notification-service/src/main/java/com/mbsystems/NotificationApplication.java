package com.mbsystems;

import com.mbsystems.amap.RabbitMQMessageProducer;
import com.mbsystems.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.mbsystems.amap",
                "com.mbsystems"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//          return args -> {
//              producer.publish(new Person,
//                                        notificationConfig.getInternalExchange(),
//                                        notificationConfig.getInternalNotificationRoutingKey() );
//          };
//    }
}