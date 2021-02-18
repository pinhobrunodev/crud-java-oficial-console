package services;

public class AClientService extends ClientService{
    
    private IClientService iclientService;

    public AClientService(IClientService iclientService) {
        this.iclientService=iclientService;;
    }

    public IClientService getIclientService() {
        return iclientService;
    }
    public void setIclientService(IClientService iclientService) {
        this.iclientService = iclientService;
    }
    
}
