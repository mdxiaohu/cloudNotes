package org.oracle.note.service;

import org.oracle.note.entity.NoteResult;

public interface NoteBookService {
	
	public NoteResult loadBooks(String userId);
	public NoteResult addBook(String bookName,String userId);

}










