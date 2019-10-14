package br.com.alura.loja.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String all() {
		List<Carrinho> carrinhos = new CarrinhoDAO().busca();
		return new Carrinho().toXML(carrinhos);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{id}")
	public String buscaPorId(@PathParam("id") long id) {
		return new CarrinhoDAO().busca(id).toXML();
	}

}