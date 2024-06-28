package br.edu.ifsp.arq.ads.ifitness.servlets;

import java.io.IOException;

import br.edu.ifsp.arq.ads.ifitness.servlets.helpers.Helper;
import br.edu.ifsp.arq.ads.ifitness.servlets.helpers.HelperFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerServlet")
public class FrontControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public FrontControllerServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Helper helper = new HelperFactory().getHelper(req);
		try {
			String page = helper.execute(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, resp);
		}
		catch(Exception error) {
			throw new ServletException(error);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}