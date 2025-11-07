package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class DataCuenta {
    private List<Cuenta> cuentas;
    private static int contadorCuentas = 0;

    public DataCuenta() {
        this.cuentas = new ArrayList<>();
    }

    public boolean agregar(Cuenta cuenta) {
        return cuentas.add(cuenta);
    }

    public Cuenta buscar(int numCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumCuenta() == numCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public List<Cuenta> listarTodos() {
        return new ArrayList<>(cuentas);
    }

    public List<Cuenta> buscarPorCliente(String cedula) {
        List<Cuenta> cuentasCliente = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getDuenio().getCedula().equals(cedula)) {
                cuentasCliente.add(cuenta);
            }
        }
        return cuentasCliente;
    }

    public boolean actualizar(Cuenta cuenta) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumCuenta() == cuenta.getNumCuenta()) {
                cuentas.set(i, cuenta);
                return true;
            }
        }
        return false;
    }

    public int generarNumeroCuenta() {
        return ++contadorCuentas;
    }
}
