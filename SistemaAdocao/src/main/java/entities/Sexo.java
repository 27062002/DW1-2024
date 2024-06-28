package br.edu.ifsp.arq.ads.model.entities;

public enum Sexo {
	
	MACHO("Macho"),
	FEMEA("Fêmea");
	
	private String description;
	
	private Sexo(String description) {
		this.description = description;
	}
	
	public String getDesciption() {
		return description;
	}
}
