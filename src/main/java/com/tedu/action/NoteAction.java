package com.tedu.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tedu.entity.Note;
import com.tedu.entity.Result;
import com.tedu.service.NoteService;

@Controller
@Scope("prototype")
public class NoteAction {
	
	@Resource
	private NoteService noteService;
	
	public String loadNote()
	{
		u=noteService.loadNote(noteId);
		return "success";
	}
	
	public String loadNotes()
	{
		u=noteService.loadNotes();
		return "success";
	}
	
	public String updateNote()
	{
		u=noteService.updateNote(noteId,note,startdate,enddate,enabled);
		return "success";
	}
	
	public String createNote()
	{
		u=noteService.createNote(note,startdate,enddate,enabled);
		return "success";
	}
	
	public String deleteNote()
	{
		u=noteService.deleteNote(noteId);
		return "success";
	}
	
	
	
	
	
	private  int noteId;
	private  String note;
	private  Date createdate;
	private  Date enddate;
	private  Date startdate;
	private  int enabled;
	private Result<List<Note>> u;

	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Result<List<Note>> getU() {
		return u;
	}

	public void setU(Result<List<Note>> u) {
		this.u = u;
	}
	
}
