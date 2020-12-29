import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListTest {
    ArrayList<String> myArrayList;

    public ArrayListTest() {
        myArrayList = new ArrayList<String>();
    }

    public void getNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many names would you like to enter: ");
        int numberOfNames = scanner.nextInt();
        String name;
        System.out.println();

        for(int i = 0; i <= numberOfNames; i++){
            name = scanner.nextLine();
            if(!myArrayList.contains(name)){
                myArrayList.add(name);
            }
        }
    }

    public void searchNames(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();

        if(myArrayList.contains(name)){
            System.out.println(" " + name + " exists in the array.");
        }else
        {
            System.out.println(" " + name + " does not exists in the array.");
        }

    }

    public void sort(){
        Collections.sort(myArrayList);
    }

    public void copyTo(ArrayList<String> dest){
        if(dest != null) {
            dest.clear();
            for (var s : myArrayList) {
                dest.add(s);
            }
        }
    }

    @Override
    public String toString() {
        String strUpward = new String();
        String strDownward = new String();

        ArrayList<String> arrayList;
        arrayList = (ArrayList<String>) myArrayList.clone();
        Collections.sort(arrayList);

        for(var element : arrayList){
            strUpward += element;
            strUpward += " ";
        }

        Collections.reverse(arrayList);

        for(var element : arrayList) {
            strDownward += element;
            strDownward += " ";
        }

        return "Upward: " + strUpward + "\nDownward: " + strDownward;
    }

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        ArrayList<String> arrayList= new ArrayList<String>();

        arrayListTest.getNames();
        arrayListTest.copyTo(arrayList);
        arrayListTest.searchNames();
        System.out.println(arrayListTest.toString());
        arrayListTest.sort();

        for(var element : arrayList)
            System.out.println(element);
    }
}
