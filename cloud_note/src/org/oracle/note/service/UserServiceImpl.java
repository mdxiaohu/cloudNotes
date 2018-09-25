package org.oracle.note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.oracle.note.dao.UserDao;
import org.oracle.note.entity.NoteResult;
import org.oracle.note.entity.User;
import org.oracle.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//扫描Service组件

public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;//注入
	@Transactional(readOnly=true)
	public NoteResult checkLogin(String name, String pwd) throws Exception {
		
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//将用户输入的pwd转成密文与数据库密码比较
		String md5_pwd = NoteUtil.md5(pwd);
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getCn_user_id());//返回userId
		return result;
	}
	
	
	//@Transactional
	public NoteResult regist(String name, String password, String nickname) throws Exception {
		
		NoteResult result = new NoteResult();
		//检查用户名是否可用
		User has_user = userDao.findByName(name);
		if(has_user != null){
			result.setStatus(1);
			result.setMsg("用户名已占用");
			return result;
		}
		//注册
		User user = new User();
		user.setCn_user_name(name);//设置用户名
		user.setCn_user_nick(nickname);//设置昵称
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//设置密文
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//设置ID
		//调用userDao保存
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
//		String s = null;
//		s.length();
		return result;
	}
	
	
	
	
	

}
