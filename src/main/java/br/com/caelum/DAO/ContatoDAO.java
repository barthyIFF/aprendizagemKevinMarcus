package br.com.caelum.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.modelo.Contato;

public class ContatoDAO {
	private	Connection	conexao;
	
	/*public	ContatoDAO() throws ClassNotFoundException {
		this.conexao = new Conecta().conecte();
	}*/
	
	
	
	public void adiciona(Contato contato) {		
		String	sql	=	"insert into contatos "	+
				"(nome, email, endereco, dataNascimento)"	+
				"	values	(?,?,?,?)";

		try	{
			if (conexao == null) {
				this.conexao = Conecta.conecte();
			}

			//prepara o	statement	para	inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//seta	os	valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4,	new	Date(
				contato.getDataNascimento().getTimeInMillis()));	
			//executa
			stmt.execute();
			stmt.close();
		} catch	(SQLException e)	{
			acoesDaExcecao("adiciona", e);
			throw new	RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
		try	{	
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.
					prepareStatement("select * from contatos");
			ResultSet	rs	=	stmt.executeQuery();
			
			while	(rs.next())	{
				Contato	contato	= new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return	contatos;
		} catch (SQLException e) {
			acoesDaExcecao("getLista", e);
			throw new	RuntimeException(e);
		}
	}
	
	public	void	altera(Contato	contato) {
		String	sql	=	"update contatos set nome=?, email=?,"+
				"endereco=?, dataNascimento=? where id=?";	
	try	{
		PreparedStatement stmt = conexao
				.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4,	new	Date(contato.getDataNascimento()
										.getTimeInMillis()));
		stmt.setLong(5,	contato.getId());
		stmt.execute();
		stmt.close();
		}	catch	(SQLException	e)	{
			acoesDaExcecao("altera", e);
			throw new	RuntimeException(e);
		}
	}
	
	public void remove(Contato	contato) {
		try	{
			PreparedStatement stmt = conexao
					.prepareStatement("delete	from	contatos	where	id=?");
			stmt.setLong(1,	contato.getId());
			stmt.execute();
			stmt.close();
		}	catch	(SQLException	e)	{
			acoesDaExcecao("remove", e);
			throw new	RuntimeException(e);
		}
	}
	
	private void acoesDaExcecao(String nomeMetodo, SQLException e) {
		System.out.print("Erro de banco de dados no metodo "+nomeMetodo+" da classe ContatoDAO.");
		e.printStackTrace();
		throw new	RuntimeException(e);
	}

	
}
