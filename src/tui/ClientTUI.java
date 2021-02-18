package tui;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Client;
import exceptions.EmptyEmailException;
import exceptions.EqualNameEmailException;
import exceptions.RepeatedEmailException;
import services.AClientService;
import services.ClientService;

public class ClientTUI {

    public static void run(){
        Scanner sc = new Scanner(System.in);


        String name;
        String email;
        String novoNome;
        String novoEmail;
        String emailBuscar;
        String emailDeletar;
        int option;
        try{
            
            AClientService as = new AClientService(new ClientService());


            do{
               

                    System.out.println("");
                    System.out.println("[1]- ADICIONAR || [2]-LER  || [3] - ATUALIZAR || [4]- DELETAR || [5]-SAIR ");
                    System.out.println("");
                    option = sc.nextInt();
                    System.out.println("");

                    switch (option) {
                        // 1
                        case 1 :
                       
                        System.out.println("Nome: ");
                        name = sc.next();
                        System.out.println("Email: ");
                        email = sc.next();
                        System.out.println();
                        as.authClientCredential(name, email);
                        as.authEmail(email);
                        as.create(new Client(email,name));
                        
                        break;

                        case 2:
                        
                            as.read();
                            
                            break;
                        case 3:
                        System.out.println("Para alterar os dados,informe o e-mail do individuo: ");
                        emailBuscar =sc.next();
                        as.EmptyauthEmail(emailBuscar);
                        System.out.println("Novo nome: ");
                        novoNome = sc.next();
                        System.out.println("Nome email: ");
                        novoEmail = sc.next();
                        as.authClientCredential(novoNome, novoEmail);
                        as.authEmail(novoEmail);
                        as.updtade( novoNome, novoEmail, emailBuscar);
                        
                            break;
                            case 4:
                            System.out.println("Para deletar os dados , informe o e-mail do individuo: ");
                            emailDeletar = sc.next();
                            System.out.println();
                            as.EmptyauthEmail(emailDeletar);
                            as.delete(emailDeletar);
                            break;
                            case 5:
                            as.exit();
                            break;
                        default:
                            as.exit();
                            break;
                    }
                
              


            }while(1 != 4);


        }
        catch(RepeatedEmailException e){
            System.out.println(e.getMessage());
        }
        catch(EqualNameEmailException e){
            System.out.println(e.getMessage());
        }
        catch(EmptyEmailException e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Erro inesperado");
        }
        catch(RuntimeException e){
            System.out.println("Erro inesperado");
        }
        finally{
            sc.close();
        }
    }
    
}
