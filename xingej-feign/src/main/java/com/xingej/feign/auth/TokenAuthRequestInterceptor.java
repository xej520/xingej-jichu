package com.xingej.feign.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class TokenAuthRequestInterceptor implements RequestInterceptor {
    private final String headerValue;

    public TokenAuthRequestInterceptor(String token) {
        this.headerValue = "token=" + token;
    }

    public void apply(RequestTemplate template) {
        template.header("Authorization", new String[] { this.headerValue });
    }
}