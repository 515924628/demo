import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by zpy on 2015/2/16.
 */
public class C {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String[] strings = "%E7%AC%A8%E7%AC%A8".split("%");
		byte[] buff = new byte[20];
		for (int i = 1; i < strings.length; i++) {
			buff[i] = Integer.valueOf(strings[i], 16).byteValue();
		}
		System.out.println(new String(buff, 1, strings.length - 1, "UTF-8"));
	}
}
