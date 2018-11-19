package com.smartfox.notemaker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.smartfox.notemaker.data.NoteRepository;
import com.smartfox.notemaker.service.impl.NoteService;


/**
 * Aspects
 *
 *	Logging, transaction management, caching, security
 *	Cross cutting concerns -> 
 * 	System level requirements -> specific logging
 * 	Don't repeat yourself principle - DRY 
 * 	Mixing concerns
 * 	AspectJ for aspecting -> byte code modification 
 * 	Dynamic proxy based -> everything injected in bean factory has a proxy
 * 
 * 	JoinPoint -> the target
 * 	PointCut- > expression that recognises the joinpoint through regExp
 *  Advice -> Code executed at joinpoint recognised by the pointcut
 *  Aspect -> contains all the joinpoints
 *  
 *  
 *  designator("r p.c.m(arg))
 *  r return type, p package, c class, m method 
 *  execution, within, target , @annotatation designator
 *  
 * 
 */

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
@ComponentScan(basePackages = { "com.smartfox.notemaker" })
@EnableAspectJAutoProxy
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
		noteService.addNote("Hello");
		
	}
}
