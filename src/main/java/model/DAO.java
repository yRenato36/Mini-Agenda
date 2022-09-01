package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // importa a classe que permite executar um comando sql pelo Java

public class DAO {
	/*Módulo de conexão*/
	/*Parâmetros de conexão com o banco de dados*/
	private String driver = "com.mysql.cj.jdbc.Driver"; //chamando o driver para conectar ao BD
	
	//string de conexão
	private String url = 
			"jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	//user e senha do banco de dados
	private String user = "root";
	private String password = "123456";
	
	//Métodos de conexão
	//classe que está dentro do driver de conexão
	private Connection conectar() {
		Connection con = null; // estabelecerá uma conexão com o banco de dados
		
		try {
			Class.forName(driver); //lê o driver do BD e busca a variável driver
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/*create*/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		//sempre que for fazer algo com o banco de dados, utilizar o try/catch
		try {
			//abrir conexão com o banco
			Connection con = conectar();
			//preparar a query que será executada no banco
			PreparedStatement pst = con.prepareStatement(create);
			//pst.setString: substitui as ? da String create lá em cima
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			
			//executar a query do sql - insere os dados ao 
			pst.executeUpdate();
			
			//fechar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// teste de conexão
	/*public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
}
