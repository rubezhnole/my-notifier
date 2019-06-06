package com.mynotifier.config;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HttpClient asyncHttpClient() {
        return HttpClients.createDefault();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
