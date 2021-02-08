public class InventoryItem extends Product{
    private int QtyOnHand;
    public String INVENTORY_CODE;
    private static int count = 1;

    public InventoryItem() {
        super();
    }

    public InventoryItem(Product product, int qtyOnHand) {
        super(product);
        QtyOnHand = qtyOnHand;
        INVENTORY_CODE = generateInventoryCode();
    }

    public InventoryItem(InventoryItem inventoryItem) {
        super(inventoryItem.getDescription(), inventoryItem.getReorderQty());
        setQtyOnHand(inventoryItem.getQtyOnHand());
        INVENTORY_CODE = new String(inventoryItem.INVENTORY_CODE);
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        if(qtyOnHand >= 0)
            QtyOnHand = qtyOnHand;
        else
            qtyOnHand = 0;
    }

    @Override
    public String toString() {
        return "InventoryItem: " +
                "Qty: " + QtyOnHand +
                ", INVENTORY_CODE: " + INVENTORY_CODE +
                ", Description: " + getDescription() +
                ", Reorder: " + getReorderQty();
    }

    private String generateInventoryCode(){
        String inventory_code = new String("P");
        String number = Integer.toString(count);
        for(int i = 1; i < 7 - number.length();i++)
            inventory_code += '0';
        inventory_code += number;

        count++;

        return inventory_code;
        // P000123
        // 0123456
    }
}

