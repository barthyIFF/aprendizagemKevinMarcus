package br.com.caelum.servlet.testes;

import java.util.List;

import br.com.caelum.DAO.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaListaContatos {

	public static void main(String[] args) {
		ContatoDAO	cdao	=	new	ContatoDAO();
		
		List<Contato> cs = cdao.getLista();
		
		for	(Contato c : cs)	{
			System.out.println("Nome: " + c.getNome());
			System.out.println("Email:	" + c.getEmail());
			System.out.println("Endereço: " + c.getEndereco());
			System.out.println("Data de Nascimento: "+
					c.getDataNascimento().getTime() + "\n");
			
		}
		
		

	}

}
