import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 7.5HD Improved Custom Program
 *
 * This program bulk loads, adds, deletes and saves products and displays
 * Product information for Sales People.The key functionality is the Sales
 * Calculator which assists Sales People choose a competitive selling price
 * within company guidelines
 *
 * @author Paul Watts
 * @version 1.0 (October 2020)
 *
 *          The following improvements have been implemented for 7.5HD compared
 *          to 7.4DN 1. Refactored to use the Collections framework 2. Converted
 *          program from using a products Array to an ArrayList (after
 *          considering LinkedList) 3. Persisted the ArrayList by reading and
 *          writing from a file (using object Serialization) 4. Added method to
 *          bulk load products from a File with error handling 5. Implemented
 *          the deleteProduct() method 6. Added method to write all products in
 *          ArrayList to a file with warnings and error handling 7. Add CATEGORY
 *          enum to Product class 8. Replaced custom written Insertion Sort with
 *          Collections.sort method and a Comparator class 9. Refactored from a
 *          binary search to a linear search (as more efficient for this use
 *          case) 8. Added logic to ensure an entered SKU (stock keeping unit)
 *          is unique 9. Added method to display all products for an entered
 *          category 10 Loaded "products.ser" with at least 1 product for each
 *          Category from Jb Hi-Fi website to distribute with program
 *
 */

public class ProductSalesEnquiry {
  private Scanner sc;
  private final int INITIAL = 100; // the initial capacity of the products ArrayList
  private Product product;
  private ArrayList products; // ArrayList to store Product objects
  private int valid;
  long end; // end timing
  long start; // start timing

  public ProductSalesEnquiry() {
    sc = new Scanner(System.in); // new instance of scanner to read user input
    products = new ArrayList<Product>(INITIAL); // ArrayList to store Product objects
    long end = 0; // end timing
    long start = 0; // start timing
  }

  public void showMenu() {
    int choice = 0; // menu choice

    System.out.println("Product Sales Enquiry"); // display name of program
    System.out.println();

    while (choice != 8) {
      choice = getMenuChoice(); // Get menu choice from the user
      switch (choice) {
      case 1:
        bulkLoadProduct(); // Load products from File
        break;
      case 2:
        skuProduct(); // Display Products
        break;
      case 3:
        categoryProduct(); // Change a Product
        break;
      case 4:
        salesCalculator(); // Display the Sales Calculator
        break;
      case 5:
        addProduct(); // Add a Product
        break;
      case 6:
        deleteProduct(); // Delete a Product
        break;
      case 7:
        bulkSaveProduct(); // Delete a Product
        break;
      case 8: // User has chosen to quit
        break;
      default:
        break;
      }
    }
  }

  /**
   * Gets a valid menu choice from the user
   *
   * @return valid the user's menu choice
   */
  private int getMenuChoice() {
    int choice = 0;
    boolean valid; // Evaluate a valid choice by user

    do {
      System.out.println("1. Bulk load Products from Disk");
      System.out.println("2. Display Products sorted by SKU");
      System.out.println("3. Display Products for a Category");
      System.out.println("4. Sales Calculator");
      System.out.println("5. Add Products");
      System.out.println("6. Delete a Product");
      System.out.println("7. Save Products to Disk");
      System.out.println("8. Quit");
      System.out.println();
      System.out.print("Enter an option: ");
      choice = Integer.parseInt(sc.nextLine()); // Read choice from user

      // Error check the user's response
      if (choice < 1 || choice > 8) {
        System.err.println("Error! Choice must be between 1 and 8");
        System.out.println();
        valid = false;
      }
      valid = true;
    } while (valid = false);
    return choice;
  }

  /**
   * This method loads the products ArrayList from a serialized objects file For
   * simplicity the file must be named "products.ser" and reside in the project
   * directory.
   *
   */
  private void bulkLoadProduct() {
    ObjectInputStream objectinputstream = null;
    Product product = null;
    int count = 0;

    doTimings("start", count, "");
    try {
      FileInputStream streamIn = new FileInputStream("products.ser");
      objectinputstream = new ObjectInputStream(streamIn);

      do {
        product = (Product) objectinputstream.readObject(); // Explicitly cast the Product
        if (product != null) {
          products.add(product); // Add the deserialized product object to the ArrayList
          count++;
        }
      } while (product != null);
    } catch (EOFException e) { // We are expecting to hit End of File

    } catch (FileNotFoundException e) { // Quite possible the file does not exist
      doMessage("*** File not found ***");
      return;
    } catch (Exception e) { // This is an unexpected error
      e.printStackTrace();
    } finally {
      if (objectinputstream != null) { // There was at least 1 record in the file
        try {
          objectinputstream.close(); // Close the file, trapping any unexpected errors
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    if (count > 0) {
      System.out.println();
      doTimings("end", count, "products loaded");
      System.out.println();
    } else {
      System.out.println();
      System.out.println("*** No products found on file ***");
      System.out.println();
    }
  }

  /**
   * This method persists all products in the ArrayList by writing it to a File.
   * For simplicity the file will be named "products.ser" and reside in the
   * project directory. If there is an existing file on disk it will be deleted,
   * after warning the user, as the file is being used as an object store to
   * persist the ArrayList in memory.
   *
   * Note: An error will not be thrown if the file does not exist when we use
   * file.delete()
   *
   */
  private void bulkSaveProduct() {
    String message = null;
    int i = 0;

    // Check if there are any products to save
    if (products.size() == 0) {
      System.out.println();
      System.out.println("*** There are no products to save ***");
      System.out.println();
      return;
    }
    // Warn the user if the file exists as it will be overwritten
    File file = new File("products.ser"); // open file if it exists
    if (file.exists()) {
      System.out.println();
      System.out.println("Warning! Overwrite the existing file are you sure? ");
      System.out.print("Press <y> to delete or <n> to cancel: ");
      String confirm = sc.nextLine();

      if (!confirm.equalsIgnoreCase("y")) {
        System.out.println();
        System.out.println("*** Products save cancelled! ***");
        System.out.println();
        return;
      }
    }

    doTimings("start", i, "");
    try {
      file.delete(); // delete existing file
      FileOutputStream writeData = new FileOutputStream("products.ser");
      ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

      for (i = 0; i < products.size(); i++) {
        product = (Product) products.get(i); // Get the product object from the ArrayList
        writeStream.writeObject(product); // Write the Serialized product to the file
      }
      writeStream.flush(); // Flush the buffer just to be safe
      writeStream.close();
      products.clear(); // Clear the products ArrayList as now persisted to disk

    } catch (IOException e) {
      e.printStackTrace();
    }
    doTimings("end", i, "products saved and cleared from memory");
  }

  /**
   * This method display all products for a user entered category
   *
   */
  private void categoryProduct() {
    if (products.size() == 0) {
      doMessage("*** There are no products to display ***");
      return;
    }
    Product.Category category = readCategory("Please enter a valid Product Category: ");
    Collections.sort(products, new ProductSkuSorter()); // Sort into sku order

    System.out.println(); // Leave a blank line
    for (int i = 0; i < products.size(); i++) {
      product = (Product) products.get(i); // Cast the ArrayList object into Product
      if (product.getCategory().equals(category)) {
        System.out.println(product.toString());
      }
    }
    System.out.println(); // Leave a blank line
  }

  /**
   * This method adds a Product to the products ArrayList
   */
  private void addProduct() {
    String again = "y"; // Used to control "Enter another Product" logic

    System.out.println(); // Leave a blank line

    while (again.equals("y")) {
      Product product = readProduct(); // Read product details from the user and instantiate new product
      if (product != null)
        products.add(product); // Add the product to the ArrayList if successfully instantiated
      System.out.println();
      System.out.print("Enter another Product (y,n)? ");
      again = sc.nextLine();
      System.out.println();
    }
  }

  /*
   * Obtain product details from the the user
   *
   * @return a new Product object
   */
  public Product readProduct() {
    Product product = null;

    // Obtain product details from the user
    System.out.print("Please enter a unique Stock Keeping Unit (sku): ");
    String sku = sc.nextLine(); // Stock Keeping Unit, the unique identifier for the product
    valid = findProduct(sku, false); // check to see if this sku has already been entered (don't ask for Sku)
    if (valid != -1) {
      doMessage("*** Product with Sku: " + sku + " has already been entered ***");
      return product; // return null product
    }
    System.out.println();
    Product.Category category = readCategory("Please enter a valid Product Category: ");
    System.out.println();
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
    product = new Product(sku, category, code, description, costPrice, sellPrice, productSize, packSize,
        maxDiscountPercent, minMarkupPercent);
    return product;
  }

  /**
   * Get the product size and product pack size
   *
   * @param message message to display to the user
   * @return size product size or product pack size
   */
  private Product.Category readCategory(String message) {
    System.out.println(message);
    int choice = 0; // Menu choice
    Product.Category category = null;

    while (choice <= 0) {
      System.out.println("1 " + Product.Category.COMPUTER);
      System.out.println("2 " + Product.Category.TV);
      System.out.println("3 " + Product.Category.GAMING);
      System.out.println("4 " + Product.Category.MOBILE_PHONE);
      System.out.println("5 " + Product.Category.CAMERA);
      System.out.print("Choice ( 1 - 5): ");
      choice = Integer.parseInt(sc.nextLine());
      if (choice <= 0) {
        System.out.println("Error! Choice must be between 1 and 5 inclusive");
      }
    }
    switch (choice) {
    case 1:
      category = Product.Category.COMPUTER;
      break;
    case 2:
      category = Product.Category.TV;
      break;
    case 3:
      category = Product.Category.GAMING;
      break;
    case 4:
      category = Product.Category.MOBILE_PHONE;
      break;
    default:
      category = Product.Category.CAMERA;
    }
    return category;
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

  /**
   * This method displays all products, one per line.
   */
  public void skuProduct() {

    // Check if there are any products to display
    if (products.size() == 0) {
      doMessage("*** There are no products to display ***");
      return;
    }
    Collections.sort(products, new ProductSkuSorter());

    System.out.println(); // Leave a blank line
    for (int i = 0; i < products.size(); i++) {
      product = (Product) products.get(i); // Cast the ArrayList object into Product
      System.out.println(product.toString());
    }
    System.out.println(); // Leave a blank line
  }

  /**
   * Simple method for consistency in formatting an informational message
   * 
   * @param s the message to be displayed
   */

  private void doMessage(String s) {
    System.out.println();
    System.out.println(s);
    System.out.println();
  }

  /**
   * This method obtains a valid product for the sales enquiry from the user and
   * then uses calls to the Product DataObject to display stored and calculated
   * values important for Sales people selling the product. All currency values
   * are formatted to two decimal places with a leading "$" sign.
   */
  private void salesCalculator() {
    if (products.size() == 0) {
      doMessage("*** There are no products to display ***");
      return;
    }

    System.out.println();
    System.out.println("********************");
    System.out.println("* Sales Calculator *");
    System.out.println("********************");
    System.out.println();

    valid = findProduct("", true); // ask for sku as none passed
    if (valid != -1) {
      product = (Product) products.get(valid); // Cast the ArrayList object into Product
      // Selling prices based on a discount
      displayDiscSellPrices(product);

      // Selling prices based on a markup on cost
      displayMarkupSellPrices(product);

      // Gross profit expressed as a percentage
      displayGrossProfitPercentages(product);

      // Gross profit expressed as a value
      displayGrossProfitValues(product);

      // Pause to allow reading of display
      System.out.print("Paused, please press <y> to continue... ");
      sc.nextLine();
      System.out.println();
    }
  }

  private void displayDiscSellPrices(Product product) {
    System.out.println();
    System.out.println("Recommended selling price: " + String.format("$%.2f", product.getSellPrice()));
    System.out.println("Maximum discount percentage: " + product.getMaxDiscountPercent() + "%");
    System.out.println("Calculated discount amount: " + String.format("$%.2f", product.discountAmount()));
    System.out.println("Sell price at max discount: " + String.format("$%.2f", product.discountSellPrice()));
    System.out.println();
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

  /**
   * Ask user for required Product using the unique SKU (Stocking Keeping Unit)
   * The method uses a binary search to find the product.
   *
   * @param sku Passed sku to find (if ask = false)
   * @param ask Ask for the product sku to find if ask = true
   * @return valid index number in the products ArrayList with the required
   *         product
   */

  private int findProduct(String sku, Boolean ask) {
    int valid = -1; // valid index number product in products array (-1 is not found)
    String again = "y"; // Used to control "Enter another sku" logic

    while (again.equals("y")) {
      if (ask) { // if true ask for the sku
        System.out.print("Please enter a valid Product sku: ");
        sku = sc.nextLine();
      }

      valid = LinearSearch(sku); // Find the product using the sku
      if (valid == -1) { // if true the product with the given sku is not on file
        if (!ask) {
          return valid;
        } // if we are not asking for the sku we have our result
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
   * This method performs a linear search to find a product by it's sku
   *
   * @param sku the unique product identifier (stock keeping unit)
   * @return valid row number of product array for the found product (-1 if not
   *         found)
   *
   *         Note: We are doing a linear search rather than a binary search
   *         because we would have to sort the ArrayList to do a binary search
   *         which iterates through the ArrayList anyway.
   *
   */

  private int LinearSearch(String sku) {
    boolean found = false;
    int valid = -1; // row number for found product in products array (-1 is not found)

    if (products.size() == 0)
      return valid; // If there are no products in ArrayList return
    for (int i = 0; i < products.size(); i++) {
      product = (Product) products.get(i); // Cast the ArrayList object into Product
      if (product.getSku().equals(sku)) {
        valid = i;
        return valid; // sku should be unique so we have found the one we want
      }
    }
    return valid;
  }

  /**
   * This method finds a product by user entered sku and then deletes it after a
   * suitable warning.
   */
  private void deleteProduct() {

    if (products.size() == 0) {
      doMessage("*** There are no products to delete ***");
      return;
    }

    System.out.println();
    valid = findProduct("", true); // obtain required product from the user by asking for sku
    System.out.println();
    System.out.println("Warning! Delete Sku: " + ((Product) products.get(valid)).getSku() + " are you sure? ");
    System.out.print("Press <y> to delete or <n> to cancel: ");
    String confirm = sc.nextLine();

    if (confirm.equalsIgnoreCase("y")) {
      System.out.println();
      products.remove(valid);
      doMessage("*** Product deleted ***");
    } else {
      doMessage("*** Product deletion cancelled! ***");
    }
  }

  /**
   * Simple method to display timings for file operations
   *
   * @param command "start" to start, "end" to end
   * @param count   used to display number of records
   * @param message used to display the required message
   */
  private void doTimings(String command, int count, String message) {

    if (command.equals("start")) {
      start = System.currentTimeMillis();
    } else {
      end = System.currentTimeMillis();
      System.out.println();
      System.out.println("*** Time taken: " + (end - start) + " ms for " + count + " " + message + " ***");
      System.out.println();
    }
  }
}