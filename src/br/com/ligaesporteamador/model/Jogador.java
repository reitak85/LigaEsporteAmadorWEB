package br.com.ligaesporteamador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "JOGADORES", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Jogador extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "JOGADOR_ID")
	private Long id;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "POSICAO", length = 100)
	private String posicao;

	@Column(name = "TIME", length = 100)
	private String timeTorce;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_ID")
	private Contato contato;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TIME_ID")
	private Time time;
	
	public Jogador() {
		contato = new Contato();
	}

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

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getTimeTorce() {
		return timeTorce;
	}

	public void setTimeTorce(String timeTorce) {
		this.timeTorce = timeTorce;
	}

}
