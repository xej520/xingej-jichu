package com.xingej.test;

import com.xingej.test.service.LoginServiceImpl;

/**
 * Hello world!
 *
 */
public class Client {
    public static void main(String[] args) {
        LoginServiceImpl serviceImpl = new LoginServiceImpl();
        
        serviceImpl.login();
    }
}
