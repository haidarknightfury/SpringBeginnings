package com.smartfox.notemaker.service.impl;

import org.springframework.stereotype.Service;

import com.smartfox.notemaker.data.NoteRepository;

@Service
public class NoteService {
	
	private NoteRepository noteRepository;

	// Automatically injected when only constructor
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public void addNote(String note) {
		this.noteRepository.saveNote(note);
	}
	
	
	public String getServiceName() {
		return "NoteService";
	}
}
