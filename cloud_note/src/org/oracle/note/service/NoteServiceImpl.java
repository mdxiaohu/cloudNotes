package org.oracle.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.oracle.note.dao.NoteDao;
import org.oracle.note.dao.ShareDao;
import org.oracle.note.entity.Note;
import org.oracle.note.entity.NoteResult;
import org.oracle.note.entity.Share;
import org.oracle.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao notedao;
	
	@Resource
	private ShareDao sharedao;

	public NoteResult loadNotes(String bookId) {
		NoteResult result = new NoteResult();
		List<Map> list = notedao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(list);
		return result;
	}

	public NoteResult addNote(String noteTitle, String userId, String bookId) {
		NoteResult result = new NoteResult();
		//��ӱʼ�
		Note note = new Note();
		note.setCn_note_title(noteTitle);
		note.setCn_user_id(userId);
		note.setCn_notebook_id(bookId);
		note.setCn_note_status_id("1");
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		notedao.save(note);
		result.setStatus(0);
		result.setMsg("�����ʼǳɹ�");
		result.setData(noteId);
		return result;
	}

	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = notedao.findById(noteId);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(note);
		return result;
	}

	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody) {
		NoteResult result = new NoteResult();
		//����
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		notedao.update(note);
		result.setStatus(0);
		result.setMsg("���±ʼǳɹ�");
		return result;
	}

	public NoteResult recycleNote(String noteId) {
		NoteResult result = new NoteResult();
		notedao.updateStatus(noteId);
		result.setStatus(0);
		result.setMsg("ɾ���ʼǳɹ�");
		return result;
	}

	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//���ñʼ��Ƿ�����
		Share has_share = sharedao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("�ñʼ��ѱ������");
			return result;
		}
		//δ���������������
		Note note = notedao.findById(noteId);
		Share share = new Share();
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_note_id(noteId);
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		sharedao.save(share);
		
		result.setStatus(0);
		result.setMsg("����ʼǳɹ�");
		return result;
	}

	public NoteResult searchNote(String keyword) {
		NoteResult result = new NoteResult();
		if(keyword != null && !"".equals(keyword)){
			keyword = "%"+keyword+"%";
		}else{
			keyword = "%";
		}
		
		List<Map> list = sharedao.findLikeTitle(keyword);
		result.setData(list);
		result.setStatus(0);
		result.setMsg("��������ʼǳɹ�");
		return result;
	}

	public NoteResult loadShare(String shareId) {
		Share share = sharedao.findById(shareId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ����ʼǳɹ�");
		result.setData(share);
		return result;
	}

	public NoteResult loadDelete(String userId) {
		NoteResult result = new NoteResult();
		List<Map> list = notedao.findDelete(userId);
		result.setStatus(0);
		result.setMsg("��ѯ����վ��Ϣ�ɹ�");
		result.setData(list);
		return result;
	}

	
	
	
	
	
	
	
	
	
}
