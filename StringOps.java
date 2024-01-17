public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        int[] arr = allIndexOf("super mario bros wonder", 'r');
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String capVowelsLowRest (String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            char ichar = string.charAt(i);

            // if ichar is a letter A-Z (uppercase)
            if ((ichar >= 65) && (ichar <= 90)) {
                if (isVowel(ichar)) { // if uppercase vowel, simply add the char
                    newString += ichar;
                }
                else { // if uppercase non-vowel, make it lowercase
                    newString += (char) (ichar + 32);
                }
            }
            // if ichar is a letter a-z (lowercase)
            else if ((ichar >= 97) && (ichar <= 122)) {
                if (isVowel(ichar)) { // if lowercase vowel, make it uppercase
                    newString += (char) (ichar - 32);
                }
                else { // if lowercase non-vowel, simply add the char
                    newString += ichar;
                }
            }
            else { // if not a letter, simply add the char
                newString += ichar;
            }

        }
        return newString;
    }

    public static boolean isVowel (char c) {
        boolean vowel = false;

        if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {
            vowel = true;
        }

        if ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U')) {
            vowel = true;
        }

        return vowel;
    }

    public static String camelCase (String string) {
        // Write your code here:
        String newString = "";
        boolean spaceAbove = false;
        boolean letterYet = false;

        for (int i = 0; i < string.length(); i++) {
            
            // default spaceAbove to false, make it true if the prior char is space
            spaceAbove = false;
            if ((i > 0) && (string.charAt(i-1) == ' ') && (letterYet == true)) {
                spaceAbove = true;
            }

            char ichar = string.charAt(i);

            if ((ichar >= 65) && (ichar <= 90)) { // Uppercase
                if (spaceAbove == true) {
                    newString += ichar;
                }
                else {
                    newString += (char) (ichar + 32);
                }
            }
            else if ((ichar >= 97) && (ichar <= 122)) { // Lowercase
                if (spaceAbove == true) {
                    newString += (char) (ichar - 32);
                }
                else {
                    newString += ichar;
                }
            }

            if (ichar == ' ') {
                spaceAbove = true;
            }

            if (ichar != ' ') {
                letterYet = true;
            }
        }
        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        // To find the amount of char occurances to make the size of the array
        int charCount = 0;

        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                charCount++;
            }
        }
        
        int[] arr = new int[charCount];

        int arr_index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                arr[arr_index] = i;
                arr_index++;
            }
        }

        return arr;
    }
}
