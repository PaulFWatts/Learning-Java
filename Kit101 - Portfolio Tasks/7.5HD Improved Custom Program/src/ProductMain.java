/**
 * ProductMain
 *
 * This program is a driver for ProductSalesEnquiry which adds,
 * changes and displays Product information for Sales People
 *
 * @author  Paul Watts
 * @version 1.0 (October 2020)
 *
 */

public class ProductMain {

    public static void main(String[] args) {
	ProductSalesEnquiry sales = new ProductSalesEnquiry();
	sales.showMenu();
    }
}

