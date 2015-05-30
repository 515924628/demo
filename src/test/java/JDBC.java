import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBC {
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("jdbc.xml").getBean("hibernateTemplate");
	}
}
