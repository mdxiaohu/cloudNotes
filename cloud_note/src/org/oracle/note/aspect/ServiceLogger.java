package org.oracle.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//ɨ�裬���齨ɨ�赽Spring����
@Aspect//���������Ϊ�������
public class ServiceLogger {
	@Before("within(org.oracle.note.service..*)")
	public void alogger(){
		System.out.println("����Service����");
		
		
		
		
	}

}
