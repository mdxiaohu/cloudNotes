package org.oracle.note.controller.note;

import javax.annotation.Resource;

import org.oracle.note.entity.NoteResult;
import org.oracle.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class SearchNoteController {
	
	@Resource
	private NoteService noteService;
	@RequestMapping("/search.do")
	@ResponseBody
	private NoteResult execute(String keyword){
		
		NoteResult result = noteService.searchNote(keyword);
	    return result;
	
	}
	
	

}
