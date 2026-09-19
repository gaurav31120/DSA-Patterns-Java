// Approach 01: Stack / StringBuilder
// Time: O(n)
// Space: O(n)

public class _01_Stack {

    static String process(String str) {

        StringBuilder sb = new StringBuilder();

        // Process each character.
        for (char ch : str.toCharArray()) {

            if (ch == '#') {

                // Remove the previous character if one exists.
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

            } else {

                // Add the current character.
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    static boolean backspaceCompare(String s, String t) {

        return process(s).equals(process(t));
    }

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        boolean result = backspaceCompare(s, t);

        System.out.println("Strings are equal: " + result);
    }
}

// Output:
// Strings are equal: true