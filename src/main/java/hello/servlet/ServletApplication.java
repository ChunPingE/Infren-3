package hello.servlet;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.view.*;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	/*
	 * @Bean InternalResourceViewResolver internalResourceViewResolver() { return
	 * new InternalResourceViewResolver("/WEB-INF/views/", ".jsp"); }
	 */
}
