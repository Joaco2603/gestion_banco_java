package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Cuenta;
import cr.ac.ucenfotec.bl.entities.Operacion;
import cr.ac.ucenfotec.dl.DataOperacion;
import java.util.List;

public class GestorOperacion {
    private DataOperacion dataOperacion;

    public GestorOperacion() {
        this.dataOperacion = new DataOperacion();
    }

    public boolean registrarOperacion(Operacion operacion) {
        return dataOperacion.agregar(operacion);
    }

    public List<Operacion> listarOperaciones() {
        return dataOperacion.listarTodos();
    }

    public Operacion buscarOperacion(int numero) {
        return dataOperacion.buscar(numero);
    }

    public String listarOperacionesDeCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            return "Cuenta no válida";
        }

        List<Operacion> operaciones = cuenta.getRegistra();
        if (operaciones.isEmpty()) {
            return "No hay operaciones registradas para esta cuenta";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n===== OPERACIONES DE LA CUENTA ").append(cuenta.getNumCuenta()).append(" =====\n");
        for (Operacion op : operaciones) {
            sb.append(op.toString()).append("\n");
        }
        return sb.toString();
    }
}
