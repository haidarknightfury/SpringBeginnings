package com.smartfox.notemaker.service.impl;

import org.springframework.stereotype.Service;

import com.smartfox.notemaker.aspect.Loggable;
import com.smartfox.notemaker.data.NoteRepository;

@Service
public class NoteService {
	
	private NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@Loggable
	public String addNote(String note) {
		this.noteRepository.saveNote(note);
		return note+ "BAKA";
	}
}
