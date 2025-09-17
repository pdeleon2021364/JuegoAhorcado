package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {
    
    // Al instanciar PalabraDAO, se crea una nueva instancia de Conexion
    Conexion cn = new Conexion();   
    Connection con;                 
    CallableStatement cs;           
    ResultSet rs;                   

    public List<Palabra> listar() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "{CALL sp_listarPalabras()}";

        try {
            con = cn.getConnection(); // Obtiene la conexión
            
            // ✅ CORRECCIÓN: Si la conexión es nula (porque falló),
            // se detiene la ejecución del método y se retorna una lista vacía.
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos. Verifique la configuración.");
                return lista; 
            }
            
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Palabra p = new Palabra();
                p.setCodigoPalabra(rs.getInt("codigoPalabra"));
                p.setNombre(rs.getString("nombre"));
                p.setPista1(rs.getString("pista1"));
                p.setPista2(rs.getString("pista2"));
                p.setPista3(rs.getString("pista3"));
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ✅ BUENA PRÁCTICA: Cerrar los recursos en el bloque 'finally'
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}