package zpy.tieba;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.springframework.stereotype.Service;
import zpy.util.Spring;

import java.io.IOException;
import java.util.Map;

@Service
public class Summon {
	public static void main(String[] args) throws IOException, InterruptedException {
		Summon summon = (Summon) Spring.get("tieba.xml", "summon");
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

	public String context(int start, int count) {

		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

}
