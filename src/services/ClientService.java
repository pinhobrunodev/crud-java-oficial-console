package services;

import java.util.ArrayList;
import java.util.List;

import entities.Client;
import exceptions.EmptyEmailException;
import exceptions.EqualNameEmailException;
import exceptions.RepeatedEmailException;

public class ClientService  implements IClientService  {

    List<Client> clients = new ArrayList<Client>();


    @Override
    public boolean create(Client client) {
        try {
            clients.add(client);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void read() {
       try {
           if(!clients.isEmpty()){
               for (Client client : clients) {
                   System.out.println(client);
               }
           }
           else{
               System.out.println( "ERRO: Nao foi possivel ler,pois  a lista esta vazia");
           }
       } catch (Exception e) {
          e.getStackTrace();
       }
        
    }

    @Override
    public boolean updtade( String newName, String newEmail,String searchEmail) {
        Integer searchEmailHash = searchEmail.hashCode();
        try {

            if(!clients.isEmpty()){
                for (Client c : clients) {
                    // Se nome que procuro igual nome na lista
                    if(searchEmailHash.equals(c.getEmail().hashCode())){
                            clients.remove(c);
                            clients.add(new Client(newEmail, newName));
                    }
                    
                }
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(String email) {

        Integer emailRemove = email.hashCode();

        try {
            if(clients.isEmpty()){
                System.out.println("ERRO: Nao podemos remover.. lista esta vazia");
            }
            if(!clients.isEmpty()){
                for (Client x : clients) {
                    if(emailRemove.equals(x.getEmail().hashCode())){
                        clients.remove(x);
                        System.out.println("O Cliente:  "+x+ ", foi removido com sucesso");
                    }
                }
            }
           
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void exit(){
        System.out.println("Saindo do programa");
        System.exit(0);
    }
    

    public void authEmail(String email){
    if(clients.stream().filter(x->x.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null) != null ){ 
     throw  new RepeatedEmailException("ERRO: Email ja foi usado...inicie novamente o programa");
    }
}


    public void authClientCredential(String nome,String email){
        if(nome.equalsIgnoreCase(email)){
            throw new EqualNameEmailException("ERRO: Nome e email iguais ! Reinicie o programa");
        }
    }


    

    public void EmptyauthEmail(String deleteEmail){

        if(clients.stream().filter(x->x.getEmail().equalsIgnoreCase(deleteEmail)).findFirst().orElse(null) == null){
            throw new EmptyEmailException("ERRO: O email "+deleteEmail.toUpperCase()+" nao foi cadastrado ainda ! PROGRAMA FINALIZADO");
        }
    }




    

 
    
}
