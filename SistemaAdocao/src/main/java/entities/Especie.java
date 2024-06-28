package br.edu.ifsp.arq.ads.model.entities;

public enum Especie {
	
	CACHORRO("Cachorro"),
	GATO("Gato");
	
	private String type;
	
	Especie(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}