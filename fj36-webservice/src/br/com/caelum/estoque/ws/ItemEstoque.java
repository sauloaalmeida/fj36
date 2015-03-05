package br.com.caelum.estoque.ws;


import java.io.Serializable;

public class ItemEstoque implements Serializable {
	
	
	private static final long serialVersionUID = 1l;
	private String codigo;
	private Integer quantidade;

	
	public ItemEstoque() {
		super();
	}

	public ItemEstoque(String codigo, Integer quantidade) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	

}
