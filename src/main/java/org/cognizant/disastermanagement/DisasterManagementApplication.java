package org.cognizant.disastermanagement;

import org.cognizant.disastermanagement.Enum.RecoveryStatus;
import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.service.RecoveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DisasterManagementApplication {

    public static void main(String[] args) {
        // 1. Start the Spring Application and get the context
        ConfigurableApplicationContext context = SpringApplication.run(DisasterManagementApplication.class, args);

        // 2. Get the Service from the context instead of using 'new'
       /* RecoveryService recoveryService = context.getBean(RecoveryService.class);

        // 3. Now you can safely call your methods
        RecoveryProgram program = new RecoveryProgram();
        program.setTitle("Test Management Program");
program.setProgramId(101);
program.setStatus(RecoveryStatus.ACTIVE);
        recoveryService.createProgram(program);

        System.out.println("Program created successfully!");*/
    }
}