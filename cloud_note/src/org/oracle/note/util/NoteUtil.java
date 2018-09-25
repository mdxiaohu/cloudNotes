package org.oracle.note.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String md5(String msg) throws NoSuchAlgorithmException{
		//����md5��msg����
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();
		byte[] output = md.digest(input);//���ֽ���Ϣ����
		//��MD5�����output���ת���ַ���
		String result = Base64.encodeBase64String(output);
		return result;
		
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		//System.out.println(md5("1234"));
		System.out.println(createId());
	}
	
	
	
	
	
	
	
	
	
	

}
