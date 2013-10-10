package br.com.ligaesporteamador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGEN_QUADRA_CAMPO")
public class ImagenQuadraCampo extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IMAGEN_QUADRA_CAMPO_ID", length = 10)
	private Long id;

	@Column(name = "CAMINHO_IMAGEN", length = 255)
	private String caminhoImagem;

	@Column(name = "LEGENDA", length = 100)
	private String legenda;

	@Column(name = "DESCRICAO", length = 255)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.MERGE})
	@JoinColumn(name = "QUADRA_CAMPO_ID")
	private QuadraCampo quandraCampo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public QuadraCampo getQuandraCampo() {
		return quandraCampo;
	}

	public void setQuandraCampo(QuadraCampo quandraCampo) {
		this.quandraCampo = quandraCampo;
	}

}
