package org.oracle.note.controller.note;

import javax.annotation.Resource;

import org.oracle.note.entity.NoteResult;
import org.oracle.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class LoadShareController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadShare.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		
		NoteResult result = noteService.loadShare(shareId);
		return result;
	}
	
	
	
	
	
	
	

}
