package Barcode;

public class Barcode {

    private final int[][] code = {
            {1,1,0,0,0},//0
            {0,0,0,1,1},//1
            {0,0,1,0,1},//2
            {0,0,1,1,0},//3
            {0,1,0,0,1},//4
            {0,1,0,1,0},//5
            {0,1,1,0,0},//6
            {1,0,0,0,1},//7
            {1,0,0,1,0},//8
            {1,0,1,0,0} //9
    };

    public String decode(int zipCode){

        zipCode = zipLengthCheck(zipCode);

        char[] barCode = new char[15];

        int counter=0;

        for(int i = 0; i < 5; i++){
            if(code[zipCode/100][i] == 1){
                barCode[counter] = '|';
            }else
                barCode[counter] = ':';
            counter++;
        }

        for(int i = 0; i < 5; i++){
            if(code[zipCode/10%10][i] == 1){
                barCode[counter] = '|';
            }else
                barCode[counter] = ':';
            counter++;
        }

        for(int i = 0; i < 5; i++){
            if(code[zipCode%10][i] == 1){
                barCode[counter] = '|';
            }else
                barCode[counter] = ':';
            counter++;
        }

        String barcodeString = new String(barCode);

        return barcodeString;
    }

    private int zipLengthCheck(int zipToBeChecked){
        if(zipToBeChecked < 1000)
            return zipToBeChecked;
        else
            return zipToBeChecked%1000;
    }

}
