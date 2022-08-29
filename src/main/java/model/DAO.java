package model;

import java.sql.Connection;
import java.sql.DriverManager;

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
