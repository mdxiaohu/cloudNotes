package org.oracle.note.aspect;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {
	
	@AfterThrowing(throwing="e",
			pointcut="within(org.oracle.note.controller..*)")
	public void log(Exception e){
		//���쳣��Ϣд���ļ�
		System.out.println("��¼�쳣��Ϣ��"+e);
		try {
			FileWriter fw = new FileWriter("F:\\error.txt");
			PrintWriter out = new PrintWriter(fw);
			e.printStackTrace(out);
			out.flush();
			out.close();
			fw.close();
		} catch (Exception e2) {
			System.out.println("��¼�쳣��Ϣʧ��");
		}
	}
	
	
	
	
	
	
	
	
	

}
