package com.smartfox.notemaker.service;

import com.smartfox.notemaker.data.NoteRepository;

public class NoteService {
	
	private NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public void addNote(String note) {
		this.noteRepository.saveNote(note);
	}
}
