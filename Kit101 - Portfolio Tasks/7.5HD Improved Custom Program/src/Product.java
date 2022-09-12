import java.io.Serializable;

/**
 * Product DataType (7.4DN Custom Program)
 *
 * This DataType enables the creation of relevant details for Products that are
 * likely to be sold in a retail store such as Jb Hi-Fi. It implements the
 * Comparable interface to facilitate sorting Products by the unique Stock
 * Keeping Unit (SKU).
 *
 * @author Paul Watts
 * @version 1.0 (October 2020)
 *
 */

public class Product implements Serializable {
  public enum Size {
    SMALL, MEDIUM, LARGE, EXTRA_LARGE
  }

  public enum Category {
    COMPUTER, TV, GAMING, MOBILE_PHONE, CAMERA
  }

  private String sku; // Stock Keeping Unit, the unique identifier for a product
  private String code; // Product code (identifier)
  private String description; // Product description
  private double costPrice; // Product cost price
  private double sellPrice; // Product selling price
  private Category category; // Product category
  private Size productSize; // Product size
  private Size packSize; // Size of the packaging for the Product
  private Double maxDiscountPercent; // Maximum allowed discount from the Product selling price
  private Double minMarkupPercent; // Minimum allowed markup on cost to sell the product

  public Product(String sku, Category category, String code, String description, Double costPrice, Double sellPrice,
      Size productSize, Size packSize, Double maxDiscountPercent, Double minMarkupPercent) {
    this.sku = sku;
    this.category = category;
    this.code = code;
    this.description = description;
    this.costPrice = costPrice;
    this.sellPrice = sellPrice;
    this.productSize = productSize;
    this.packSize = packSize;
    this.maxDiscountPercent = maxDiscountPercent;
    this.minMarkupPercent = minMarkupPercent;
  }

  /** Start of Getter and Setter methods for Product */

  public String getSku() {
    return sku;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category productCategory) {
    category = productCategory;
  }

  public void setSku(String productSku) {
    sku = productSku;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String productCode) {
    code = productCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String productDescription) {
    description = productDescription;
  }

  public Double getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(Double productCostPrice) {
    costPrice = productCostPrice;
  }

  public Double getSellPrice() {
    return sellPrice;
  }

  public void sellPrice(Double productSellPrice) {
    sellPrice = productSellPrice;
  }

  public Size getProductSize() {
    return productSize;
  }

  public void setProductSize(Size productSize) {
    productSize = productSize;
  }

  public Size getPackSize() {
    return packSize;
  }

  public void setPackSize(Size productPackSize) {
    packSize = productPackSize;
  }

  public Double getMaxDiscountPercent() {
    return maxDiscountPercent;
  }

  public void setMaxDiscountPercent(Double productMaxDiscountPercent) {
    maxDiscountPercent = productMaxDiscountPercent;
  }

  public Double getMinMarkupPercent() {
    return minMarkupPercent;
  }

  public void setMinMarkupPercent(Double productMinMarkupPercent) {
    maxDiscountPercent = productMinMarkupPercent;
  }

  /** End of Getter and Setter methods for Product */

  // ** Methods to return selling prices and gross profits */
  public Double discountSellPrice() {
    return sellPrice - discountAmount();
  }

  public Double discountAmount() {
    return (maxDiscountPercent / 100) * sellPrice;
  }

  public double markupSellPrice() {
    return costPrice + (costPrice * (minMarkupPercent / 100));
  }

  public double standardGrossProfitPercent() {
    return ((sellPrice - costPrice) / sellPrice) * 100;
  }

  public double discountGrossProfitPercent() {
    return ((discountSellPrice() - costPrice) / discountSellPrice()) * 100;
  }

  public double markupGrossProfitPercent() {
    return ((markupSellPrice() - costPrice) / markupSellPrice()) * 100;
  }

  public double standardGrossProfitValue() {
    return sellPrice - costPrice;
  }

  public double discountGrossProfitValue() {
    return discountSellPrice() - costPrice;
  }

  public double markupGrossProfitValue() {
    return markupSellPrice() - costPrice;
  }

  // ** End of methods to return selling prices and gross profits */

  // ** toString method to return a nicely formatted representation of Product
  public String toString() {
    String output = (sku + " " + category + " " + " " + code + " " + description + " $" + costPrice + " $" + sellPrice
        + " " + productSize + " " + packSize + " " + maxDiscountPercent + "% " + minMarkupPercent + "%");
    return output;
  }
}
