package com.musica.musica.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

@Entity
public class Musica  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String cantor;
	
	@NotEmpty
	private String tempo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
}
