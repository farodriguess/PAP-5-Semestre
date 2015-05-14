package com.bm.pap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Partida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9173191073747778485L;
	private Long id;
	private String fase;
	private String tipo;
	private Integer numeroPartida;
	private Date dataPartida;
	private String localPartida;
	private String status;
	private List<ApostaResultado> apostaResultadoList;
	private List<Resultado> resultadoList;
	private Campeonato campeonato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(Integer numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public String getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ApostaResultado> getApostaResultadoList() {
		return apostaResultadoList;
	}

	public void setApostaResultadoList(List<ApostaResultado> apostaResultadoList) {
		this.apostaResultadoList = apostaResultadoList;
	}

	public List<Resultado> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<Resultado> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

}
