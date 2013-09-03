package br.com.ligaesporteamador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIME")
public class Time extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "TIME_ID", length = 10)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ESPORTE_ID")
	private Esporte esporte;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORIA_ID")
	private CategoriaEsporte categoria;

	@Column(name = "NOME_TIME", length = 100)
	private String nomeDoTime;

	@Column(name = "CATEGORIA_TIME", length = 10)
	private Integer categoriaTime;

	@Column(name = "EMBLEMA_TIME", length = 255)
	private String emblemaDoTime;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "JOGADOR_ID")
	private List<Jogador> jogador;

	public Time() {
		jogador = new ArrayList<Jogador>();
		esporte = new Esporte();
		categoria = new CategoriaEsporte();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public CategoriaEsporte getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEsporte categoria) {
		this.categoria = categoria;
	}

	public String getNomeDoTime() {
		return nomeDoTime;
	}

	public void setNomeDoTime(String nomeDoTime) {
		this.nomeDoTime = nomeDoTime;
	}

	public Integer getCategoriaTime() {
		return categoriaTime;
	}

	public void setCategoriaTime(Integer categoriaTime) {
		this.categoriaTime = categoriaTime;
	}

	public String getEmblemaDoTime() {
		return emblemaDoTime;
	}

	public void setEmblemaDoTime(String emblemaDoTime) {
		this.emblemaDoTime = emblemaDoTime;
	}

	public List<Jogador> getJogador() {
		return jogador;
	}

	public void setJogador(List<Jogador> jogador) {
		this.jogador = jogador;
	}

}