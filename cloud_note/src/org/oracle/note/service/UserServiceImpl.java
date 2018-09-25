package org.oracle.note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.oracle.note.dao.UserDao;
import org.oracle.note.entity.NoteResult;
import org.oracle.note.entity.User;
import org.oracle.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//ɨ��Service���

public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;//ע��
	@Transactional(readOnly=true)
	public NoteResult checkLogin(String name, String pwd) throws Exception {
		
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//���û������pwdת�����������ݿ�����Ƚ�
		String md5_pwd = NoteUtil.md5(pwd);
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("���벻��ȷ");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		result.setData(user.getCn_user_id());//����userId
		return result;
	}
	
	
	//@Transactional
	public NoteResult regist(String name, String password, String nickname) throws Exception {
		
		NoteResult result = new NoteResult();
		//����û����Ƿ����
		User has_user = userDao.findByName(name);
		if(has_user != null){
			result.setStatus(1);
			result.setMsg("�û�����ռ��");
			return result;
		}
		//ע��
		User user = new User();
		user.setCn_user_name(name);//�����û���
		user.setCn_user_nick(nickname);//�����ǳ�
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//��������
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//����ID
		//����userDao����
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
//		String s = null;
//		s.length();
		return result;
	}
	
	
	
	
	

}
