package br.com.alura.loja.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.APPLICATION_XML)
	public String salvarCarrinho(String conteudo) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		return "<status>Carrinho cadastrado com sucesso!!!</status>";
	}
/*
 <br.com.alura.loja.modelo.Carrinho>
  <produtos>
    <br.com.alura.loja.modelo.Produto>
      <preco>100.0</preco>
      <id>888</id>
      <nome>Jogo de esporte</nome>
      <quantidade>2</quantidade>
    </br.com.alura.loja.modelo.Produto>
  </produtos>
  <rua>Rua Vergueiro 3185, 8 andar</rua>
  <cidade>São Paulo</cidade>
  <id>2</id>
</br.com.alura.loja.modelo.Carrinho>
 */
}