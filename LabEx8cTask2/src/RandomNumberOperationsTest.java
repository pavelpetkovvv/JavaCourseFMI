public class RandomNumberOperationsTest {

    public static void main(String[] args) {
        RandomNumbersOperations rno = new RandomNumbersOperations(69);

        System.out.println("Sum of all elements: " + rno.calculateSum());

        System.out.println("Average of all elements: " + rno.average());

        System.out.println(rno.toString());

    }
}
