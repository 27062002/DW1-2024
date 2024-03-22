package br.edu.ifsp.arq.dw1s5.project2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// configurar a codificação de caracteres da requisição
		req.setCharacterEncoding("UTF-8");
		// obter os dados da requisição
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String options[] = req.getParameterValues("options");
		String selectedOptions = "";
		for(String option : options) {
			selectedOptions += option + " ";
		}
		// escrever a resposta
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html lang=\"pt-BR\">");
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title>Página de Resposta - News List</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
		writer.println("\t<h2>Nome completo: "+ fullName +"</h2>");
		writer.println("\t<h2>E-mail: "+ email +"</h2>");
		writer.println("\t<h2>Interesses: "+ selectedOptions +"</h2>");
		writer.println("</body>");
		writer.println("</html");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
