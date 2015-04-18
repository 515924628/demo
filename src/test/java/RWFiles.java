import java.io.*;

/**
 * Created by zpy on 2015/1/26.
 * test
 */
public class RWFiles {
	public static final String start = "UTF-8";
	public static final String end = "GBK";

	public static void main(String[] args) throws IOException {
		File file = new File("d:\\test.txt");
		StringBuilder builder = new StringBuilder();

		BufferedReader bufferedReader = new BufferedReader(new
				InputStreamReader(new FileInputStream(file), start));
		bufferedReader.lines().forEach(s -> builder.append(s).append("\r\n"));

		System.out.println(builder.toString());

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(builder.toString().getBytes(end));
		fileOutputStream.close();

	}
}
