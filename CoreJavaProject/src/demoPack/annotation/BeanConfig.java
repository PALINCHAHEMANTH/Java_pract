package demoPack.annotation;

import org.springframework.context.annotation.*;

@Configuration
public class BeanConfig 
{
	@Bean 
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}
}