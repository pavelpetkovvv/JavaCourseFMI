/*Solution to task 6 from lab ex. 4
A program that translates String into morse code and vise versa. It works with uppercase and lower case
letter, skips empty spaces and punctuation signs.
Notes:
Last modified: 11:00, 11.Nov.2020, Pavel Petkov
 */
package MorseCode;

public class MorseCodeTest {

    public static void main(String[] args) {
        MorseCode morseCode = new MorseCode();

        String plainText = new String("Text to be converted!");

        String encodedText = morseCode.encode(plainText);

        System.out.println(encodedText);

        System.out.println(morseCode.decode(encodedText));
    }
}
