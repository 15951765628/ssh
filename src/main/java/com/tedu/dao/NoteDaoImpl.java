package com.tedu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tedu.entity.Note;
import com.tedu.entity.Result;

@Repository("NoteDao")//扫描
public class NoteDaoImpl implements NoteDao{

	
	@Resource//注入
	private HibernateTemplate template;
	
	public void save(Note note){
		template.save(note);
		
	}
	
	public void update(Note note){
		template.update(note);
	}
	
	public void delete(int noteId){
		Note note=new Note();
		note.setNoteId(noteId);
		template.delete(note);
	}
	
	public Note findById(int noteId){
		Note note=template.load(Note.class, noteId);
		return note;
	}
	
	
	public Result<List<Note>> loadNote(int noteId) {
		// TODO Auto-generated method stub
		Result<List<Note>> result =new Result<List<Note>>();
		List<Note> list=new ArrayList<Note>();
		
		try {
			Note note=findById(noteId);
			list.add(note);
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Note>> loadNotes(int type) {
		// TODO Auto-generated method stub
		Result<List<Note>> result =new Result<List<Note>>();
		List<Note> list=new ArrayList<Note>();
		
		try {
			String sql="from Note where ";
			
			sql+=type==1?"username is null ":"username is not null ";
			list=template.find(sql);
			result.setData(list);
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Note>> updateNote(int noteId, String note, Date startdate, Date enddate) {
		// TODO Auto-generated method stub
		Result<List<Note>> result =new Result<List<Note>>();
		List<Note> list=new ArrayList<Note>();
		
		try {
			Note Note=findById(noteId);
			Note.setStartdate(startdate);
			Note.setCreatedate(com.tedu.tools.time.getDate());
			Note.setEnddate(enddate);
			
			Note.setNote(note);
			
			update(Note);
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Note>> createNote(String note, Date startdate, Date enddate, String username) {
		// TODO Auto-generated method stub
		Result<List<Note>> result =new Result<List<Note>>();
		List<Note> list=new ArrayList<Note>();
		
		try {
			Note Note=new Note();
			Note.setStartdate(startdate);
			Note.setCreatedate(com.tedu.tools.time.getDate());
			Note.setEnddate(enddate);
			if(username!=null){
				Note.setUsername(username);
			}
			
			Note.setNote(note);
			
			save(Note);
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Note>> deleteNote(int noteId) {
		// TODO Auto-generated method stub
		Result<List<Note>> result =new Result<List<Note>>();
		List<Note> list=new ArrayList<Note>();
		
		try {
			
			
			delete(noteId);
			
			result.setStatus(0);
		} catch (Exception e) {
			// TODO: handle exception
			result.setStatus(1);
		}
		
		return result;
	}

	public Result<List<Note>> search(String note, int type) {
		// TODO Auto-generated method stub
				Result<List<Note>> result =new Result<List<Note>>();
				List<Note> list=new ArrayList<Note>();
				
				try {
				String sql	="from Note where note like ? and ";
				sql+=type==1?"username is null ":"username is not null ";
					list=template.find(sql,"%"+note+"%");
					result.setData(list);
					result.setStatus(0);
				} catch (Exception e) {
					// TODO: handle exception
					result.setStatus(1);
				}
				
				return result;
	}

}
