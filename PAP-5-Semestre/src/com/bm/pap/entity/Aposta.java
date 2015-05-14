package com.bm.pap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Aposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8075456032527694917L;
	private Long id;
	private Date dataAposta;
	private List<ApostaResultado> apostaResultadoList;
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAposta() {
		return dataAposta;
	}

	public void setDataAposta(Date dataAposta) {
		this.dataAposta = dataAposta;
	}

	public List<ApostaResultado> getApostaResultadoList() {
		return apostaResultadoList;
	}

	public void setApostaResultadoList(List<ApostaResultado> apostaResultadoList) {
		this.apostaResultadoList = apostaResultadoList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
