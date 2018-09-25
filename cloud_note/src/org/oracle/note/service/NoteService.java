package org.oracle.note.service;

import org.oracle.note.entity.NoteResult;

public interface NoteService {
	public NoteResult loadDelete(String userId);
	public NoteResult loadShare(String shareId);
	public NoteResult searchNote(String keyword);
	public NoteResult shareNote(String noteId);
	public NoteResult recycleNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult loadNote(String noteId);
	public NoteResult addNote(String noteTitle,String userId,String bookId);
	public NoteResult loadNotes(String bookId);

}









