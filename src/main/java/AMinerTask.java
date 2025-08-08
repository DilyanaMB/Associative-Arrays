import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();
        int row = 0;
        String currentResource = "";
        while (!input.equals("stop")) {
            row++;
            if (row % 2 == 0) {
                if (!resourceQuantity.containsKey(currentResource)) {
                    resourceQuantity.put(currentResource, Integer.parseInt(input));
                } else {
                    int currentQuantity = resourceQuantity.get(currentResource);
                    resourceQuantity.put(currentResource, currentQuantity + Integer.parseInt(input));
                }
            } else {
                currentResource = input;
            }
            input = sc.nextLine();
        }
      for (Map.Entry<String, Integer> entry:resourceQuantity.entrySet()){
          System.out.println(entry.getKey() + " -> " + entry.getValue());
      }
    }
}
