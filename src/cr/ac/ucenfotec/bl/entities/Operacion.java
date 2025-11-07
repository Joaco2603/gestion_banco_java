package cr.ac.ucenfotec.bl.entities;

import java.time.LocalDate;

public class Operacion {
    private int numero;
    private String tipo;
    private double monto;
    private LocalDate fechaOperacion;

    public Operacion(int numero, String tipo, double monto) {
        this.numero = numero;
        this.tipo = tipo;
        this.monto = monto;
        this.fechaOperacion = LocalDate.now();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String toString() {
        return "Operacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", fechaOperacion=" + fechaOperacion +
                '}';
    }
}

