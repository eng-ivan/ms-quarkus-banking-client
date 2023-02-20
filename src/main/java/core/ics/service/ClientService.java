package core.ics.service;

import core.ics.model.Client;
import core.ics.repository.ClientRepository;
import core.ics.status.ClientStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public Client save(Client client){

        client.setStatus(ClientStatus.ACTIVE.toString());
        clientRepository.persist(client);
        return client;
    }

    public List<Client> list(){
        return clientRepository
                .listAll()
                .stream()
                .filter(c -> c.getStatus().equals(ClientStatus.ACTIVE.toString()))
                .collect(Collectors.toList());
    }

    public Client findByID(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> findByName(String name){
        return clientRepository.list("name", name);
    }
}
