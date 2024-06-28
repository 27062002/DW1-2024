package br.edu.ifsp.arq.ads.model.entities;

import java.time.LocalDate;

public class User {

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private LocalDate data_de_nascimento;
	private String endereco;
	private String email;
	private String password;
	private int tipoUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(LocalDate data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuarioComum(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
