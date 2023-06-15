package br.com.caelum.servlet.testes;

import java.util.List;

import br.com.caelum.DAO.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaAltContato {

	public static void main(String[] args) {
		ContatoDAO	cdao	=	new	ContatoDAO();
		List<Contato> cs = cdao.getLista();		
		Contato	c = new Contato();
		//Vamos alterar o primeiro contato da tabela
		c = cs.get(0);
		
		//Vamos alterar somente o nome
		c.setNome("nomeALTERADO_Claudio");
		
		cdao.altera(c);
		
		c = cs.get(0);
		System.out.println("Nome apos a alteração: "+c.getNome());

	}

}
