public class Espectador {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private double dinero;
    
    // CONSTRUCTORES
    public Espectador() {
        this.nombre = "";
        this.edad = 0;
        this.dinero = 0.0;
    }

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    // METODOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}