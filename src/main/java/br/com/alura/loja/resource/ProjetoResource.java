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
import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

@Path("projetos")
public class ProjetoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String all() {
		List<Projeto> projetos = new ProjetoDAO().busca();
		return new Projeto().toXML(projetos);
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{id}")
	public String buscaPorId(@PathParam("id") long id) {
		return new ProjetoDAO().busca(id).toXML();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String salvarProjeto(String conteudo) {
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		new ProjetoDAO().adiciona(projeto);
		return "<status>Projeto cadastrado com sucesso!!!</status>";
	}

}
