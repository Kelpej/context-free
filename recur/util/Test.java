package recur.util;

import java.util.Objects;

public class Test {
    static class Product {
        String title;

        public Product(String title) {
            this.title = title;
        }

        @Override
        public int hashCode() {
            return Objects.hash(title);
        }
    }

    public static void main(String[] args) {
        Product product = new Product("abc");
        if ("abc".hashCode() == product.hashCode())
            System.out.println("YES");
    }
}
