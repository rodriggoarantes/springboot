package br.com.in6.springboot.livros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "titulo", nullable = false)
	private String titulo;
	@Column(name = "isbn", unique = true)
	private String isbn;
	@Column(name = "autor")
	private String autor;
	@Column(name = "descricao")
	private String description;
	
	public Livro() {}
	
	public Livro(Long id, String t, String i, String a, String d) {
		this.id = id;
		this.titulo = t;
		this.isbn = i;
		this.autor = a;
		this.description = d;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Livro[id=%d, isbn='%s', title='%s']",
                id, isbn, titulo);
    }
}
