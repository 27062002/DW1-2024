package br.edu.ifsp.arq.ads.model.daos.filters;

import br.edu.ifsp.arq.ads.model.entities.Especie;
import br.edu.ifsp.arq.ads.model.entities.Sexo;
import br.edu.ifsp.arq.ads.model.entities.User;

public class AnimalFilter {

	private User user;
	private Sexo sexo;
	private Especie especie;

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
