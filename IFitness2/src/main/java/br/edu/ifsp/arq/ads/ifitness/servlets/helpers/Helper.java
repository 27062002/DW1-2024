package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Helper {

	public abstract String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}