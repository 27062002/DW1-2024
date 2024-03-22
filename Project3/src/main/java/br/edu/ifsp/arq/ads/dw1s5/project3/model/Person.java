package br.edu.ifsp.arq.ads.dw1s5.project3.model;

public class Person {

	private String name;
	private String cpf;
	private String email;
	
	public Person(String name, String cpf, String email) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
