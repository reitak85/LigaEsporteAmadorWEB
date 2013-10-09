package br.com.ligaesporteamador.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NOTICIA_IMAGEM")
public class Noticia extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "NOTICIA_IMAGEM_ID", length = 10)
	private Long id;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "SUB_TITULO")
	private String subTitulo;

	@Column(name = "CREDITO")
	private String credito;

	@Column(name = "LEGENDA")
	private String legenda;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DA_NOTICIA")
	private Calendar data;
	
	private Date dataNoticia;

	@Column(name = "IMAGEM")
	private String imagem;

	@Column(name = "NOTICIA_UM")
	private String noticiaUm;

	@Column(name = "NOTICA_DOIS")
	private String noticiaDois;

	@Column(name = "NOTICIA_TRES")
	private String noticiaTres;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESPORTE_ID")
	private Esporte esporte;

	public Noticia() {
		esporte = new Esporte();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNoticiaUm() {
		return noticiaUm;
	}

	public void setNoticiaUm(String noticiaUm) {
		this.noticiaUm = noticiaUm;
	}

	public String getNoticiaDois() {
		return noticiaDois;
	}

	public void setNoticiaDois(String noticiaDois) {
		this.noticiaDois = noticiaDois;
	}

	public String getNoticiaTres() {
		return noticiaTres;
	}

	public void setNoticiaTres(String noticiaTres) {
		this.noticiaTres = noticiaTres;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
		data.setTime(dataNoticia);
	}
	
	

}
