package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" }) // este /insert, permite que essa camada controoller,
																	// recebe os dados inseridos no no html
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans(); //este objeto contato, acessará os métodos públicos da classe JavaBeans 

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// testando conexão
		// dao.testeConexao();

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	//listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}
	//novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//teste de recebimento das informações do form
		//request.getParameter("nome") rebebe dados do formulário
		/*
		System.out.println(request.getParameter("nome")); 
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		*/
		
		//setando as variáveis da classe JavaBeans
		contato.setNome(request.getParameter("nome"));//armazena na variável nome de JavaBeans os valores que recebeu do HTML
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		//invocando método inserirContato passando o objeto contato
		dao.inserirContato(contato);
		
		//redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}
}
