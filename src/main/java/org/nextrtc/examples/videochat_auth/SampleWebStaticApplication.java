package org.nextrtc.examples.videochat_auth;

import org.nextrtc.examples.videochat_auth.handler.AnyMessageHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableAutoConfiguration
@EnableWebSocket
@EnableWebSecurity
@EnableWebMvc
@ComponentScan(basePackageClasses = {AnyMessageHandler.class})
@Import({MyWebSocketConfigurator.class,
        SecurityConfigurator.class,
        MvcConfiguration.class})
public class SampleWebStaticApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleWebStaticApplication.class, args);
    }
}
