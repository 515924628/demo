import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;

public class TieBa {
	public static void main(String[] args) throws IOException {
		WebClient client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setCssEnabled(false);
		CookieManager cookieManager = new CookieManager();
		cookieManager.addCookie(new Cookie("tieba.baidu.com", "BDUSS", "cookie BDUSS的值"));
		client.setCookieManager(cookieManager);

		HtmlPage page = client.getPage("http://tieba.baidu.com/mo/m?kw=java");

		DomNodeList<DomNode> list = page.querySelectorAll(".i");

		for (DomNode i : list) {
			DomNode p = i.querySelector("p");
			if (p.asText().contains("回0")) {//判断是不是二楼
				HtmlAnchor a = (HtmlAnchor) i.querySelector("a");
				String href = a.getAttribute("href");
				HtmlPage tpage = client.getPage("http://tieba.baidu.com" + href);
				HtmlInput co = (HtmlInput) tpage.querySelector("input[name=co]");
				co.setValueAttribute("这个字符串是回的帖子");
				HtmlInput sub1 = (HtmlInput) tpage.querySelector("input[name=sub1]");
				sub1.click();
			}
		}

		client.closeAllWindows();
	}
}
