package modelo;
 
public class Palabra {
    private int codigoPalabra;
    private String nombre;
    private String pista1;
    private String pista2;
    private String pista3;
 
    public int getCodigoPalabra() {
        return codigoPalabra;
    }
 
    public void setCodigoPalabra(int codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getPista1() {
        return pista1;
    }
 
    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }
 
    public String getPista2() {
        return pista2;
    }
 
    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }
 
    public String getPista3() {
        return pista3;
    }
 
    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }
 
    @Override
    public String toString() {
        return "Palabra{" + "codigoPalabra=" + codigoPalabra + 
               ", nombre=" + nombre + 
               ", pista1=" + pista1 + 
               ", pista2=" + pista2 + 
               ", pista3=" + pista3 + '}';
    }
}