package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Palabra> listar() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "{call sp_listarPalabras()}";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Palabra p = new Palabra();
                p.setCodigoPalabra(rs.getInt("codigoPalabra"));
                p.setNombre(rs.getString("nombre"));
                p.setPista1(rs.getString("pista1"));
                p.setPista2(rs.getString("pista2"));
                p.setPista3(rs.getString("pista3"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
