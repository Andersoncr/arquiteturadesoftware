package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.usjt.arqsw.entity.Fila;
/*
 * @author Anderson
 */
public class Chamado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message="A fila não pode ser vazia")
	@Min(value=1, message="A fila não pode ser vazia")
	private int id;
	private String descricao;
	private String status;
	private Fila fila;
	private String dt_Abertura;
	private String dt_Fechamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFila() {
		fila = new Fila();
		return fila.getId();
	}
	public void setFila(int idFila) {
		fila = new Fila();
		idFila = fila.getId();
	}
	public String getDt_Abertura() {
		return dt_Abertura;
	}
	public void setDt_Abertura(String dt_Abertura) {
		this.dt_Abertura = dt_Abertura;
	}
	public String getDt_Fechamento() {
		return dt_Fechamento;
	}
	public void setDt_Fechamento(String dt_Fechamento) {
		this.dt_Fechamento = dt_Fechamento;
	}
}
