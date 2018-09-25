package org.oracle.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//扫描，将组建扫描到Spring容器
@Aspect//将组件设置为切面组件
public class ServiceLogger {
	@Before("within(org.oracle.note.service..*)")
	public void alogger(){
		System.out.println("进入Service处理");
		
		
		
		
	}

}
