package com.chunlin.cloud.provider.command.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 系统命令侧服务
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.chunlin.cloud.*")
public class SystemCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemCommandApplication.class, args);
        String successMsg = "  ____   _                _                                                           __         _  _ \n"
                + " / ___| | |_  __ _  _ __ | |_   _   _  _ __    ___  _   _   ___  ___  ___  ___  ___  / _| _   _ | || |\n"
                + " \\___ \\ | __|/ _` || '__|| __| | | | || '_ \\  / __|| | | | / __|/ __|/ _ \\/ __|/ __|| |_ | | | || || |\n"
                + "  ___) || |_| (_| || |   | |_  | |_| || |_) | \\__ \\| |_| || (__| (__|  __/\\__ \\\\__ \\|  _|| |_| || ||_|\n"
                + " |____/  \\__|\\__,_||_|    \\__|  \\__,_|| .__/  |___/ \\__,_| \\___|\\___|\\___||___/|___/|_|   \\__,_||_|(_)\n"
                + "                                      |_|                                                             ";

        System.out.println(successMsg);
    }

}
