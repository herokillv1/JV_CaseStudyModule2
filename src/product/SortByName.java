package product;


import java.util.Comparator;

public class SortByName implements Comparator<ProductsList> {
    @Override
    public int compare(ProductsList o1, ProductsList o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
