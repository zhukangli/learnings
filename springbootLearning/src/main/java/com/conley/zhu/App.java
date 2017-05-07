package com.conley.zhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration//这个注解告诉Spring-Boot根据添加的jar依赖猜测你想如何配置Spring
@SpringBootApplication//加入了这个才能够把项目整体纳入spring管理，没有这个，只能启动一个此方法为入口的服务器而已
public class App{
	public static void main( String[] args ) {
		//SpringApplication.setAddCommandLineProperties(false);
		SpringApplication.run(App.class, args);
	}
}
