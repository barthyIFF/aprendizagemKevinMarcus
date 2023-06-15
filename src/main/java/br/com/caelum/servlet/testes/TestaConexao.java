package br.com.caelum.servlet.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.DAO.Conecta;



public class TestaConexao {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection	conexao	=	new	Conecta().conecte();
		System.out.println("Conexão	aberta!");
		conexao.close();
	}

}
