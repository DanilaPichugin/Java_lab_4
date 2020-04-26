package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();//<>
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();//<>

    public void addItem(GenericItem item) {
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }


    public void addItem(GenericItem... items){
        for(GenericItem/*var*/ item : items){
            this.addItem(item);
        }
    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id){
        //return catalog.getOrDefault(id, null);
        if (!catalog.containsKey(id)){
            return null;
        }else{
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id){
        for (GenericItem i : ALCatalog){
            if(i.getID() == id)
                return i;
        }
        return null;
    }
}