package br.edu.ifsp.arq.ads.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.arq.ads.model.daos.UserDao;
import br.edu.ifsp.arq.ads.model.entities.User;
import br.edu.ifsp.arq.ads.utils.PasswordEncode;
import br.edu.ifsp.arq.ads.utils.SearcherDataSource;

@WebServlet("/funcionarioRegister")
public class FuncionarioRegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public FuncionarioRegisterServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	req.setCharacterEncoding("UTF-8");
	String nome = req.getParameter("nome");
	String cpf = req.getParameter("cpf");
	String rg = req.getParameter("rg");
	String telefone = req.getParameter("telefone");
	String data_de_nascimento = req.getParameter("data_de_nascimento");
	String endereco = req.getParameter("endereco");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	User user = new User();
	user.setNome(nome);
	user.setCpf(cpf);
	user.setRg(rg);
	user.setTelefone(telefone);
	user.setData_de_nascimento(LocalDate.parse(data_de_nascimento));
	user.setEndereco(endereco);
	user.setEmail(email);
	user.setPassword(PasswordEncode.encode(password));
	
	UserDao userDao = new UserDao(SearcherDataSource.getInstance().getDataSource());
	
	if(userDao.saveEmployeeUser(user)) {
		req.setAttribute("result", "registered");
	}else {
		req.setAttribute("result", "notRegistered");
	}
	RequestDispatcher dispatcher = req.getRequestDispatcher("/funcionario-register.jsp");
	dispatcher.forward(req, resp);
	}
}
