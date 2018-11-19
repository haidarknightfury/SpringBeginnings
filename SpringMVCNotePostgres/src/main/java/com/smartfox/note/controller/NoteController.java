package com.smartfox.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.note.domain.Note;
import com.smartfox.note.dto.NoteDTO;
import com.smartfox.note.repository.NoteRepository;

@RestController
public class NoteController {
	
	@Autowired
	NoteRepository noteRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public NoteDTO getNote() {
		NoteDTO notedt = new NoteDTO("hello world", "first");
		Note note = new Note();
		note.setTitle("first");
		note.setBody("body");
		
		noteRepository.save(note);
		return notedt;
	}
	
}
