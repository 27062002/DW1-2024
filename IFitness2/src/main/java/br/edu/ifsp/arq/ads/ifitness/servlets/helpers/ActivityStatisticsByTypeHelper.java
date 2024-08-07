package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import java.util.List;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.dto.ActivityByType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActivityStatisticsByTypeHelper implements Helper {

	@Override
	public List<ActivityByType> execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");	
		ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
		return activityDao.getActivitiesStatisticsByType(user); 
	}

}