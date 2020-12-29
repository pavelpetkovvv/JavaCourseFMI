import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class RandomNumbersOperations {
    java.util.LinkedList<Integer> linkedList;
    private int sumOfElements;

    RandomNumbersOperations(){
        Random random = new Random();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        linkedList = new LinkedList<Integer>();
        for(int i = 0;i < 25;i++){
            treeSet.add(random.nextInt(100));
        }

        sumOfElements = 0;
        var it = treeSet.iterator();
        while(it.hasNext()){
            int temp = it.next();
            linkedList.add(temp);
            sumOfElements += temp;
        }

    }

    RandomNumbersOperations(int seed){ //constructor which allows the user to enter the seed for the Random generator
        Random random = new Random(seed);  //(this allows easier tests)
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        linkedList = new LinkedList<Integer>();
        for(int i = 0;i < 25;i++){
            treeSet.add(random.nextInt(100));
        }

        sumOfElements = 0;
        var it = treeSet.iterator();
        while(it.hasNext()){
            int temp = it.next();
            linkedList.add(temp);
            sumOfElements += temp;
        }

    }

    public int calculateSum(){
        return sumOfElements;
    }

    public int average(){
        return sumOfElements/linkedList.size();
    }


    @Override
    public String toString() {
        var it = linkedList.iterator();
        String str = new String();

        while(it.hasNext()) {
            str += it.next();
            str += " ";
        }
        return str;
    }
}
