/*
 * Coding Question
Duration: 45 Minutes
Problem: Grid Path Encoder
You are building a navigation app that encodes movement directions. The app converts a sequence of moves (UP, DOWN, LEFT, RIGHT) into a compressed format. Your job is to encode a path into compressed form, and also decode it back to the original path.
How to Encode a Path
1.	Convert all directions to single letters: U, D, L, R
2.	Remove all spaces
3.	If the number of letters is odd, add an 'S' (stop) at the end
4.	Look at the letters two at a time. For example, "UDLR" becomes "UD", "LR"
5.	For each pair of letters: 
a.	a. Convert the first letter to a number (U=1, D=2, L=3, R=4, S=5)
b.	b. Convert the second letter to a number (U=1, D=2, L=3, R=4, S=5)
c.	c. Multiply the first number by 10 and add the second number
6.	Combine all numbers to create the encoded path
How to Decode a Path
1.	Split the encoded numbers into individual two-digit numbers
2.	For each two-digit number: 
a.	a. The first digit represents the first direction (1=U, 2=D, 3=L, 4=R)
b.	b. The second digit represents the second direction (1=U, 2=D, 3=L, 4=R)
3.	Combine all the letters to get the original path
4.	If the last letter is 'S', remove it (it was padding)
Note: You are allowed to hardcode the input values for simplicity.
Note: Examples and explanations are given in the next page
Examples:
Example 1:
Encode:
•	Input: UP DOWN LEFT RIGHT
•	Output: 12-34
Decode:
•	Input: 12-34
•	Output: UPDOWNLEFTRIGHT
Example 2:
Encode:
•	Input: RIGHT RIGHT UP
•	Output: 44-15
Decode:
•	Input: 44-15
•	Output: RIGHTRIGHTUPS
Explanation:
For "UP DOWN LEFT RIGHT":
•	Convert to letters: "UDLR"
•	No spaces needed to remove: "UDLR" (4 letters, even, no padding)
•	Pairs: "UD", "LR"
•	Encode each pair: 
o	"UD" → U=1, D=2 → 1×10+2 = 12
o	"LR" → L=3, R=4 → 3×10+4 = 34
•	Result: 12-34
For decoding 12-34:
•	Split: 12, 34
•	Decode each: 
o	12 → first digit=1 (U), second digit=2 (D) → "UD"
o	34 → first digit=3 (L), second digit=4 (R) → "LR"
•	Expand: "UP DOWN LEFT RIGHT"


 */

package prep.coding;

import java.util.*;

public class GridPathEncoder {

    // ─── Encoding Maps ───────────────────────────────────────────────
    private static final Map<String, Character> WORD_TO_LETTER = new LinkedHashMap<>();
    private static final Map<Character, Integer> LETTER_TO_NUM  = new LinkedHashMap<>();
    private static final Map<Integer, Character> NUM_TO_LETTER  = new LinkedHashMap<>();
    private static final Map<Character, String>  LETTER_TO_WORD = new LinkedHashMap<>();

    static {
        WORD_TO_LETTER.put("UP",    'U');
        WORD_TO_LETTER.put("DOWN",  'D');
        WORD_TO_LETTER.put("LEFT",  'L');
        WORD_TO_LETTER.put("RIGHT", 'R');

        LETTER_TO_NUM.put('U', 1);
        LETTER_TO_NUM.put('D', 2);
        LETTER_TO_NUM.put('L', 3);
        LETTER_TO_NUM.put('R', 4);
        LETTER_TO_NUM.put('S', 5);

        NUM_TO_LETTER.put(1, 'U');
        NUM_TO_LETTER.put(2, 'D');
        NUM_TO_LETTER.put(3, 'L');
        NUM_TO_LETTER.put(4, 'R');
        NUM_TO_LETTER.put(5, 'S');

        LETTER_TO_WORD.put('U', "UP");
        LETTER_TO_WORD.put('D', "DOWN");
        LETTER_TO_WORD.put('L', "LEFT");
        LETTER_TO_WORD.put('R', "RIGHT");
    }

    // ─── ENCODE ──────────────────────────────────────────────────────
    public static String encode(String input) {
        // Step 1 & 2: Convert words → letters, remove spaces
        StringBuilder letters = new StringBuilder();
        String[] words = input.trim().split("\\s+");
        for (String word : words) {
            Character letter = WORD_TO_LETTER.get(word.toUpperCase());
            if (letter != null) letters.append(letter);
        }

        // Step 3: Pad with 'S' if odd length
        if (letters.length() % 2 != 0) letters.append('S');

        // Steps 4 & 5: Process pairs → two-digit numbers
        List<String> encodedParts = new ArrayList<>();
        for (int i = 0; i < letters.length(); i += 2) {
            int first  = LETTER_TO_NUM.get(letters.charAt(i));
            int second = LETTER_TO_NUM.get(letters.charAt(i + 1));
            encodedParts.add(String.valueOf(first * 10 + second));
        }

        // Step 6: Join with '-'
        return String.join("-", encodedParts);
    }

    // ─── DECODE ──────────────────────────────────────────────────────
    public static String decode(String encoded) {
        // Step 1: Split by '-'
        String[] parts = encoded.split("-");

        // Step 2 & 3: Decode each two-digit number → letters
        StringBuilder letters = new StringBuilder();
        for (String part : parts) {
            int num    = Integer.parseInt(part.trim());
            int first  = num / 10;
            int second = num % 10;
            letters.append(NUM_TO_LETTER.get(first));
            letters.append(NUM_TO_LETTER.get(second));
        }

        // Step 4: Remove trailing 'S' if present (padding)
        if (letters.charAt(letters.length() - 1) == 'S') {
            letters.deleteCharAt(letters.length() - 1);
        }

        // Expand letters → full words
        StringBuilder result = new StringBuilder();
        for (char c : letters.toString().toCharArray()) {
            result.append(LETTER_TO_WORD.get(c));
        }

        return result.toString();
    }

    // ─── MAIN ────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── Example 1 ──
        String input1   = "UP DOWN LEFT RIGHT";
        String encoded1 = encode(input1);
        String decoded1 = decode(encoded1);
        System.out.println("=== Example 1 ===");
        System.out.println("Input:   " + input1);
        System.out.println("Encoded: " + encoded1);   // 12-34
        System.out.println("Decoded: " + decoded1);   // UPDOWNLEFTRIGHT
        System.out.println();

        // ── Example 2 ──
        String input2   = "RIGHT RIGHT UP";
        String encoded2 = encode(input2);
        String decoded2 = decode(encoded2);
        System.out.println("=== Example 2 ===");
        System.out.println("Input:   " + input2);
        System.out.println("Encoded: " + encoded2);   // 44-15
        System.out.println("Decoded: " + decoded2);   // RIGHTRIGHTUP (S stripped internally)
    }
}
