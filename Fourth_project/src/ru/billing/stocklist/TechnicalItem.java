package ru.billing.stocklist;

import java.util.Objects;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    TechnicalItem(int ID, String name, float price, Category category, short warrantyTime){
        super(ID, name, price, category);
        this.setWarrantyTime(warrantyTime);
    }

    @Override
    void printAll(){
        System.out.printf("ID: %-10d Name: %-10s Category: %-10s price: %-10.2f Warranty: %d\n", getID(), getName(), getCategory(), getPrice(), warrantyTime);
    }
    @Override
    public String toString(){
        return this.getName() + "|" + getID() + "|" + getCategory() + "|" + getPrice() + "|" + warrantyTime;
    }


    public boolean equals(TechnicalItem item){
        if (this == item){
            return true;
        }
        if (item == null || getClass() != item.getClass()){
            return false;
        }
        if(this.getID() == item.getID() && this.getName() == item.getName() && this.getPrice() == item.getPrice() && this.getCategory() == item.getCategory()
                && this.warrantyTime == item.warrantyTime){
            return true;
        }
        return false;
    }

    @Override
    public int hashcode(){
        return Objects.hash(getID(), getName(), getPrice(), getCategory(), warrantyTime);
    }

    @Override
    public TechnicalItem clone() throws CloneNotSupportedException{
        return (TechnicalItem) super.clone();
    }

    protected short getWarrantyTime() {
        return this.warrantyTime;
    }

    protected void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}


