package br.com.alura.loja;

import java.io.IOException;

public class Servidor {

	public static void main(String[] args) throws IOException {
		Utils server = new Utils("br.com.alura.loja", "http://localhost:8080/");
		server.start();
	}

}
