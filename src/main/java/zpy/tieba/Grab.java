package zpy.tieba;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public class Grab {
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) throws IOException {
		Grab g = (Grab) new ClassPathXmlApplicationContext("tieba.xml").getBean("grab");
		for (int i = 2; i < 6; i++) {
			String url = "http://tieba.baidu.com/f/like/furank?kw=java&pn=" + i;
			Document document = Jsoup.connect(url).get();
			for (Element element : document.select("a").select("[username]")){
				String name = element.html();
				g.jdbcTemplate.update("INSERT INTO t_zpy (name) VALUES (?);", name);
			}
		}
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
