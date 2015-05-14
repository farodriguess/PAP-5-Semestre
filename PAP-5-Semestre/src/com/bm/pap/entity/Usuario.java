package com.bm.pap.entity;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2032420663533288117L;
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private List<Aposta> apostaList;
	private List<PontuacaoUsuario> pontuacaoUsuarioList;
	private List<Campeonato> campeonatoList;
	private List<Equipe> equipeList;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Aposta> getApostaList() {
		return apostaList;
	}

	public void setApostaList(List<Aposta> apostaList) {
		this.apostaList = apostaList;
	}

	public List<PontuacaoUsuario> getPontuacaoUsuarioList() {
		return pontuacaoUsuarioList;
	}

	public void setPontuacaoUsuarioList(
			List<PontuacaoUsuario> pontuacaoUsuarioList) {
		this.pontuacaoUsuarioList = pontuacaoUsuarioList;
	}

	public List<Campeonato> getCampeonatoList() {
		return campeonatoList;
	}

	public void setCampeonatoList(List<Campeonato> campeonatoList) {
		this.campeonatoList = campeonatoList;
	}

	public List<Equipe> getEquipeList() {
		return equipeList;
	}

	public void setEquipeList(List<Equipe> equipeList) {
		this.equipeList = equipeList;
	}

}
