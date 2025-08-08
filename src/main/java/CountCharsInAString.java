import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> chars = new LinkedHashMap<>();
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            Integer occurrence = chars.get(input.charAt(i));
            if (!c.toString().equals(" ")) {
                if (occurrence != null) {
                    chars.put(input.charAt(i), occurrence + 1);
                } else {
                    chars.put(input.charAt(i), 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

