package br.edu.ifsp.arq.ads.servlets;

import java.io.IOException;

import br.edu.ifsp.arq.ads.model.daos.AnimalDao;
import br.edu.ifsp.arq.ads.model.entities.Animal;
import br.edu.ifsp.arq.ads.model.entities.Especie;
import br.edu.ifsp.arq.ads.model.entities.Sexo;
import br.edu.ifsp.arq.ads.model.entities.User;
import br.edu.ifsp.arq.ads.utils.SearcherDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/animalRegister")
public class AnimalRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AnimalRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		Especie especie = Especie.valueOf(req.getParameter("especie"));
		Integer idade = Integer.parseInt(req.getParameter("idade"));
		Sexo sexo = Sexo.valueOf(req.getParameter("sexo"));
		String raca = req.getParameter("raca");
		String pelagem = req.getParameter("pelagem");
		String problemas_saude = req.getParameter("problemas_saude");
		
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		AnimalDao animalDao = new AnimalDao(SearcherDataSource.getInstance().getDataSource());
		Animal animal = new Animal();
		animal.setNome(nome);
		animal.setEspecie(especie);
		animal.setIdade(idade);
		animal.setSexo(sexo);
		animal.setRaca(raca);
		animal.setPelagem(pelagem);
		animal.setProblemas_saude(problemas_saude);

			if(animalDao.save(animal)) {
				req.setAttribute("result", "registered");
			}else {
				req.setAttribute("result", "notRegistered");
			}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/animal-register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Long animalId = Long.parseLong(req.getParameter("animal-id"));
		
		String url = null;
		
		AnimalDao animalDao = new AnimalDao(SearcherDataSource.getInstance().getDataSource());
		Animal animal = animalDao.getAnimalsById(animalId);

		if(animal != null) {
			if(action.equals("update")) {
				req.setAttribute("animal", animal);
				url = "/animal-register.jsp";
			}
			if(action.equals("delete")) {
				animalDao.delete(animal);
				url = "/homeServlet";
			}
		}else {
			url = "/homeServlet";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}