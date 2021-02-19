## CRUD EM JAVA OFICIAL PELO CONSOLE



## 📌CREATE(CRIAR)


    @Override
     public boolean create(Client client) {
        try {
            clients.add(client);

        } catch (Exception e) {
            return false;
        }
        return true;
    }


## 📌READ(LER)


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


## 📌UPDATE(ATUALIZAR)

  
      @Override
      public boolean updtade( String newName, String newEmail,String searchEmail) {
        Integer searchEmailHash = searchEmail.hashCode();
        try {

            if(!clients.isEmpty()){
                for (Client c : clients) {
                    // Se hash do email que procuro igual hash do email na lista
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


 ## 📌DELETE(DELETAR)


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
