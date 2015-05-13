package com.bm.pap.entity;

import java.io.Serializable;
import java.util.List;

public class Equipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4862614167838267719L;
	private Long id;
	private String nome;
	private List<Resultado> resultadoList;
	private List<ApostaResultado> apostaResultadoList;
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

	public List<Resultado> getResultadoList() {
		return resultadoList;
	}

	public void setResultadoList(List<Resultado> resultadoList) {
		this.resultadoList = resultadoList;
	}

	public List<ApostaResultado> getApostaResultadoList() {
		return apostaResultadoList;
	}

	public void setApostaResultadoList(List<ApostaResultado> apostaResultadoList) {
		this.apostaResultadoList = apostaResultadoList;
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
