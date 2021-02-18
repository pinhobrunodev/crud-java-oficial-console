package services;

import entities.Client;

public interface IClientService {
    

    boolean create(Client client);
    void read();
    boolean updtade(String newName,String newEmail,String searchName);
    boolean delete(String name);
    


}
