package com.smartfox.notemaker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpelExample {
	
	@Value("#{T(System).currentTimeMillis()}")
	public String time;
	
	@Value("#{3.142}")
	public String pi;
	
	@Value("#{noteService.getServiceName()}")
	public String noteServiceName;
	
	
	@Value("#{2 * T(java.lang.Math).PI * 3}")
	public String area;
	
	// Can also use enhanced if statements
	@Value("#{2 eq 2}")
	public Boolean testBoolean;
	
	@Value("#{noteRepository.notes[T(java.lang.Math).random() * noteRepository.notes.length]}")
	public String randomNote;
	
}
