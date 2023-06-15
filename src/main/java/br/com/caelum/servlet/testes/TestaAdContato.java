package br.com.caelum.servlet.testes;

import java.util.Calendar;

import br.com.caelum.DAO.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaAdContato {

	public static void main(String[] args) {
		
		Contato	c	=	new	Contato();
		
		c.setNome("nomeTeste_Claudio");
		c.setEmail("emailTeste_Claudio");
		c.setEndereco("enderecoTeste_Claudio");
		//Adicionando data atual
		c.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO	cdao	=	new	ContatoDAO();
		
		cdao.adiciona(c);
		
		System.out.println("Novo Contato Gravado no Banco.");

	}

}
