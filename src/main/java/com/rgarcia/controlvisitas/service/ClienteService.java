package com.rgarcia.controlvisitas.service;

import com.rgarcia.controlvisitas.entity.Cliente;
import com.rgarcia.controlvisitas.repository.ClienteRepository;
import com.rgarcia.controlvisitas.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;
    @Autowired
    private VisitaRepository visitaRepo;

    public Cliente createClient(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente getCliente(Long clientId) {
        Cliente cliente = clienteRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + clientId));
        return cliente;

    }

    public List<Cliente> todosClientes() {
        return clienteRepo.findAll();
    }

//    public Visita agregarVisita(Long clienteId, Visita visita) {
//        Cliente cliente = clienteRepo.findById(clienteId)
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + clienteId));
//        visita.setCliente(cliente);
//        cliente.getVisita().add(visita);
//        return visitaRepo.save(visita);
//    }

    public void borrarCliente(Long clienteId) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + clienteId));
        clienteRepo.delete(cliente);
    }

}

