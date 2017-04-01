package com.tedu.entity;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

private  int noteId;
private  String note;
private  Date createdate;
private  Date enddate;
private  Date startdate;
private  int enabled;
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

}
