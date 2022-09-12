import java.util.Scanner;

/**
 * 7.4DN Custom Program
 *
 * This program adds, changes and displays Product information for Sales
 * People.The key functionality is the Sales Calculator which assists Sales
 * People choose a competitive selling price within company guidelines
 *
 * @author Paul Watts
 * @version 1.0 (October 2020)
 *
 */

public class ProductSalesEnquiry {
  private Scanner sc;
  private int numProducts; // number of products in the products array
  private final int CAPACITY = 100; // the maximum number of Products in the Product array
  private Product[] products;

  public ProductSalesEnquiry() {
    sc = new Scanner(System.in); // new instance of scanner to read user input
    numProducts = 0; // number of products in the products array
    products = new Product[CAPACITY]; // Array to store Product objects
  }

  public void showMenu() {
    int choice = 0; // menu choice

    System.out.println("Product Sales Enquiry"); // display name of program
    System.out.println();

    while (choice != 6) {
      choice = GetMenuChoice(); // Get menu choice from the user
      switch (choice) {
      case 1:
        addProduct(); // Add a Product
        break;
      case 2:
        displayProduct(); // Display Products
        break;
      case 3:
        changeProduct(); // Change a Product
        break;
      case 4:
        salesCalculator(); // Display the Sales Calculator
        break;
      case 5:
        deleteProduct(); // Delete a Product
        break;
      case 6: // User has chosen to quit
        break;
      default:
        break;
      }
    }

  }

  /** This method adds a Product to the products array */
  private void addProduct() {
    String again = "y"; // Used to control "Enter another Product" logic

    System.out.println(); // Leave a blank line

    while (numProducts < products.length && again.equals("y")) {
      Product product = readProduct(); // Read product details from the user and instantiate new product
      products[numProducts] = product; // Add the product to the array
      numProducts++; // Increment the counter for the number of products in the array

      if (numProducts == products.length - 1) {
        System.out.println();
        System.err.print("Maximum number of Products entered. Press return to continue");
        sc.nextLine();
        System.out.println();
        break;
      } else {
        System.out.println();
        System.out.print("Enter another Product (y,n)? ");
        again = sc.nextLine();
      }
    }
  }

  /*
   * Obtain product details from the the user
   * 
   * @return product A Product DataType
   */
  public Product readProduct() {
    Product product = null;

    // Obtain product details from the user
    System.out.print("Please enter a valid Stock Keeping Unit (sku): ");
    String sku = sc.nextLine(); // Stock Keeping Unit, the unique identifier for the product
    System.out.print("Please enter the product code: ");
    String code = sc.nextLine();
    System.out.print("Please enter the product description: ");
    String description = sc.nextLine(); // Product description
    System.out.print("Please enter the cost price: ");
    Double costPrice = Double.parseDouble(sc.nextLine());
    System.out.print("Please enter the sell price: ");
    Double sellPrice = Double.parseDouble(sc.nextLine());
    System.out.println();
    Product.Size productSize = readSize("Please enter the product size: ");
    System.out.println();
    Product.Size packSize = readSize("Please enter the product pack size: ");
    System.out.println();
    System.out.print("Please enter the maximum discount percentage: ");
    Double maxDiscountPercent = Double.parseDouble(sc.nextLine());
    System.out.print("Please enter the minimum markup percentage: ");
    Double minMarkupPercent = Double.parseDouble(sc.nextLine());

    // Instantiate a new product
    product = new Product(sku, code, description, costPrice, sellPrice, productSize, packSize, maxDiscountPercent,
        minMarkupPercent);
    return product;
  }

  /**
   * Get the product size and product pack size
   * 
   * @param message message to display to the user
   * @return size product size or product pack size
   */
  public Product.Size readSize(String message) {
    System.out.println(message);
    int choice = 0; // Menu choice
    Product.Size size = null;

    while (choice <= 0) {
      System.out.println("1 " + Product.Size.SMALL);
      System.out.println("2 " + Product.Size.MEDIUM);
      System.out.println("3 " + Product.Size.LARGE);
      System.out.println("4 " + Product.Size.EXTRA_LARGE);
      System.out.print("Choice ( 1 - 4): ");
      choice = Integer.parseInt(sc.nextLine());
      if (choice <= 0) {
        System.out.println("Error! Choice must be between 1 and 4 inclusive");
      }
    }
    switch (choice) {
    case 1:
      size = Product.Size.SMALL;
      break;
    case 2:
      size = Product.Size.MEDIUM;
      break;
    case 3:
      size = Product.Size.LARGE;
      break;
    case 4:
      size = Product.Size.EXTRA_LARGE;
      break;
    default:
      size = Product.Size.SMALL;
    }
    return size;
  }

  /** This method displays all products, one per line. */
  public void displayProduct() {

    productSort(); // Sort products into ascending sku order

    System.out.println(); // Leave a blank line
    for (int i = 0; i < numProducts; i++) {
      System.out.println(products[i].toString());
    }
    System.out.println(); // Leave a blank line
  }

  /**
   * This method performs an insertion sort of products in ascending order by sku
   * It is optimised by only sorting up to the number of products in the array
   * rather than the actual array length.
   */

  private void productSort() {
    Product product; // Used to compare and insert the product
    int position; // Position to insert

    for (int index = 1; index < numProducts; index++) {
      product = products[index];
      position = index;
      // shift larger values to the right
      while (position > 0 && products[position - 1].getSku().compareTo(product.getSku()) > 0) {
        products[position] = products[position - 1];
        position--;
      }
      products[position] = product;
    }
  }

  /**
   * This method obtains a valid product for the sales enquiry from the user and
   * then uses calls to the Product DataObject to display stored and calculated
   * values important for Sales people selling the product. All currency values
   * are formatted to two decimal places with a leading "$" sign.
   */

  private void salesCalculator() {
    System.out.println();
    System.out.println("********************");
    System.out.println("* Sales Calculator *");
    System.out.println("********************");
    System.out.println();

    int valid = findProduct(); // obtain required product from the user
    if (valid != -1) {
      // Selling prices based on a discount
      displayDiscSellPrices(products[valid]);

      // Selling prices based on a markup on cost
      displayMarkupSellPrices(products[valid]);

      // Gross profit expressed as a percentage
      displayGrossProfitPercentages(products[valid]);

      // Gross profit expressed as a value
      displayGrossProfitValues(products[valid]);

      // Pause to allow reading of display
      System.out.print("Press <y> to continue... ");
      sc.nextLine();
      System.out.println();
    }
  }

  private void displayGrossProfitValues(Product product) {
    System.out.println("GP value at recommended sell: " + String.format("$%.2f", product.standardGrossProfitValue()));
    System.out.println("GP value maximum discount:    " + String.format("$%.2f", product.discountGrossProfitValue()));
    System.out.println("GP value at minimum markup:   " + String.format("$%.2f", product.markupGrossProfitValue()));
    System.out.println();
  }

  private void displayGrossProfitPercentages(Product product) {
    System.out.println("GP% at recommended sell: " + String.format("%.1f", product.standardGrossProfitPercent()) + "%");
    System.out.println("GP% at maximum discount: " + String.format("%.1f", product.discountGrossProfitPercent()) + "%");
    System.out.println("GP% at minimum markup:   " + String.format("%.1f", product.markupGrossProfitPercent()) + "%");
    System.out.println();
  }

  private void displayMarkupSellPrices(Product product) {
    System.out.println("Product Cost price: " + String.format("$%.2f", product.getCostPrice()));
    System.out.println("Minimum Markup on Cost: " + product.getMinMarkupPercent() + "%");
    System.out.println("Sell price at min markup: " + String.format("$%.2f", product.markupSellPrice()));
    System.out.println();
  }

  private void displayDiscSellPrices(Product product) {
    System.out.println();
    System.out.println("Recommended selling price: " + String.format("$%.2f", product.getSellPrice()));
    System.out.println("Maximum discount percentage: " + product.getMaxDiscountPercent() + "%");
    System.out.println("Calculated discount amount: " + String.format("$%.2f", product.discountAmount()));
    System.out.println("Sell price at max discount: " + String.format("$%.2f", product.discountSellPrice()));
    System.out.println();
  }

  /**
   * Ask user for required Product using the unique SKU (Stocking Keeping Unit)
   * The method uses a recursive binary search to find the product but will use a
   * Collections method when the Collections framework is implemented in 7.4HD
   *
   * @return valid valid row number in the products array with the required
   *         product
   *
   */
  private int findProduct() {
    String sku; // Stock Keeping Unit, the unique identifier for the product
    int valid = -1; // valid row number for product in products array (-1 is not found)
    String again = "y"; // Used to control "Enter another sku" logic

    while (again.equals("y")) {
      System.out.print("Please enter a valid sku for the sales enquiry: ");
      sku = sc.nextLine();

      valid = binarySearch(sku); // Find the product using the sku
      if (valid == -1) {
        System.err.println("The product sku is not on file");
        System.out.println();
        System.out.print("Enter another sku (y,n)? ");
        again = sc.nextLine();
      } else
        return valid;
    }
    return valid;
  }

  /**
   * This method performs a binary search to find a product by it's sku
   *
   * @param sku the unique product identifier (stock keeping unit)
   * @return valid row number of product array for the found product (-1 if not
   *         found)
   *
   */
  private int binarySearch(String sku) {
    boolean found = false;
    int low = 0;
    int high = numProducts - 1;
    int middle;
    int valid = -1; // row number for found product in products array (-1 is not found)
    int a; // Used for sku comparison

    productSort(); // Products array needs to be sorted to perform a binary search

    while (low <= high && !found) {
      middle = (low + high) / 2;

      a = (sku.compareToIgnoreCase(products[middle].getSku()));
      if (a == 0) {
        found = true;
        valid = middle;
      } else {
        if (a < 0) {
          high = middle - 1;
        } else {
          low = middle + 1;
        }
      }
    }
    return valid;
  }

  /** To be implemented in 7.4HD */
  private void deleteProduct() {
    System.out.println();
    System.out.print("To be implemented in 7.4HD");
    System.out.println();
  }

  /** To be implemented in 7.4HD */
  private void changeProduct() {
    System.out.println();
    System.out.print("To be implemented in 7.4HD");
    System.out.println();
  }

  /**
   * Gets a valid menu choice from the user
   * 
   * @return valid the user's menu choice
   */
  private int GetMenuChoice() {
    int choice = 0;
    boolean valid; // Evaluate a valid choice by user

    do {
      System.out.println("1. Add Products");
      System.out.println("2. Display Products sorted by SKU");
      System.out.println("3. Change a Product");
      System.out.println("4. Sales Calculator");
      System.out.println("5. Delete a Product");
      System.out.println("6. Quit");
      System.out.println();
      System.out.print("Enter an option: ");
      choice = Integer.parseInt(sc.nextLine()); // Read choice from user

      // Error check the user's response
      if (choice < 1 || choice > 6) {
        System.err.println("Error! Choice must be between 1 and 6");
        System.out.println();
        valid = false;
      }
      valid = true;
    } while (valid = false);
    return choice;
  }
}
