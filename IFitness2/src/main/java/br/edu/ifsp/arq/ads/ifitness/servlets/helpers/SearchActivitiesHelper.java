package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.daos.filters.ActivityFilter;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.model.entities.ActivityType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchActivitiesHelper implements Helper {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String type = req.getParameter("type");
		ActivityType activityType = null;
		if(!type.isEmpty()) {
			activityType = ActivityType.valueOf(type);
		}
		String date = req.getParameter("initial-date");
		LocalDate initialDate = null;
		if(!date.isEmpty()) {
			initialDate = LocalDate.parse(date);
		}
		date = req.getParameter("final-date");
		LocalDate finalDate = null;
		if(!date.isEmpty()) {
			finalDate = LocalDate.parse(date);
		}
		
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		ActivityFilter filter = new ActivityFilter();
		filter.setUser(user);
		filter.setType(activityType);
		filter.setInitialDate(initialDate);
		filter.setFinalDate(finalDate);
		ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
		List<Activity> userActivities = null;
		try {
			userActivities = activityDao.getActivitiesByFilter(filter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("userActivities", userActivities);
		return "/home.jsp";
	}

}