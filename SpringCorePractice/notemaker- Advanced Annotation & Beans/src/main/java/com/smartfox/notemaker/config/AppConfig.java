package com.smartfox.notemaker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.smartfox.notemaker.config.conditions.NoteExistCondition;
import com.smartfox.notemaker.data.NoteRepository;
import com.smartfox.notemaker.service.impl.NoteService;



/**
 * 1. Initialisation phase - creation of application context - not manually created - servlet initialisation - servlet context handle application context
 * 						- Bean factory initialization (wrapper for bean factory_ + Bean initialization 
 * 						- Bean factory is loaded - post processing on beans + iterate through all beans + instantiate + setters
 * 						- Bean definition - Java Configuration/ Component Scanning and Autoconfiguration (Metadata)
 * 										  - Can be mixed
 * 						- Bean factory contains only references to beans+ id create index in factory
 *						- After loading beans -> Post processors -> i.e PropertySourcesPlaceholderConfigurer -> Property file + inject into beans [at bean factory level]
 *						- BeanFactoryPostProcessor interface e.g own components to impact bean factory + bean definition must be static - reduce side effect of dynammic
 *						- Initialization phase - for each bean [handled by bean factory]-> instantiate beans(constructors) ,
 *											   - Eager instantiation by default
 *											   - @lazy + nothing to depends on for lazy instatiation - ApplicationContext can ignore
 * 											   - Bean pointer + objects constructer
 * 						- Constructor injection happens first
 * 						- Now fully qualified beans to use - now call setters + field based injection
 * 				        - Beans still not ready for use
 * 						- BeanPostProcessor - @PostConstruct methods are called - proxy behaviour
 * 											- BeanPostProcessor Interface - before and after initializer 
 * 											- Beans instantiated and initialized+ ready to use
 * 						 - Using @Bean means it must be managed by the developer
 * 						 - @Autowired - managed by component scan and autoconfiguration
 *
 * 2. Use phase - most of time spent - application context serves proxies to original class + handle to singleton beans
 * 									 - can have more than one application context - you know about your children but your children doesnt know you
 * 									 - ApplicationContextAware - handle to application context for use
 * 
 * 3. Destruction phase- destroyed when close is applied to application context
 * 						- @PreDestroy is called - 
 * 						- allow beans to be garbage collected
 * 						- context cannot be reused again
 * 						- prototype beans not impacted
 **/

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
@ComponentScan(basePackages = { "com.smartfox.notemaker" })
public class AppConfig {

	@Value("${greeting.text}")
	private String greetingText;

	@Value("${greeting.preemble}")
	private String preemble;

	@Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
	private Boolean isDev;

	public class Worker {
		private String text;
		private String preemble;

		public Worker(String text, String preemble) {
			this.text = text;
			this.preemble = preemble;
		}

		@Override
		public String toString() {
			return "Worker [text=" + text + ", preemble=" + preemble + "" + isDev + "]";
		}
	}
	
	
	public class Note{
		private String name;
		
		public Note(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Note [name=" + name + "]";
		}
	}
	
	
	@Bean
	@Conditional(NoteExistCondition.class)
	public Note note() {
		return new Note("My Note");
	}
	

	@Bean
	public Worker worker() {
		return new Worker(greetingText, preemble);
	}
	

	public static void main(String[] args) {
		ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		// environment variables -> more priority than properties file
		Worker worker = appcontext.getBean(Worker.class);
		System.out.println(worker.toString());
		
		NoteService noteService = appcontext.getBean(NoteService.class);
		noteService.addNote("hey");
		
		Note note = appcontext.getBean(Note.class);
		System.out.println(note);
		
		// GOOD OOP PRACTICES FOR INJECTION- FILED/ SETTER OR CONSTRUCTOR
		
		// @PostConstruct(after loading the  - initialises the beans) and @PreDestroy(as application context closes - does not work with prototype beans)
		
		SpelExample spelExample = appcontext.getBean(SpelExample.class);
		System.out.println(spelExample.time);
		System.out.println(spelExample.pi);
		System.out.println(spelExample.noteServiceName);
		System.out.println(spelExample.area);
		System.out.println(spelExample.testBoolean);
		System.out.println(spelExample.randomNote);
		
	}
}
