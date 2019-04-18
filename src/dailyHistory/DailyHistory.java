package dailyHistory;

import product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class DailyHistory {
    private static ArrayList< HashMap<Integer, ArrayList<HashMap < Integer, Product> > > > historyList = new ArrayList<> ();

    public static ArrayList<HashMap<Integer, ArrayList< HashMap<Integer, Product>>>> DailyHistory() {
        if(historyList == null) {
            historyList = new ArrayList<>();
            return historyList;
        }
        return historyList;
    }

    public void addEntry(HashMap<Integer, ArrayList<HashMap<Integer, Product> > >  entryToAdd)
    {
        historyList.add(entryToAdd);
    }

    @Override
    public String toString() {
        String stringToReturn = new String();
        stringToReturn = "Daily History : \n";
        for(int i=0;i<historyList.size();i++)
        {
            stringToReturn = stringToReturn + historyList.get(i).toString();

        }
        return stringToReturn;
    }

    public void delete() {
        while(historyList.size()!=0)
            historyList.remove(historyList.size()-1);
    }
}

