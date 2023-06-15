package br.com.caelum.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {
	public	static Connection	conecte(){
		try	{
			/*Essa proxima linha é necessaria quando se trabalha com o servidor Tomcat	7
			ou	posterior*/ 
			//Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection	con	=	null;
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/fj21",	"root",	"greeneYes.22");
		return	con;
		}	catch	(SQLException | ClassNotFoundException	e)	{
			System.out.print("Erro ao conectar o banco de dados. Verifique conecte em Conecta.");
			e.printStackTrace();
			return null;
		}

	}

}
