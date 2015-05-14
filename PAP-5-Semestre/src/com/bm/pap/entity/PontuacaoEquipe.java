package com.bm.pap.entity;

import java.io.Serializable;

public class PontuacaoEquipe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7242881396699476859L;
	private Long id;
	private Integer vitorias;
	private Integer derrotas;
	private Integer empates;
	private Integer golspros;
	private Integer golscontras;
	private Equipe equipe;
	private Campeonato campeonato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}

	public Integer getEmpates() {
		return empates;
	}

	public void setEmpates(Integer empates) {
		this.empates = empates;
	}

	public Integer getGolspros() {
		return golspros;
	}

	public void setGolspros(Integer golspros) {
		this.golspros = golspros;
	}

	public Integer getGolscontras() {
		return golscontras;
	}

	public void setGolscontras(Integer golscontras) {
		this.golscontras = golscontras;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

}
