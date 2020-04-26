package ru.billing.client;
import ru.billing.stocklist.*;

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        System.out.println('\n');
        var catalog = new ItemCatalog();

        catalog.addItem(new GenericItem(),new GenericItem(),new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(),
        new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem());
        //catalog.printItems();

        long begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        System.out.println('\n');
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        catalog.printItems();
    }
}
