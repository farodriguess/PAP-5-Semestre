package com.bm.pap.entity;

import java.io.Serializable;

public class PontuacaoUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2818704637895386399L;
	private Long id;
	private Integer pontos;
	private Usuario usuario;
	private Campeonato campeonato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

}
