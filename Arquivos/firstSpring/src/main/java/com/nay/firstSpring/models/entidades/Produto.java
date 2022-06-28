package com.nay.firstSpring.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Produtos")
@SQLDelete(sql = "UPDATE Produtos SET deleted = true WHERE id =?")
@Where(clause = "deleted = false")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@Column(precision = 10 ,scale = 2)
	@Min(value = 0)
	private double preco;
	
	@Max(value = 1)
	@Min(value = 0)
	private double desconto;
	
	private boolean deleted = Boolean.FALSE;
	
	public Produto() {/*default*/}

	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public double getPreco() {return preco;}

	public void setPreco(double preco) {this.preco = preco;}

	public double getDesconto() {return desconto;}

	public void setDesconto(double desconto) {this.desconto = desconto;}

	public boolean isDeleted() {return deleted;}

	public void setDeleted(boolean deleted) {this.deleted = deleted;}
	
}
