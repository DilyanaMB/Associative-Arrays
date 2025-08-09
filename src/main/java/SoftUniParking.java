import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> plateNumbersByUsers = new LinkedHashMap<>();
        int count = Integer.parseInt(sc.nextLine());
        while (count > 0) {
            count--;
            List<String> data = Arrays.stream(sc.nextLine().split("\\s+")).toList();
            String command = data.get(0);
            boolean isRegistered = plateNumbersByUsers.containsKey(data.get(1));
            switch (command) {
                case "register":
                    if (isRegistered) {
                        System.out.println("ERROR: already registered with plate number " + plateNumbersByUsers.get(data.get(1)));
                    } else {
                        plateNumbersByUsers.put(data.get(1), data.get(2));
                        System.out.printf("%s registered %s successfully\n", data.get(1), data.get(2));
                    }
                    break;
                case "unregister":
                    if (isRegistered) {
                        plateNumbersByUsers.remove(data.get(1));
                        System.out.printf("%s unregistered successfully\n",data.get(1));
                    } else {
                        System.out.printf("ERROR: user %s not found\n", data.get(1));
                    }
                    break;
            }
        }
        for (Map.Entry<String,String> entry: plateNumbersByUsers.entrySet()){
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }
    }
}