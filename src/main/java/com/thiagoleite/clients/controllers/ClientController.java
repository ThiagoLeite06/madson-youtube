package com.thiagoleite.clients.controllers;

import com.thiagoleite.clients.entities.Client;
import com.thiagoleite.clients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> clientsList() {
        return clientService.clientList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findClientById(@PathVariable("id") Long id) {
        return clientService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeClient(@PathVariable Long id) {
        clientService.findById(id)
                .map(client -> {
                    clientService.removeById(client.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

//    public void updateClient(Long id, Client client) {
//        clientService.findById(id)
//                .map(clientBase -> {
//
//                })
//    }


}
