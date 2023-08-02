package Modelo;

import java.util.List;

public class Livro {
    private int id;
    private String titulo;
    private List<Integer> categorias;
    private List<Integer> autores;

    public Livro(int id, String titulo, List<Integer> categorias, List<Integer> autores) {
        this.id = id;
        this.titulo = titulo;
        this.categorias = categorias;
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Integer> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Integer> categorias) {
        this.categorias = categorias;
    }

    public List<Integer> getAutores() {
        return autores;
    }

    public void setAutores(List<Integer> autores) {
        this.autores = autores;
    }
}