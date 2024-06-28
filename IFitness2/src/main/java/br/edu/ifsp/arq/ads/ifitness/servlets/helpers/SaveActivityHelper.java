package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import java.time.LocalDate;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.model.entities.ActivityType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveActivityHelper implements Helper {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Long id = Long.parseLong(req.getParameter("id"));
		ActivityType type = ActivityType.valueOf(req.getParameter("type"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		Double distance = Double.parseDouble(req.getParameter("distance"));
		Integer duration = Integer.parseInt(req.getParameter("duration"));

		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
		Activity activity = new Activity();
		activity.setType(type);
		activity.setDate(date);
		activity.setDistance(distance);
		activity.setDuration(duration);
		activity.setUser(user);
		if(id == 0) {
			if(activityDao.save(activity)) {
				req.setAttribute("result", "registered");
			}
		}else {
			activity.setId(id);
			if(activityDao.update(activity)) {
				req.setAttribute("result", "registered");
			}
		}
		return "/activity-register.jsp";
	}

}