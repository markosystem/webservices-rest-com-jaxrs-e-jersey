package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Utils {
	/**
	 * variáveis de configurações
	 */
	String resourceConfig;
	String url;
	ResourceConfig configObject;
	URI uriObject;
	HttpServer serverObjetct;

	/**
	 * Construtor padrão para inicialização da classe
	 * 
	 * @param resourceConfig
	 * @param url
	 * @throws IOException
	 */
	public Utils(String resourceConfig, String url) throws IOException {
		super();
		setResourceConfig(resourceConfig);
		setUrl(url);
		initServer();
	}

	/**
	 * Cria instância do servidor para iniciar ou parar
	 * 
	 * @throws IOException
	 */
	public void initServer() throws IOException {
		setConfigObject(new ResourceConfig().packages(getResourceConfig()));
		setUriObject(URI.create(getUrl()));
	}

	/**
	 * Inicia o servidor
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {
		setServerObjetct(GrizzlyHttpServerFactory.createHttpServer(getUriObject(), getConfigObject()));
		System.out.println("Inicializando o servidor em ".concat(getUrl()));
		System.in.read();
	}

	/**
	 * Para o servidor
	 */
	public void stop() {
		getServerObjetct().stop();
	}

	public String getResourceConfig() {
		return resourceConfig;
	}

	public void setResourceConfig(String resourceConfig) {
		this.resourceConfig = resourceConfig;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ResourceConfig getConfigObject() {
		return configObject;
	}

	public void setConfigObject(ResourceConfig configObject) {
		this.configObject = configObject;
	}

	public URI getUriObject() {
		return uriObject;
	}

	public void setUriObject(URI uriObject) {
		this.uriObject = uriObject;
	}

	public HttpServer getServerObjetct() {
		return serverObjetct;
	}

	public void setServerObjetct(HttpServer serverObjetct) {
		this.serverObjetct = serverObjetct;
	}
}
