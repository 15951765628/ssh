package com.tedu.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.NoteDao;
import com.tedu.entity.Note;
import com.tedu.entity.Result;

@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService{

	
	@Resource
	private NoteDao noteDao;	
	
	
	public Result<List<Note>> loadNote(int noteId) {
		// TODO Auto-generated method stub
		return noteDao.loadNote(noteId);
	}

	public Result<List<Note>> loadNotes() {
		// TODO Auto-generated method stub
		return noteDao.loadNotes();
	}

	public Result<List<Note>> updateNote(int noteId, String note, Date startdate, Date enddate, int enabled) {
		// TODO Auto-generated method stub
		return noteDao.updateNote(noteId,note,startdate,enddate,enabled);
	}

	public Result<List<Note>> createNote(String note, Date startdate, Date enddate, int enabled) {
		// TODO Auto-generated method stub
		return noteDao.createNote(note,startdate,enddate,enabled);
	}

	public Result<List<Note>> deleteNote(int noteId) {
		// TODO Auto-generated method stub
		return noteDao.deleteNote(noteId);
	}

}
