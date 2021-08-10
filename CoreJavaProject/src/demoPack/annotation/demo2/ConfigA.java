package demoPack.annotation.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA 
{
	@Bean("init-method='init', destroy-method='destroy'")
	public A a() {
		return new A(); 
	}
}