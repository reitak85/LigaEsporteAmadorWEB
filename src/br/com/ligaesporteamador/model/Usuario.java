package br.com.ligaesporteamador.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", 
	   uniqueConstraints={@UniqueConstraint(columnNames = { "cpf" })})
public class Usuario  extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "USUARIO_ID", length = 10)
	private Long id;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "SOBRE_NOME", length = 100)
	private String sobreNome;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DE_NASCIMENTO")
	private Calendar dataDeNascimento;

	@Column(name = "CPF", length = 14)
	private String cpf;

	@Column(name = "SEXO", length = 1)
	private String sexo;

	@Column(name = "SENHA", length = 255)
	private String senha;

	private String confirmarSenha;

	@Column(name = "ENVIO_SMS")
	private boolean envioSms;

	@Column(name = "TERMO_CONTRATO")
	private boolean termoContrato;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_ID")
	private Contato contato;
	
	private String dataNasc;
	
	public Usuario() {
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

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEnvioSms() {
		return envioSms;
	}

	public void setEnvioSms(boolean envioSms) {
		this.envioSms = envioSms;
	}

	public boolean isTermoContrato() {
		return termoContrato;
	}

	public void setTermoContrato(boolean termoContrato) {
		this.termoContrato = termoContrato;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

}
