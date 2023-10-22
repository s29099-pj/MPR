package org.carrental.repository;

import org.carrental.model.Car;
import org.carrental.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository {
    List<Client> clientList = new ArrayList<>();


    public Optional<Client> getById(Integer id){
        return clientList.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    public Client create(Client client){
        client.setId(clientList.size());
        clientList.add(client);

        return client;

    }

    public Optional<Client> updateName(Integer id, String name){
        Optional<Client> optionalClient = getById(id);

        return optionalClient.map(client -> {
            client.setName(name);
            return client;
        });
    }

    public Optional<Client> updateSurname(Integer id, String surname){
        Optional<Client> optionalClient = getById(id);

        return optionalClient.map(client -> {
            client.setSurname(surname);
            return client;
        });
    }

    public Optional<Client> updateAge(Integer id, Integer age){
        Optional<Client> optionalClient = getById(id);

        return optionalClient.map(client -> {
            client.setAge(age);
            return client;
        });
    }

    public void removeAll(){
        clientList = new ArrayList<>();
    }

    public void removeById(Integer id){
        Optional<Client> optionalClient = getById(id);

        optionalClient.ifPresent(it -> clientList.remove(it));
    }


}
