package org.oracle.note.controller.user;

import javax.annotation.Resource;

import org.oracle.note.entity.NoteResult;

import org.oracle.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//扫描控制组件
@RequestMapping("/user")
public class LoginController {
    
	@Resource
	private UserService  userService ;//注入
	
	@RequestMapping("/login.do")
	@ResponseBody//将返回值NoteResult转成json输出
	public NoteResult execute(String name,String pwd)throws Exception{
		NoteResult result = userService.checkLogin(name, pwd);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
}
