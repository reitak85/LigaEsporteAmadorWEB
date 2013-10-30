package br.com.ligaesporteamador.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	private Calendar dataDeCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_atualizacao")
	private Calendar dataDeAtualizacao;

	public Calendar getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Calendar dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Calendar getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}

	public void setDataDeAtualizacao(Calendar dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

}
