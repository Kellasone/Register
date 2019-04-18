package restaurant;

import client.Client;

import java.util.ArrayList;

public class Restaurant {
    private static Restaurant restaurant;
    private ArrayList <Client> clientList = new ArrayList<Client> ();

    public static Restaurant Restaurant() {
        if(restaurant == null) {
            restaurant = new Restaurant();
            return restaurant;
        }
        return restaurant;
    }

    public void addClient ()
    {
        Client newClient  = new Client();
        clientList.add(newClient);

    }

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

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public boolean contains(int actualClient) {
        for(int i=0;i<clientList.size();i++)
        {
            if (clientList.get(i).getClientNumber() == actualClient )
                return true;
        }
        return false;
    }

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
