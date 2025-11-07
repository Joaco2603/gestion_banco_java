package cr.ac.ucenfotec.bl.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private int numCuenta;
    private double saldo;
    private LocalDate fechaCreacion;
    private int numOperaciones;
    private Cliente duenio;
    private List<Operacion> registra;

    public Cuenta(Cliente duenio, double monto) {
        this.duenio = duenio;
        this.saldo = monto;
        this.fechaCreacion = LocalDate.now();
        this.numOperaciones = 0;
        this.registra = new ArrayList<>();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    public Cliente getDuenio() {
        return duenio;
    }

    public void setDuenio(Cliente duenio) {
        this.duenio = duenio;
    }

    public List<Operacion> getRegistra() {
        return registra;
    }

    public void setRegistra(List<Operacion> registra) {
        this.registra = registra;
    }

    public String depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            Operacion operacion = new Operacion(++numOperaciones, "DEPOSITO", monto);
            registra.add(operacion);
            return "Depósito exitoso. Nuevo saldo: " + this.saldo;
        }
        return "Monto inválido";
    }

    public String retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            Operacion operacion = new Operacion(++numOperaciones, "RETIRO", monto);
            registra.add(operacion);
            return "Retiro exitoso. Nuevo saldo: " + this.saldo;
        }
        return "Fondos insuficientes o monto inválido";
    }

    public String toString() {
        return "Cuenta{" +
                "numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion +
                ", numOperaciones=" + numOperaciones +
                ", duenio=" + duenio.getNombre() + " " + duenio.getApellido() +
                '}';
    }
}
