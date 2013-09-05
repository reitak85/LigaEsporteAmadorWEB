package br.com.ligaesporteamador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ESPORTE", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Esporte extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ESPORTE_ID", length = 10)
	private Long id;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "DESCRICAO", length = 255)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CategoriaEsporte> categoriaEsportes;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CategoriaEsporte> getCategoriaEsportes() {
		return categoriaEsportes;
	}

	public void setCategoriaEsportes(List<CategoriaEsporte> categoriaEsportes) {
		this.categoriaEsportes = categoriaEsportes;
	}

}
