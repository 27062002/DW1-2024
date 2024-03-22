package br.edu.ifsp.arq.ads.dw1s5.project3.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.ads.dw1s5.project3.model.Person;
import br.edu.ifsp.arq.ads.dw1s5.project3.model.PersonUtil;

@WebServlet("/ServletPersons")
public class ServletPersonsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletPersonsController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String personsData = req.getParameter("persons");
		PersonUtil personUtil =  new PersonUtil();
		List<Person> persoList = personUtil.getPersonList(personsData);
		req.setAttribute("personsList", persoList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}

	
}
