import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.Arrays;
import java.util.function.Consumer;

public class InventoryDepartment {
    private Manager manager;
    private int index;
    private int INVENTORY_SIZE;
    private InventoryItem[] inventoryItems;

    public InventoryDepartment(Manager manager) {
        INVENTORY_SIZE = 1000;
        inventoryItems = new InventoryItem[INVENTORY_SIZE];
        setManager(manager);
        index = 0;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = new Manager(manager);
        this.manager.addOnProcessProductSupply(this::addInventory);
    }

    public InventoryItem[] getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(InventoryItem[] inventoryItems) {
        this.inventoryItems = new InventoryItem[inventoryItems.length];

        for(int i = 0; i < inventoryItems.length; i++){
            this.inventoryItems[i] = inventoryItems[i];
        }
    }

    @Override
    public String toString() {
        String str = "InventoryDepartment \n" +
                "Manager:" + manager + "\n";
        for(int i = 0; i < index; i++){
            str += inventoryItems[i].toString();
            str +=",\n";
        }
        return str;
    }

    void addInventory(Product[] products){
        for(Product pp : products){
            int i = lookup(pp);
            if(i > -1){
                inventoryItems[i].setQtyOnHand(inventoryItems[i].getQtyOnHand() + pp.getReorderQty());
            }
            else if(index < INVENTORY_SIZE - 1){
                inventoryItems[index] = new InventoryItem(pp, pp.getReorderQty());
                index++;
            }
        }
    }

    int lookup(Product pp){
        for (int i = 0;i < index; i++) {
            if (inventoryItems[i].getDescription().equals(pp.getDescription())) {
                return i;
            }
        }

        return -1;
    }
}
