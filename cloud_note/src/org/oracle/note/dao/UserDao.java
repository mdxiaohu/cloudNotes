package org.oracle.note.dao;

import org.oracle.note.entity.User;

public interface UserDao {

	public User findByName(String name);
	public void save(User user);
	
}









