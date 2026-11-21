
package service;

import model.Cliente;
import repository.IClienteRepository;
import util.Console;

public class ClienteService {

    // Inversión de control: uso de interfaces
    private IClienteRepository clienteRepo;

    public ClienteService(IClienteRepository repo) {
        this.clienteRepo = repo;
    }

    // Validación de DNI
    public void registrarCliente(String dni, String nombre, String tipo) {

        // DNI obligatorio y exactamente 8 dígitos numéricos
        if (dni == null || !dni.matches("\\d{8}")) {
            Console.error("Cliente inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
