package br.com.ligaesporteamador.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "DIA_HORARIO_JOGO")
public class HorarioJogo extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "HORARIO_JOGO_ID", length = 10)
	private Long id;

	@Column(name = "DIA", length = 100)
	private String dia;

	@Temporal(TemporalType.TIME)
	@Column(name = "HORA_INICIAL")
	private Date horaInicial;

	@Temporal(TemporalType.TIME)
	@Column(name = "HORA_FINAL")
	private Date horaFinal;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,
			CascadeType.MERGE })
	@JoinColumn(name = "QUADRA_CAMPO_ID")
	private QuadraCampo quandraCampo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public QuadraCampo getQuandraCampo() {
		return quandraCampo;
	}

	public void setQuandraCampo(QuadraCampo quandraCampo) {
		this.quandraCampo = quandraCampo;
	}

}
