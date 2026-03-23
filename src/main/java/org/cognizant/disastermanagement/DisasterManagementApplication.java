
package org.cognizant.disastermanagement;

import org.cognizant.disastermanagement.Enum.RecoveryStatus;
import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.service.RecoveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // MANDATORY: This fixes the "created_at cannot be null" error
public class DisasterManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(DisasterManagementApplication.class, args);
    }
}