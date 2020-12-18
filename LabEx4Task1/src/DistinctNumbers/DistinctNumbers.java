package DistinctNumbers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class DistinctNumbers {

    private ArrayList<Integer> arr = new ArrayList<Integer>();

    public void enterNumbersInArray(int countOfNumbers){
        Scanner sc = new Scanner(System.in);
        Integer userInputInt;
        for(int i=0;i<countOfNumbers;i++){
            userInputInt = sc.nextInt();
            arr.add(userInputInt);
        }
    }

    void displayDistinctNumbers(){
        ArrayList<Integer> copyArr = arr;
        //Collections.copy(copyArr, arr);

        java.util.Collections.sort(copyArr);
        int temp = copyArr.get(0);
        int count = 1;

        for(int i = 0;i < copyArr.size();i++){
            if(copyArr.get(i)>temp){
                count++;
                System.out.printf("%d ",temp);
                temp = copyArr.get(i);
            }

        }
        System.out.printf("%d ",temp);
    }


}
