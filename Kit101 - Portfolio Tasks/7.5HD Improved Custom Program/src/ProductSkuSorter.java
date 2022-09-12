import java.util.Comparator;

/**
 * This is a Comparator class used for Collections methods (specifically
 * Collections.sort) * @author Paul Watts * @version 1.0 (October 2020)
 */

public class ProductSkuSorter implements Comparator<Product> {
  @Override
  public int compare(Product o1, Product o2) {
    return o1.getSku().compareTo(o2.getSku());
  }

}
