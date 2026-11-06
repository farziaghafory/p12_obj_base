package es.fplumara.dam.ad.p12.modelo;

/**
 * Una empresa de la tabla empresa: desarrolla o distribuye videojuegos.
 */
public class Empresa {

    private int id;
    private String nombre;
    private String pais;
    // Integer y no int: pueden valer null si no se conocen o si la empresa sigue abierta
    private Integer anioFundacion;
    private Integer anioCierre;

    public Empresa() {
    }

    public Empresa(int id, String nombre, String pais, Integer anioFundacion, Integer anioCierre) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anioFundacion = anioFundacion;
        this.anioCierre = anioCierre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(Integer anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public Integer getAnioCierre() {
        return anioCierre;
    }

    public void setAnioCierre(Integer anioCierre) {
        this.anioCierre = anioCierre;
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ")";
    }
}
