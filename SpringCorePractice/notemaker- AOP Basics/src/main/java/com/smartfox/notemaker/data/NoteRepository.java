package com.smartfox.notemaker.data;

import org.springframework.stereotype.Repository;

@Repository
public class NoteRepository {

	public void saveNote(String note) {
		System.out.println("Saving note" + note);

	}

}
