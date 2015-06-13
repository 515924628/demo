package zpy.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
	public static Object get(String xml, String id) {
		return new ClassPathXmlApplicationContext(xml).getBean(id);
	}
}
