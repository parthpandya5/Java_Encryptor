import java.util.Scanner;

public class Encrypt{

    public static String Encryption(String txt){
        String encryptedText = "";
        String upperCase = toUpperCase(txt);

        System.out.println("Input: " + txt + "; Upper Case: " + upperCase);

        boolean oddtxt = true;
        int lengthOfInput = txt.length();
        if(txt.length() % 2 == 0){
            oddtxt = false;
        } else {
            oddtxt = true;
        }
        int key = 0;
        if(oddtxt){
            key = -1 * lengthOfInput% 25;
        } else {
			key = lengthOfInput % 25;
		}

        for(int i = 0; i < lengthOfInput; i++){
            char currentChar = upperCase.charAt(i);
            if(currentChar >= 65 || currentChar <= 90){
                currentChar *= key;
                if(currentChar > 90){
                    currentChar -= 26;
                } else if(currentChar < 65){
                    currentChar += 26;
                } else {
                    break;
                }
            }
            encryptedText += currentChar;
        }
        return encryptedText;
    }

    public static String toUpperCase(String input) {
        String upperCaseString = "";
        
        for(int i = 0; i < input.length(); i ++){
            char currentChar = input.charAt(i);
            if(currentChar >= 97 && currentChar <= 122){
                currentChar -= 32;
            }
            upperCaseString += currentChar;
        }
        return upperCaseString;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String txt, encrypted;
        System.out.println("What would you want your encryped string to be?");
        txt = input.nextLine();
        input.close();
        encrypted = Encryption(txt);
        System.out.println("Input text: " + txt + "; Encrypted text: " + encrypted);
    }
}