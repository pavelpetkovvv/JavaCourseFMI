public class Product {

    private String description;
    private int reorderQty;

    public Product() {
        description = new String("n/a");
        reorderQty = 0;
    }

    public Product(String description, int reorderQty) {
        setDescription(description);
        setReorderQty(reorderQty);
    }

    public Product(Product product) {
        setDescription(product.description) ;
        setReorderQty(product.reorderQty);
    }

    public String getDescription() {
        if(description != null)
            return description;
        else return "n/a";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        if(reorderQty >= 0)
            this.reorderQty = reorderQty;
        else
            this.reorderQty = 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + description + '\'' +
                ", reorderQty=" + reorderQty +
                '}';
    }
}
