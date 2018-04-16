package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Controller
@MapperScan("com.example.mapper")
@EnableAutoConfiguration
@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@ComponentScan(basePackages={"com.example"})
@SpringBootApplication
@ServletComponentScan // 组件扫描
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	 @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  
  
	 
	 public static void main(String[] args) throws Exception {
		 new SpringApplicationBuilder(Application.class).web(true).run(args);
	    }

	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
	//	configurableEmbeddedServletContainer.setPort(9090);
	}
}