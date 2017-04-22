package conley.zhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration//这个注解告诉Spring-Boot根据添加的jar依赖猜测你想如何配置Spring
public class App{
	@RequestMapping("/")
	public String home(){
		return "hello";
	}


	public static void main( String[] args )
	{

		SpringApplication.run(App.class, args);
	}
}
