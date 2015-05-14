package com.bm.pap.entity;

import java.io.Serializable;

public class Resultado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -435332634197992946L;
	private Long id;
	private Integer gol;
	private Integer golPenalti;
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
