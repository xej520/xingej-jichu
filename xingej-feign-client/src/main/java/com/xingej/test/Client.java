package com.xingej.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xingej.test.service.FtpClusterServiceImpl;
import com.xingej.test.service.LoginServiceImpl;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class Client {
    public static void main(String[] args) {
        
        SpringApplication.run(Client.class, args);
        
        LoginServiceImpl serviceImpl = new LoginServiceImpl();
        
        serviceImpl.login();
        
        FtpClusterServiceImpl clusterServiceImpl = new FtpClusterServiceImpl();
        
        clusterServiceImpl.show();
        
    }
}
