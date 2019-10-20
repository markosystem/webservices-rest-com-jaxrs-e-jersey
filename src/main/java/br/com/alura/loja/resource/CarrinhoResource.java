package br.com.alura.loja.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/json")
	public String buscaPorIdJson(@PathParam("id") long id) {
		return new CarrinhoDAO().busca(id).toJson();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response salvarCarrinho(String conteudo) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
        new CarrinhoDAO().adiciona(carrinho);
        URI uri = URI.create("/carrinhos/" + carrinho.getId());
        return Response.created(uri).build();
	}
}