package org.carrental.service;


import lombok.RequiredArgsConstructor;
import org.carrental.exception.ValidationException;
import org.carrental.model.Car;
import org.carrental.model.Client;
import org.carrental.repository.ClientRepository;

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public Client addClient(Client client){
        if (client.getName().isBlank()){
            throw new ValidationException("Cannot be blank", "name");
        }
        if (client.getSurname().isBlank()){
            throw new ValidationException("Cannot be blank", "surname");
        }
        if(client.getAge() < 18){
            throw new ValidationException("Age to low", "age");
        }

        clientRepository.create(client);

        return client;
    }


}
