package org.oracle.note.dao;

import java.util.List;
import java.util.Map;

import org.oracle.note.entity.Note;


public interface NoteDao {
    public List<Map> findDelete(String userId);
	public void updateStatus(String noteId);
	public void update(Note note);
	public Note findById(String noteId);
	public void save(Note note);
	public List<Map> findByBookId(String bookId);
	
	
	
	
	
	
	
}
