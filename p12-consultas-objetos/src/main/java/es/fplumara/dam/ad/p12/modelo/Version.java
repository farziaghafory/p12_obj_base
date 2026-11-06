package es.fplumara.dam.ad.p12.modelo;

import java.time.LocalDate;

/**
 * Una versión de la tabla version: un videojuego publicado en una plataforma.
 * Guarda el objeto Videojuego y el objeto Empresa que lo desarrolla, no solo sus id.
 */
public class Version {

    private int id;
    private Videojuego videojuego;
    private String plataforma;
    private Empresa desarrollador;
    private LocalDate lanzamiento;
    // null si la versión se llama igual que el juego
    private String tituloAlternativo;

    public Version() {
    }

    public Version(int id, Videojuego videojuego, String plataforma, Empresa desarrollador,
                   LocalDate lanzamiento, String tituloAlternativo) {
        this.id = id;
        this.videojuego = videojuego;
        this.plataforma = plataforma;
        this.desarrollador = desarrollador;
        this.lanzamiento = lanzamiento;
        this.tituloAlternativo = tituloAlternativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Empresa getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Empresa desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(LocalDate lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getTituloAlternativo() {
        return tituloAlternativo;
    }

    public void setTituloAlternativo(String tituloAlternativo) {
        this.tituloAlternativo = tituloAlternativo;
    }

    @Override
    public String toString() {
        String texto = plataforma + " · " + lanzamiento + " · " + desarrollador;
        if (tituloAlternativo != null) {
            texto = texto + " · «" + tituloAlternativo + "»";
        }
        return texto;
    }
}
