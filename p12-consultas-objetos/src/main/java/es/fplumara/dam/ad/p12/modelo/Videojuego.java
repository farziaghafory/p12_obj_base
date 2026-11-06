package es.fplumara.dam.ad.p12.modelo;

/**
 * Un videojuego de la tabla videojuego.
 */
public class Videojuego {

    private int id;
    private String titulo;
    private int maxJugadores;
    // Double y no double: puede valer null si el juego no tiene nota
    private Double puntuacion;
    private String descripcion;

    public Videojuego() {
    }

    public Videojuego(int id, String titulo, int maxJugadores, Double puntuacion, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.maxJugadores = maxJugadores;
        this.puntuacion = puntuacion;
        this.descripcion = descripcion;
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

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String jugadores;
        if (maxJugadores == 1) {
            jugadores = "1 jugador";
        } else {
            jugadores = "hasta " + maxJugadores + " jugadores";
        }
        String nota;
        if (puntuacion == null) {
            nota = "sin nota";
        } else {
            nota = "nota " + puntuacion;
        }
        return id + " · " + titulo + " · " + jugadores + " · " + nota;
    }
}
