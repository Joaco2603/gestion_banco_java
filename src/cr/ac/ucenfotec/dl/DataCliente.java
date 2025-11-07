package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

public class DataCliente {
    private List<Cliente> clientes;

    public DataCliente() {
        this.clientes = new ArrayList<>();
    }

    public boolean agregar(Cliente cliente) {
        // Verificar que no exista un cliente con la misma cédula
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cliente.getCedula())) {
                return false;
            }
        }
        return clientes.add(cliente);
    }

    public Cliente buscar(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public boolean actualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cliente.getCedula())) {
                clientes.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String cedula) {
        return clientes.removeIf(c -> c.getCedula().equals(cedula));
    }
}
