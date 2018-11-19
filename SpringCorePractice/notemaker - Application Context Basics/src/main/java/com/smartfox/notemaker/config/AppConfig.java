package com.smartfox.notemaker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.smartfox.notemaker.data.NoteRepository;
import com.smartfox.notemaker.service.NoteService;

@Configuration
@Import(DataConfig.class)
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
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
			System.out.println("new instance");
			this.text = text;
			this.preemble = preemble;
		}

		@Override
		public String toString() {
			return "Worker [text=" + text + ", preemble=" + preemble + "" + isDev + "]";
		}
	}

	//
	// @Bean
	// @Profile("dev")
	// public Worker workerDev() {
	// return new Worker("Hello", greetingText);
	// }
	//
	// @Bean
	// @Profile("prod")
	// public Worker workerProd() {
	// return new Worker("Bad", greetingText);
	// }

	@Bean
	@Scope("prototype")
	public Worker worker() {
		return new Worker(greetingText, preemble);
	}

	// NoteRepository injected from DataConfig
	@Bean
	public NoteService noteService(NoteRepository noteRepository) {
		return new NoteService(noteRepository);
	}

	public static void main(String[] args) {
		ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		NoteService noteservice = appcontext.getBean(NoteService.class);
		noteservice.addNote(" Hello");

		NoteRepository noteRepo = (NoteRepository) appcontext.getBean("noteRepository");
		noteRepo.saveNote(" World");

		// environment variables -> more priority than properties file
		Worker worker = appcontext.getBean(Worker.class);
		System.out.println(worker.toString());
		
		Worker worker2 = appcontext.getBean(Worker.class);
		System.out.println(worker2.toString());
	}
	
	
	// Bean scope - Singleton beans - careful for static data
	// Prototype Bean - new Instance each time - available for garbage collection
	// Session scoped beans - one instance per user session - session specific data in that bean - definition in bean factory
	// Request scoped bean - one instance per request - web environment - Defn in bean factory + collected in garbage factory
	

	// Proxies - aspects -add behaviour to class - transaction management + caching
	// every class loaded get 1 proxy
	// 2 Mechanism - JDK based proxies / CGLIB - subclass model
	// Code reduction - Proxies add behaviour to public methods
}
