/*	FAZ PARTE DO MODEL
 * 	
 * Função da classe: fazer a conexão diretamente com o banco de dados*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // importa a classe que permite executar um comando sql pelo Java
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* Módulo de conexão */
	/* Parâmetros de conexão com o banco de dados */
	private String driver = "com.mysql.cj.jdbc.Driver"; // chamando o driver para conectar ao BD

	// string de conexão
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	// user e senha do banco de dados
	private String user = "root";
	private String password = "123456";

	// Métodos de conexão
	// classe que está dentro do driver de conexão
	private Connection conectar() {
		Connection con = null; // estabelecerá uma conexão com o banco de dados

		try {
			Class.forName(driver); // lê o driver do BD e busca a variável driver
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		// sempre que for fazer algo com o banco de dados, utilizar o try/catch
		try {
			// abrir conexão com o banco
			Connection con = conectar();
			// preparar a query que será executada no banco
			PreparedStatement pst = con.prepareStatement(create);
			// pst.setString: substitui as ? da String create lá em cima
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// executar a query do sql - insere os dados ao BD
			pst.executeUpdate();

			// fechar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	// Pesquisar sobre arraylist
	public ArrayList<JavaBeans> listarContatos() { // vetor dinâmico
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			// abrindo a conexão com o BD
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read); // prepara a execução da variável read que tem o comando
																// SQL
			ResultSet rs = pst.executeQuery(); // recuso do pacote java sql (JDBC), esse comando executa a query do sql

			// o while executará enquanto houver contatos
			while (rs.next()) {
				// variáveis que recebem os dados do banco de dados
				String idcon = rs.getString(1); // variávle idcon recebe o campo/coluna de indice 1 do banco de dados
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// armazena todas as informações que vieram do BD no arraylist
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/** CRUD UPDATE **/
    //selecionar o contato
    public void selecionarContato(JavaBeans contato) {
        String read2 = "select * from contatos where idcon = ?";
        try {
            Connection con = conectar(); // conecta ao banco de dados
            //prepara a query que será executada no banco
            PreparedStatement pst = con.prepareStatement(read2); //recebe a variável que contém o comando que será executado no DB
            pst.setString(1, contato.getIdcon()); // faz a substituição de ? no atributo read2
            ResultSet rs = pst.executeQuery(); //busca as informações do banco para exibir no formulário de contatos
            while(rs.next() ) { //executa equanto o objeto rs tiver um valor
                //seta as variáveis da classe JavaBeans com rs.getString(1) que obtém o conteúdo do campo com id = 1 
                contato.setIdcon(rs.getString(1));
                contato.setNome(rs.getString(2));
                contato.setFone(rs.getString(3));
                contato.setEmail(rs.getString(4));               
            }
            con.close(); // fecha a conexão ao banco de dados
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	// teste de conexão
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */
}
