package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import java.time.LocalDate;

import br.edu.ifsp.arq.ads.ifitness.model.daos.UserDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Gender;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.PasswordEncode;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserHelper implements Helper {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String gender = req.getParameter("gender");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(PasswordEncode.encode(password));
		user.setDateOfBirth(LocalDate.parse(dateOfBirth));
		user.setGender(Gender.valueOf(gender));
		
		UserDao userDao = new UserDao(SearcherDataSource.getInstance().getDataSource());
		
		if(userDao.save(user)) {
			req.setAttribute("result", "registered");
			return "/login.jsp";
		}else {
			req.setAttribute("result", "notRegistered");
			return "/user-register.jsp";
		}
	}

}
