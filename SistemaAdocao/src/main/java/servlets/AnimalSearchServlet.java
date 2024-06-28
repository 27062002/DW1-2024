package br.edu.ifsp.arq.ads.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.edu.ifsp.arq.ads.model.daos.AnimalDao;
import br.edu.ifsp.arq.ads.model.daos.filters.AnimalFilter;
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

@WebServlet("/animalSearch")
public class AnimalSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AnimalSearchServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String especie = req.getParameter("especie");
		Especie especieAnimal = null;
		if(!especie.isEmpty()) {
			especieAnimal = Especie.valueOf(especie);
		}
		
		/*String sexo = req.getParameter("sexo");
		Sexo sexoAnimal = null;
		if(!sexo.isEmpty()) {
			sexoAnimal = Sexo.valueOf(sexo);
		}*/
		
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		AnimalFilter filter = new AnimalFilter();
		filter.setUser(user);
		filter.setEspecie(especieAnimal);
		//filter.setSexo(sexoAnimal);

		AnimalDao animalDao = new AnimalDao(SearcherDataSource.getInstance().getDataSource());
		List<Animal> animals = null;
		try {
			animals = animalDao.getAnimalsByFilter(filter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("animals", animals);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
		dispatcher.forward(req, resp);
	}
}
