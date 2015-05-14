package com.bm.pap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Campeonato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2197881022920939955L;
	private Long id;
	private String nome;
	private Integer qtdEquipe;
	private Date dataInicio;
	private Date dataFinal;
	private String status;
	private Integer regra1;
	private Integer regra2;
	private Integer regra3;
	private Integer regra4;
	private Integer regra5;
	private Integer regra6;
	private Integer regra7;
	private Integer regra8;
	private List<PontuacaoUsuario> pontuacaoUsuarioList;
	private List<Partida> partidaList;
	private List<PontuacaoEquipe> pontuacaoEquipeList;
	private Usuario usuario;

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

	public Integer getQtdEquipe() {
		return qtdEquipe;
	}

	public void setQtdEquipe(Integer qtdEquipe) {
		this.qtdEquipe = qtdEquipe;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getRegra1() {
		return regra1;
	}

	public void setRegra1(Integer regra1) {
		this.regra1 = regra1;
	}

	public Integer getRegra2() {
		return regra2;
	}

	public void setRegra2(Integer regra2) {
		this.regra2 = regra2;
	}

	public Integer getRegra3() {
		return regra3;
	}

	public void setRegra3(Integer regra3) {
		this.regra3 = regra3;
	}

	public Integer getRegra4() {
		return regra4;
	}

	public void setRegra4(Integer regra4) {
		this.regra4 = regra4;
	}

	public Integer getRegra5() {
		return regra5;
	}

	public void setRegra5(Integer regra5) {
		this.regra5 = regra5;
	}

	public Integer getRegra6() {
		return regra6;
	}

	public void setRegra6(Integer regra6) {
		this.regra6 = regra6;
	}

	public Integer getRegra7() {
		return regra7;
	}

	public void setRegra7(Integer regra7) {
		this.regra7 = regra7;
	}

	public Integer getRegra8() {
		return regra8;
	}

	public void setRegra8(Integer regra8) {
		this.regra8 = regra8;
	}

	public List<PontuacaoUsuario> getPontuacaoUsuarioList() {
		return pontuacaoUsuarioList;
	}

	public void setPontuacaoUsuarioList(
			List<PontuacaoUsuario> pontuacaoUsuarioList) {
		this.pontuacaoUsuarioList = pontuacaoUsuarioList;
	}

	public List<Partida> getPartidaList() {
		return partidaList;
	}

	public void setPartidaList(List<Partida> partidaList) {
		this.partidaList = partidaList;
	}

	public List<PontuacaoEquipe> getPontuacaoEquipeList() {
		return pontuacaoEquipeList;
	}

	public void setPontuacaoEquipeList(List<PontuacaoEquipe> pontuacaoEquipeList) {
		this.pontuacaoEquipeList = pontuacaoEquipeList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
