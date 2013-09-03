package br.com.ligaesporteamador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIA_HORARIO_JOGO")
public class HorarioJogo extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "HORARIO_JOGO_ID", length = 10)
	private Long id;

	@Column(name = "DIA", length = 100)
	private String dia;

	@Column(name = "HORA_INICIAL", length = 10)
	private String horaInicial;

	@Column(name = "HORA_FINAL", length = 10)
	private String horaFinal;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "QUADRA_CAMPO_ID")
	private QuandraCampo quandraCampo;

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

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public QuandraCampo getQuandraCampo() {
		return quandraCampo;
	}

	public void setQuandraCampo(QuandraCampo quandraCampo) {
		this.quandraCampo = quandraCampo;
	}

}
