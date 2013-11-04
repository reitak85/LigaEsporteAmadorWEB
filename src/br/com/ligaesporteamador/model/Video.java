package br.com.ligaesporteamador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEO")
public class Video extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VIDEO_ID", length = 10)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "SUB_TITULO")
	private String subTitulo;

	@Column(name = "URL_VIDEO")
	private String urlVideo;

	@Column(name = "CREDITO_VIDEO")
	private String creditoVideo;

	@Column(name = "NOTICA_UM")
	private String noticiaUm;

	@Column(name = "NOTICIA_DOIS")
	private String noticiaDois;

	@Column(name = "NOTICIA_TRES")
	private String noticiaTres;

	@Column(name = "CATEGORIA")
	private String categoria; // significa se Ž amador, profissional, sub-20

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,
			CascadeType.MERGE })
	@JoinColumn(name = "ESPORTE_ID")
	private Esporte esporte;

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

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getCreditoVideo() {
		return creditoVideo;
	}

	public void setCreditoVideo(String creditoVideo) {
		this.creditoVideo = creditoVideo;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
