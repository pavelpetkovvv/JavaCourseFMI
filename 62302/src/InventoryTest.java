public class InventoryTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Pavel");
        InventoryDepartment department = new InventoryDepartment(manager);

        Product laptop = new Product("Asus", 5);
        Product phone = new Product("Samsung S20", 10);
        Product printer = new Product("HP", 7);

        Product[] products = {laptop, phone, printer};

        department.addInventory(products);

        System.out.println(department.toString());

        Product printer2 = new Product("HP", 7);

        Product[] products2 = {printer2};

        department.addInventory(products2);

        System.out.println(department.toString());

    }
}
