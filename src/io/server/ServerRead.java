package io.server;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerRead implements Runnable {

	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				String so = scanner.nextLine();
				OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
				PrintWriter pw = new PrintWriter(os);
				pw.println(so);
				os.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			scanner.close();
		}
	}

}
