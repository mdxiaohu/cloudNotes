package org.oracle.note.controller.note;

import javax.annotation.Resource;

import org.oracle.note.entity.NoteResult;
import org.oracle.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String noteTitle, String userId, String bookId){		
		NoteResult result = noteService.addNote(noteTitle, userId, bookId);
		return result;
	}
	
	
	
	
	
	
	

}
