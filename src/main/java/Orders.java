import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, ProductPrice> products = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("buy")) {
            List<String> productData = Arrays.stream(input.split("\\s+")).toList();
            if (!products.containsKey(productData.get(0))) {
                products.put(productData.get(0),
                        new ProductPrice(Double.parseDouble(productData.get(1)), Integer.parseInt(productData.get(2))));
            } else {
                ProductPrice currentProduct = products.get(productData.get(0));
                currentProduct.setPrice(Double.parseDouble(productData.get(1)));
                currentProduct.setQuantity(currentProduct.quantity+Integer.parseInt(productData.get(2)));
            }
            input = sc.nextLine();
        }

        for (Map.Entry<String, ProductPrice> entry : products.entrySet()) {
            double finalPrice = entry.getValue().getPrice() * entry.getValue().getQuantity();
            System.out.printf("%s -> %.2f\n", entry.getKey(), finalPrice);
        }
    }
    public static  class ProductPrice {
        private double price;
        private int quantity;

        public ProductPrice( double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setPrice(double price){
            this.price =price;
        }

        public void setQuantity(int quantity){
            this.quantity =quantity;
        }
    }

}
