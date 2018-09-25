package org.oracle.note.dao;

import java.util.List;

import org.oracle.note.entity.NoteBook;

public interface NoteBookDao {
	
	public List<NoteBook> findByUser(String userId);
	public void save(NoteBook book);

}










