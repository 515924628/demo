package zpy.tieba;

import org.jsoup.nodes.Element;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import zpy.util.JsoupReq;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insert {

	public static void main(String[] args) throws IOException {
		String url = "http://tieba.baidu.com/f/like/furank?kw=java&pn=";
		String tableName = "java8" + new SimpleDateFormat("MM_dd").format(new Date());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) new ClassPathXmlApplicationContext("jdbc.xml").getBean("jdbcTemplate");
		jdbcTemplate.update("CREATE TABLE " + tableName + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL, exp INT NOT NULL, level INT NOT NULL)");
		for (int i = 1; i <= 5; i++) {
//			Java8使用
			JsoupReq.get(url + i).select(".drl_list_item").stream().forEach(item ->
					jdbcTemplate.update(
					"INSERT INTO " + tableName + "(name, exp, level) VALUES (?,?,?);",
					item.select("a[username]").html(),
					item.select(".drl_item_title").select("div").attr("class").substring(5),
					item.select(".drl_item_exp").select("span").html()
			));

//			java7使用
//			for (Element item : JsoupReq.get(url + i).select(".drl_list_item")) {
//				jdbcTemplate.update(
//						"INSERT INTO " + tableName + "(name, exp, level) VALUES (?,?,?);",
//						item.select("a[username]").html(),
//						item.select(".drl_item_title").select("div").attr("class").substring(5),
//						item.select(".drl_item_exp").select("span").html()
//				);
//			}
		}
	}
}
