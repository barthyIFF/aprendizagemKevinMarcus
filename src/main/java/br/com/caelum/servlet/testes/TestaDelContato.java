package br.com.caelum.servlet.testes;

import java.util.List;

import br.com.caelum.DAO.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaDelContato {

	public static void main(String[] args) {
		ContatoDAO	cdao	=	new	ContatoDAO();
		List<Contato> cs = cdao.getLista();
		
		TestaListaContatos.main(args);
		
		Contato	c = new Contato();
		//Vamos apagar o primeiro contato da tabela
		c = cs.get(0);
		cdao.remove(c);
		
		TestaListaContatos.main(args);
		

	}

}
