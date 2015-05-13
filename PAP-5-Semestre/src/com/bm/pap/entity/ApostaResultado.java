package com.bm.pap.entity;

import java.io.Serializable;

public class ApostaResultado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3321899816781770297L;
	private Long id;
	private Integer gol;
	private Integer golPenalti;
	private Aposta aposta;
	private Equipe equipe;
	private Partida partida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGol() {
		return gol;
	}

	public void setGol(Integer gol) {
		this.gol = gol;
	}

	public Integer getGolPenalti() {
		return golPenalti;
	}

	public void setGolPenalti(Integer golPenalti) {
		this.golPenalti = golPenalti;
	}

	public Aposta getAposta() {
		return aposta;
	}

	public void setAposta(Aposta aposta) {
		this.aposta = aposta;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

}
