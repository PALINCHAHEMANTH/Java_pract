package demoPack.annotation.demo1;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig 
{
	@Bean 
	public TextEditor textEditor(){
		return new TextEditor(spellChecker());
	}

	@Bean 
	public SpellChecker spellChecker(){
		return new SpellChecker();
	}
}