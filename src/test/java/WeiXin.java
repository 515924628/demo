import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zpy on 2015/3/28.
 * 微信
 */
public class WeiXin {
	public static void main(String[] args) throws IOException {
		WebClient client = new WebClient(BrowserVersion.CHROME);//使用chrome打开
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		HtmlPage page = client.getPage("http://tieba.baidu.com/f?kw=java");
		HtmlImage image = (HtmlImage) page.querySelector(".card_head_img");
		File file = new File("D:\\a.png");


		client.closeAllWindows();
	}
}
