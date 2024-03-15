package br.edu.ifsp.arq.ads.dw1s5.project1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class ServletProject1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletProject1() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//setar a codificação de caracteres da requisição
		req.setCharacterEncoding("UTF-8");
		//obter os dados da requisição
		String name = req.getParameter("name");
		//construir a resposta
		//setar o tipo de coonteudo e a codificação de caracteres da resposta
		resp.setContentType("text/html;charset=UTF-8");
		//obter o objeto de escrita da resposta
		PrintWriter writer = resp.getWriter();
		writer.println("<html lang=\"pt-BR\">");
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title>Página de boas vindas</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h2>Seja bem-vindo(a)," + name + "</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
