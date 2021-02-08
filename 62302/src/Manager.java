import java.util.function.Consumer;

public class Manager {
    private String name;
    private Consumer<Product[]> processProductSupply;

    public Manager(String name) {
        setName(name);
    }

    public Manager(Manager manager) {
        setName(manager.getName());
        processProductSupply = manager.processProductSupply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager:" + name;
    }

    public void onProductSupply(Product[] products){
        processProductSupply.accept(products);
    }

    public void addOnProcessProductSupply(Consumer<Product[]> consumer){
        processProductSupply = a -> consumer.accept(a);
    }
}
