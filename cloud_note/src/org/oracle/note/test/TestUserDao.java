package org.oracle.note.test;

import org.oracle.note.dao.UserDao;
import org.oracle.note.entity.User;


public class TestUserDao extends TestBase{
	
	public static void main(String[] args) {
		
		UserDao userdao = getContext()
				 .getBean("userDao",UserDao.class);
		User user = userdao.findByName("demo");
		if(user == null){
			System.out.println("用户名不正确");
		}else{
			System.out.println(user.getCn_user_password());
		}
		
				
				
		
		
		
		
		
	}

}
