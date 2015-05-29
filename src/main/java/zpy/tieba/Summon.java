package zpy.tieba;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class Summon {
	public static void main(String[] args) throws IOException, InterruptedException {
		Summon summon = (Summon) getBean("summon");
		WebClient client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setCssEnabled(false);
		CookieManager cookieManager = new CookieManager();
		cookieManager.addCookie(new Cookie("tieba.baidu.com", "BDUSS", "VRaGY2YU9ufmpwaWl1RGN5ZUs0cy1wbnRMdHJ6fnUxVlVteThyVENMU1VJWVJWQVFBQUFBJCQAAAAAAAAAAAEAAABzYZ4w1eK-zcrHX8nxSUQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJSUXFWUlFxVNm"));
		client.setCookieManager(cookieManager);

		HtmlPage page = client.getPage("http://tieba.baidu.com/mo/q---9D0AAAE22EE71534CB75224FCA6EE5C1%3AFG%3D1--1-3-0--2--wapp_1432455465300_324/m?kz=3783792177&is_bakan=0&lp=5010&pinf=1_2_0");

		for (int i = 0; i < 10; i++) {
			HtmlInput co = (HtmlInput) page.querySelector("input[name=co]");
			co.setValueAttribute(summon.context(i,5));
			HtmlInput sub = (HtmlInput) page.querySelector("input[name=sub1]");
			sub.click();
			Thread.sleep(2000);
		}

	}

	private JdbcTemplate jdbcTemplate;

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String context(int start, int count) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT name FROM t_zpy LIMIT ?,?;", start * count, count);
		StringBuilder sb = new StringBuilder();
		for (Map<String, Object> map : list) {
			sb.append("@").append(map.get("name")).append(" ");
		}
		return sb.toString();
	}

	public static Object getBean(String id) {
		return new ClassPathXmlApplicationContext("tieba.xml").getBean(id);
	}
}
