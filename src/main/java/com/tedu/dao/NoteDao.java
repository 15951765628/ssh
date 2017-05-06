package com.tedu.dao;

import java.util.Date;
import java.util.List;

import com.tedu.entity.Note;
import com.tedu.entity.Result;

public interface NoteDao {

	Result<List<Note>> loadNote(int noteId);

	Result<List<Note>> loadNotes(int type);

	Result<List<Note>> updateNote(int noteId, String note, Date startdate, Date enddate);

	Result<List<Note>> createNote(String note, Date startdate, Date enddate, String username);

	Result<List<Note>> deleteNote(int noteId);

	Result<List<Note>> search(String note, int type);

}
