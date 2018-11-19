package com.smartfox.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfox.note.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
