package by.tut.mdcatalog.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "by.tut.mdcatalog.web",
        "by.tut.mdcatalog.service",
        "by.tut.mdcatalog.repository"
})

public class AppConfig {
}