package com.demo.seleniumspring.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private  int timeout;

    @Bean
    // @Primary // this will be the default browser
    @ConditionalOnProperty(name = "browser", havingValue = "chrome") // run when property is set to chrome
    public WebDriver chromeDriver() {
        // this is the bean class for chrome driver

        if (System.getenv("CLOUD_RUN_FLAG") == null) {
            WebDriverManager.chromedriver().setup();
           return new ChromeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            return new ChromeDriver(options = options);
        }
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        // this is the bean class for edge driver

        if (System.getenv("CLOUD_RUN_FLAG") == null) {
            WebDriverManager.edgedriver().setup();
        }
        return new EdgeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, this.timeout);
    }

}
