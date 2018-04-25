package io.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		System.out.println("Server started...");
		ServerSocket serverSocket = new ServerSocket(1234);
		Socket socket = serverSocket.accept();
		System.out.println("## Client connected ##");
		try {
			ServerRead serverRead = new ServerRead();
			serverRead.setSocket(socket);
			Thread sRead = new Thread(serverRead);
			sRead.start();

			ServerWrite serverWrite = new ServerWrite();
			serverWrite.setSocket(socket);
			Thread sWrite = new Thread(serverWrite);
			sWrite.start();
		} catch (Exception e) {
			System.out.println("SERVER ERROR: " + e.getMessage());
			serverSocket.close();
		}
	}
}
