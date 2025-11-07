package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.entities.Cuenta;
import cr.ac.ucenfotec.dl.DataCuenta;
import java.util.List;

public class GestorCuenta {
    private DataCuenta dataCuenta;

    public GestorCuenta() {
        this.dataCuenta = new DataCuenta();
    }

    public String registrarCuenta(Cliente cliente, double montoInicial) {
        // Validaciones
        if (cliente == null) {
            return "El cliente no puede ser nulo";
        }
        if (montoInicial < 0) {
            return "El monto inicial no puede ser negativo";
        }

        Cuenta cuenta = new Cuenta(cliente, montoInicial);
        int numeroCuenta = dataCuenta.generarNumeroCuenta();
        cuenta.setNumCuenta(numeroCuenta);

        if (dataCuenta.agregar(cuenta)) {
            // Asociar la cuenta al cliente
            cliente.setDuenio(cuenta);
            return "Cuenta registrada exitosamente con número: " + numeroCuenta;
        }
        return "Error al registrar la cuenta";
    }

    public Cuenta buscarCuenta(int numCuenta) {
        return dataCuenta.buscar(numCuenta);
    }

    public List<Cuenta> listarCuentas() {
        return dataCuenta.listarTodos();
    }

    public List<Cuenta> buscarCuentasPorCliente(String cedula) {
        return dataCuenta.buscarPorCliente(cedula);
    }

    public String consultarSaldo(int numCuenta) {
        Cuenta cuenta = dataCuenta.buscar(numCuenta);
        if (cuenta == null) {
            return "Cuenta no encontrada";
        }
        return "Saldo de la cuenta " + numCuenta + ": ₡" + String.format("%.2f", cuenta.getSaldo());
    }

    public String realizarDeposito(int numCuenta, double monto) {
        Cuenta cuenta = dataCuenta.buscar(numCuenta);
        if (cuenta == null) {
            return "Cuenta no encontrada";
        }

        String resultado = cuenta.depositar(monto);
        dataCuenta.actualizar(cuenta);
        return resultado;
    }

    public String realizarRetiro(int numCuenta, double monto) {
        Cuenta cuenta = dataCuenta.buscar(numCuenta);
        if (cuenta == null) {
            return "Cuenta no encontrada";
        }

        String resultado = cuenta.retirar(monto);
        dataCuenta.actualizar(cuenta);
        return resultado;
    }
}
