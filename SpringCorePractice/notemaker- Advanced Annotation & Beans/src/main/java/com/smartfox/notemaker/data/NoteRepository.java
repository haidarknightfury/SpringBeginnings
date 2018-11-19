package com.smartfox.notemaker.data;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class NoteRepository {
	
	
	@PostConstruct
	public void initialize() {
		System.out.println("initialising note repository");
	}
	
	public String notes[] = {"hello", "world", "kimi", "no","na", "wa"};
	

	public void saveNote(String note) {
		System.out.println("Saving note" + note);
		

	}

}
