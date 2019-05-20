package restaurant;

import client.Client;

import java.util.ArrayList;

public class Restaurant {
    private static Restaurant restaurant;
    private ArrayList <Client> clientList = new ArrayList<Client> ();

    //done
    public static Restaurant Restaurant() {
        if(restaurant == null) {
            restaurant = new Restaurant();
            return restaurant;
        }
        return restaurant;
    }
    //done
    public void addClient ()
    {
        Client newClient  = new Client();
        clientList.add(newClient);

    }
    //done
    public void removeClient(int clientNumber)
    {
        int i;
        for (i=0;i<clientList.size();i++)
        {
            if(clientList.get(i).getClientNumber() == clientNumber )
                break;
        }
        clientList.remove(i);
    }
    //done as showClientProducts
    public ArrayList<Client> getClientList() {
        return clientList;
    }
    //done
    public boolean contains(int actualClient) {
        for(int i=0;i<clientList.size();i++)
        {
            if (clientList.get(i).getClientNumber() == actualClient )
                return true;
        }
        return false;
    }
    // no longer needed
    public Client getClient(int actualClient) {
        int i;
        for (i=0;i<clientList.size();i++)
        {
            if (clientList.get(i).getClientNumber() == actualClient)
                break;
        }
        return clientList.get(i);

    }


}
