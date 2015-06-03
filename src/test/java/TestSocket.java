import java.io.IOException;
import java.net.Socket;

public class TestSocket {
	public static void main(String[] args) {
		for (int i = 0; i < 65535; i++) {
			final int finalI = i;
			new Thread(()->{
				try {
					Socket socket = new Socket("115.28.213.208", finalI);
					System.out.println(finalI);
				} catch (IOException e) {
				}
			}).start();
		}
	}
}
