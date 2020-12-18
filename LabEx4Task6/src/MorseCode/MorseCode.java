package MorseCode;

import java.util.ArrayList;

public class MorseCode {

    private  final String[] code =      {".-", "-...", "-.-.", "-..", ".", "..-.", //A-F
                                        "--.", "....", "..", ".---", "-.-", ".-..", //G-L
                                        "--", "-.", "---", ".--.", "--.--", ".-.", //M-R
                                        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."}; //S-Z

    public String encode(String textToBeEncoded){
        textToBeEncoded = capitalize(textToBeEncoded);

        char[] text = textToBeEncoded.toCharArray();

        String morseCodeString = new String();

        for (int i = 0; i < text.length; i++){
            if((int)text[i] < 65 || (int)text[i] > 90)
                continue;
            morseCodeString = morseCodeString.concat(code[(text[i]-65)]);
            morseCodeString = morseCodeString.concat(" ");
        }

        return morseCodeString;
    }

    public String decode(String initialMorseCode) {

        char[] morseCode = initialMorseCode.toCharArray();

        String decodedText = new String();

        for (int i = 0; i < morseCode.length; i++) {
            int count = i;

            String morseSequence = new String();
            do {
                morseSequence = morseSequence.concat(String.valueOf(morseCode[count]));
                count++;
            } while (morseCode[count] != ' ' && count < morseCode.length);
            i = count;

            for (int j = 0; j < code.length; j++) {
                if (morseSequence.compareTo(code[j]) == 0) {
                    decodedText = decodedText.concat(String.valueOf((char)(j + 65)));
                }
            }
        }
        return decodedText;
    }

    private String capitalize(String initialText) { //function which converts small letters to capital
        char[] text = initialText.toCharArray();
        for (int i = 0; i < text.length; i++) {
            if ((int) text[i] > 96 && (int) text[i] < 122) {
                text[i] = (char) ((int) text[i] - 32);
            }
        }
        String capitalizedText = new String(text);
        return capitalizedText;
    }
}

