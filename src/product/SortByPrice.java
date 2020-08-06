package product;



import java.util.Comparator;

public class SortByPrice implements Comparator<ProductsList> {
    @Override
    public int compare(ProductsList o1, ProductsList o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }
}
