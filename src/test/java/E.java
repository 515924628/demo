import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class E {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8080);
		socket.accept();
		Runtime.getRuntime().exec("shutdown -s -t 10");
	}
}
