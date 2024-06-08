package com.github.jclb.globalsolution.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.github.jclb.globalsolution.model.Peixe;


public class FormPeixe {
    private Long id;
	private String nome;
	private String desc;
	private BigDecimal peso;
	private LocalDate dataCatalogacao;
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
	
	 public Peixe toModel() {
		 Peixe peixe = new Peixe();
	        peixe.setId(this.getId());
	        peixe.setNome(this.getNome());
	        peixe.setDesc(this.getDesc());
	        peixe.setPeso(this.peso);
	        peixe.setDataCatalogacao(this.getDataCatalogacao());
	        return peixe;
	    }
	 
	   public FormPeixe toForm(Peixe peixe) {
	        this.setId(peixe.getId());
	        this.setNome(peixe.getNome());
	        this.setPeso(peixe.getPeso());
	        this.setDataCatalogacao(peixe.getDataCatalogacao());
	        this.setDesc(peixe.getDesc());
	      return this;
	    }
}
