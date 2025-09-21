package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class PalabraDAO {
 
    public List<Palabra> listar() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "{CALL sp_listarPalabras()}";
        Conexion cn = new Conexion();
 
        try (Connection con = cn.getConnection()) {
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos. Verifique la configuración.");
                return lista;
            }
 
            try (CallableStatement cs = con.prepareCall(sql);
                 ResultSet rs = cs.executeQuery()) {
 
                while (rs.next()) {
                    Palabra p = new Palabra();
                    p.setCodigoPalabra(rs.getInt("codigoPalabra"));
                    p.setNombre(rs.getString("nombre"));
                    p.setPista1(rs.getString("pista1"));
                    p.setPista2(rs.getString("pista2"));
                    p.setPista3(rs.getString("pista3"));
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}