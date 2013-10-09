package br.com.ligaesporteamador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QUADRA_CAMPO")
public class QuadraCampo  extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "QUADRA_CAMPO_ID", length = 10)
	private Long id;

	@Column(name = "TIPO", length = 100)
	private String tipo;

	@Column(name = "NOME_QUADRA_CAMPO", length = 100)
	private String nomeQuadraCampo;

	@Column(name = "OBSERVACAO", length = 100)
	private String observacao;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IMAGEN_QUADRA_CAMPO_ID")
	private List<ImagenQuadraCampo> imagenQuadraCampos;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "HORA_JOGO_ID")
	private List<HorarioJogo> horarioJogos;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "COMPLEMENTO_ENDERECO_ID")
	private ComplementoEndereco complementoEndereco;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TIME_ID")
	private Time time;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeQuadraCampo() {
		return nomeQuadraCampo;
	}

	public void setNomeQuadraCampo(String nomeQuadraCampo) {
		this.nomeQuadraCampo = nomeQuadraCampo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<ImagenQuadraCampo> getImagenQuadraCampos() {
		return imagenQuadraCampos;
	}

	public void setImagenQuadraCampos(List<ImagenQuadraCampo> imagenQuadraCampos) {
		this.imagenQuadraCampos = imagenQuadraCampos;
	}

	public List<HorarioJogo> getHorarioJogos() {
		return horarioJogos;
	}

	public void setHorarioJogos(List<HorarioJogo> horarioJogos) {
		this.horarioJogos = horarioJogos;
	}

	public ComplementoEndereco getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(ComplementoEndereco complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
