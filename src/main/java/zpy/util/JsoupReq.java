package zpy.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupReq {
	public static Document get(String url) throws IOException {
		return Jsoup.connect(url)
				.get();
	}
}
