package br.senai.sc.tinfo20132n1.imobiliaria.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CadastroImobiliaria {
	
	@Id
	@GeneratedValue
	private Long id;
	private String endereco;
	private Integer numero;
	private String tipo;
	private Double valor;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private TipoDeImovel tipoDeImovel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoDeImovel getTipoDeImovel() {
		return tipoDeImovel;
	}
	public void setTipoDeImovel(TipoDeImovel tipoDeImovel) {
		this.tipoDeImovel = tipoDeImovel;
	}

}
