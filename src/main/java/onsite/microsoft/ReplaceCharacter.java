package onsite.microsoft;

/**
 * Microsoft Contract Job
 * Implement a method to replace all spaces in a string with %20 in place
 * <p>
 * input: char[] charArray of "Seattle has lot snow."
 * <p>
 * output: "Seattle%20has%20lot%20snow."
 * <p>
 * Optimize: replace space in place
 *
 * @description URLify ~ A small method that makes a string with spaces URL Friendly!
 * @return String
 */
public class ReplaceCharacter {

    static final int MAX_LENGTH = 6000;

    public static void main(String[] args) {
        ReplaceCharacter addNewChar = new ReplaceCharacter();
        String str = "Seattle has lot snow.";
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        System.out.println(addNewChar.URLify(ch));
    }

    public String URLify(char[] oldArray) {
        int numberOfSpaces = 0;

        for (char c : oldArray) {
            if (c == ' ') {
                numberOfSpaces++;
            }
        }

        int newLength = oldArray.length + numberOfSpaces * 2;
        if (newLength > MAX_LENGTH) {
            return "-1";
        }
        char[] newArray = new char[newLength];

        for (int i = 0, index = 0; i < oldArray.length; i++) {
            char c = oldArray[i];
            if (c != ' ') {
                newArray[index] = c;
                index++;
            } else {
                newArray[index] = '%';
                newArray[index + 1] = '2';
                newArray[index + 2] = '0';
                index = index + 3;
            }
        }

        return String.valueOf(newArray);
    }
}
