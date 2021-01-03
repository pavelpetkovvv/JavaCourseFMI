package Encryption;

import java.util.Collections;
import java.util.Locale;

public class Encryption {

    private class MonoEncryption implements IEncryptable {

        final int ALPHABET = 26; //size of english alphabet
        final int A_ASCII = 65; //ASCII number of letter A
        final int Z_ASCII = 90; //ASCII number of letter Z

        @Override
        public String encrypt(String plainText, String cipher) {

            //converting the cipher and the plain text to upper case to make sure everything works correctly
            cipher = cipher.toUpperCase(Locale.ROOT);
            plainText = plainText.toUpperCase(Locale.ROOT);

            char[] cipherArr = getCipherArr(cipher);
            char[] plainTextArr = plainText.toCharArray();
            char[] cipheredTextArr = new char[plainText.length()];

            for(int i = 0;i < cipheredTextArr.length;i++){
                cipheredTextArr[i] = cipherArr[(int)plainTextArr[i] - A_ASCII];
            }

            return new String(cipheredTextArr);
        }

        @Override
        public String decrypt(String cipherText, String cipher) {

            //converting the cipher and the plain text to upper case to make sure everything works correctly
            cipher = cipher.toUpperCase(Locale.ROOT);
            cipherText = cipherText.toUpperCase(Locale.ROOT);

            char[] cipherArr = getCipherArr(cipher);
            char[] cipherTextArr = cipherText.toCharArray();
            char[] decipheredTextArr = new char[cipherText.length()];

            for(int i = 0;i < decipheredTextArr.length;i++){
                for(int j = 0;j < cipherArr.length; j++){
                    if(cipherArr[j] == cipherTextArr[i]){
                        decipheredTextArr[i] = (char) (j + A_ASCII);
                    }
                }
            }

            return new String(decipheredTextArr);
        }


        //will be good to divide this method in two or three smaller methods
        private char[] getCipherArr(String cipher){ //returns char array holding the cipher
            //to be used in encrypt and decrypt functions

            char[] cipherCharArr = cipher.toCharArray(); //to store the cipher word as char array
            char[] cipherArr = new char[ALPHABET]; //to create the cipher that will be used to cipher/decipher
            boolean[] existingLetters = new boolean[ALPHABET]; //to keep track of the letters already in the cipher

            int count = 0;

            for(int i = 0;i < cipherCharArr.length; i++){ //places the letters of the cipher word in the beginning of the cipher

                if(!existingLetters[(int)cipherCharArr[i] - A_ASCII]) {//checks if loop has already encountered the letter
                    existingLetters[(int)cipherCharArr[i] - A_ASCII] = true; //and removes repeating letters
                    cipherArr[count] = cipherCharArr[i];
                    count++;
                }
            }

            int letter = (int)'Z';

            for(int i = count;i < cipherArr.length; i++){ //fills the cipher with the remaining letters from the alphabet
                                                            // starting from Z
                if(!existingLetters[letter  - A_ASCII]){
                    cipherArr[i] = (char) letter;
                    existingLetters[letter - A_ASCII] = true;
                    letter--;
                }else {
                    i--;
                    letter--;
                }
            }

            return cipherArr;
        }
    }

    IEncryptable getMonoCipher(){
        return (IEncryptable) new MonoEncryption();
    }

}
