package org.oracle.note.dao;

import java.util.List;
import java.util.Map;

import org.oracle.note.entity.Share;

public interface ShareDao {
	public Share findById(String id);
	public List<Map> findLikeTitle(String keyword);
	public Share findByNoteId(String noteId);
	public void save(Share share);

}








