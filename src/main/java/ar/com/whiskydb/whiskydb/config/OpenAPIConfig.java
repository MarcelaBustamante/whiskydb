package ar.com.whiskydb.whiskydb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .description("Here's some information about Argentinean whisky, as well as a few other interesting facts you might want to know.")
                .title("WhiskyDB")
                .version("1.0.0")
                .contact(new Contact().url("https://whiskydb.com.ar"));
        
        return new OpenAPI().info(info);
    }
}
