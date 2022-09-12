/* É O PRÓPRIO CONTROLLER DA ARQUITETURA (MVC)
 *
 * Função: faz o intermédio entre a camada VIEW e MODEL, todas as requisições que chegam de VIEW passam por aqui,
 * e então vão para o MODEL. Logo, o MODEL devolve uma resposta, que também passa por aqui e vai para VIEW.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select" }) // este /insert, permite que essa camada
																			// controoller,
// recebe os dados inseridos no no html
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans(); // este objeto contato, acessará os métodos públicos da classe JavaBeans

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// testando conexão
		// dao.testeConexao();

		String action = request.getServletPath();
		System.out.println(action); //printa as requisições que chegam do servlet

		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContatos(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando objeto que receberá os dados de JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos(); // objeto criado que executa o método listarContatos().
		// Encominhar a lista gerada ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response); // encaminha o objeto lista ao documento agenda.jsp

		// testando o recebimento da lista
		/*
		 * for(int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getEmail()); }
		 */
	}

	// novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento das informações do form
		// request.getParameter("nome") rebebe dados do formulário
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */

		// setando as variáveis da classe JavaBeans
		contato.setNome(request.getParameter("nome"));// armazena na variável nome de JavaBeans os valores que recebeu
														// do HTML
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		// invocando método inserirContato passando o objeto contato
		dao.inserirContato(contato);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}
	//Editar contatos
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response) {
		String idcon = request.getParameter("idcon"); // recebe o id do contato que será alterado
		//System.out.println(idcon); //printa o id do contato que foi clicado no botão "Editar"
		contato.setIdcon(idcon);
	}
}
