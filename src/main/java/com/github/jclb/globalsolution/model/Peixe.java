package com.github.jclb.globalsolution.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "peixes")
public class Peixe extends AbstractEntity<Long>{
	
	
	@Column(name = "nome_peixe", nullable = false, length = 60)
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "descricao", nullable = false, length = 60)
	private String desc;
	
	@Column(name="peso", nullable = true, columnDefinition = "NUMERIC(15,2)")
	private BigDecimal peso;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dataCatalogacao;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public LocalDate getDataCatalogacao() {
		return dataCatalogacao;
	}

	public void setDataCatalogacao(LocalDate dataCatalogacao) {
		this.dataCatalogacao = dataCatalogacao;
	}
	
}
