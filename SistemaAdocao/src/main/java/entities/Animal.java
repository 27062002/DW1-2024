package br.edu.ifsp.arq.ads.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Especie especie;
	private int idade;
	private Sexo sexo;
	private String raca;
	private String pelagem;
	private String problemas_saude;
	
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
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getPelagem() {
		return pelagem;
	}
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
	public String getProblemas_saude() {
		return problemas_saude;
	}
	public void setProblemas_saude(String problemas_saude) {
		this.problemas_saude = problemas_saude;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}