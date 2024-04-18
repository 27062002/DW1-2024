package br.edu.ifsp.arq.ads.ifitness.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.daos.UserDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.model.entities.ActivityType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/activityRegister")
public class ActivityRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ActivityRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActivityType type = ActivityType.valueOf(req.getParameter("type"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		Double distance = Double.parseDouble(req.getParameter("distance"));
		Integer duration = Integer.parseInt(req.getParameter("duration"));

		// buscar User logado
		Optional<User> optional = Optional.empty();
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loggedUser")) {
					UserDao userDao = new UserDao(SearcherDataSource.getInstance().getDataSource());
					optional = userDao.getUserByEmail(c.getValue());
				}			}
		}

		RequestDispatcher dispatcher = null;
		
		if(optional.isPresent()) {
			Activity activity = new Activity();
			activity.setType(type);
			activity.setDate(date);
			activity.setDistance(distance);
			activity.setDuration(duration);
			activity.setUser(optional.get());
			ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
			if(activityDao.save(activity)) {
				req.setAttribute("result", "registered");
				dispatcher = req.getRequestDispatcher("/activity-register.jsp");
			}
		} else {
			req.setAttribute("result", "notRegistered");
			dispatcher = req.getRequestDispatcher("/activity-register.jsp");
		}

		dispatcher.forward(req, resp);
	}

}