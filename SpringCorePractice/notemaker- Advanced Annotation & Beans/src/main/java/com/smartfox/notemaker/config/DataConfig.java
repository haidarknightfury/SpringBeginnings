package com.smartfox.notemaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smartfox.notemaker.data.NoteRepository;

@Configuration
public class DataConfig {
	
	@Bean
	public NoteRepository noteRepository() {
		return new NoteRepository();
	}
	
	
	
}
