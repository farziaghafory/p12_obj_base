package es.fplumara.dam.ad.p12;
import es.fplumara.dam.ad.p12.modelo.Empresa;
import es.fplumara.dam.ad.p12.modelo.Version;
import es.fplumara.dam.ad.p12.modelo.Videojuego;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * P12 · Consultas y objetos de resultado.
 * Catálogo de videojuegos: de las filas de un ResultSet a objetos del modelo.
 */
public class Principal {

    // Fichero de configuración, dentro de src/main/resources
    private static final String FICHERO_CONFIGURACION = "conexion.properties";

    public static void main(String[] args) {
        try {
            Properties configuracion = cargarConfiguracion();
            try (Connection conexion = conectar(configuracion)) {
                System.out.println("Conectado a MariaDB.");

                // Paso 1
                mostrarVideojuegos(conexion);
            }
        } catch (IOException e) {
            System.out.println("Error al leer la configuración: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }

    /**
     * Lee el fichero conexion.properties de src/main/resources.
     *
     * @return la configuración con las claves url, usuario y contrasena
     * @throws IOException si el fichero no existe o no se puede leer
     */
    public static Properties cargarConfiguracion() throws IOException {
        InputStream entrada =
                Principal.class.getClassLoader().getResourceAsStream(FICHERO_CONFIGURACION);
        if (entrada == null) {
            throw new IOException("No se encuentra " + FICHERO_CONFIGURACION + " en src/main/resources");
        }
        Properties configuracion = new Properties();
        try (Reader lector = new InputStreamReader(entrada, StandardCharsets.UTF_8))
        {
            configuracion.load(lector);
        }
        return configuracion;
    }

    /**
     * Abre una conexión con MariaDB usando los datos de la configuración.
     */
    public static Connection conectar(Properties configuracion) throws SQLException {
        String url = configuracion.getProperty("url");
        String usuario = configuracion.getProperty("usuario");
        String contrasena = configuracion.getProperty("contrasena");
        return DriverManager.getConnection(url, usuario, contrasena);
    }

    // Paso 1
    /**
     * Muestra todos los videojuegos, uno por línea.
     */
    public static void mostrarVideojuegos(Connection conexion) throws SQLException {
        String sql = "SELECT id, titulo, max_jugadores, puntuacion, descripcion FROM videojuego ORDER BY id";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String titulo = resultado.getString("titulo");
                int maxJugadores = resultado.getInt("max_jugadores");
                System.out.println(id + " | " + titulo + " | " + maxJugadores);
            }
        }
    }
}
