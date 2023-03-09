package core.ics.service;

import core.ics.dto.ClientDTO;
import core.ics.model.*;
import core.ics.repository.ClientRepository;
import core.ics.status.ClientStatus;
import core.ics.utils.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    @Inject
    @RestClient
    AddressRequest addressRequest;

    @Inject
    @RestClient
    AccountRequest accountRequest;

    @Inject
    @RestClient
    CardRequest cardRequest;

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

    public ClientDTO findByID(String value){
        Long id = ValidateParameter.validate(value);
        Client c = clientRepository.findById(id);
        return new ClientDTO(c);
    }

    public ClientDTO findClientFullData(String value){

        Long id = ValidateParameter.validate(value);
        Client c = clientRepository.findById(id);

        Account account = accountRequest.findAccountByID(value);
        Card card = cardRequest.findCardByID(value);
        Address address = addressRequest.requestAddress(c.getAddress());

        ClientDTO dto = new ClientDTO();

        dto.setAccount(account);
        dto.setCard(card);
        dto.setAddress(address);

        return dto;
    }

    public List<Client> findByName(String name){
        return clientRepository
                .list("name", name)
                .stream()
                .filter(cl->cl.getStatus().equals(ClientStatus.ACTIVE.toString()))
                .collect(Collectors.toList());
    }

    // https://renatogroffe.medium.com/postgresql-pgadmin-4-docker-compose-montando-rapidamente-um-ambiente-para-uso-55a2ab230b89
}
