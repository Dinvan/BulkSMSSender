
package com.info.bulksmssender.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Unit {

    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("details_image")
    @Expose
    private String detailsImage;
    @SerializedName("sort_price")
    @Expose
    private String sortPrice;
    @SerializedName("price")
    @Expose
    private String price;


    @SerializedName("price_prefix")
    @Expose
    private String pricePrefix;
    @SerializedName("product_weight")
    @Expose
    private Long productWeight;
    @SerializedName("product_weight_unit")
    @Expose
    private String productWeightUnit;
    @SerializedName("product_pack_type")
    @Expose
    private String productPackType;


    @SerializedName("ondoor_product")
    @Expose
    private Long ondoorProduct;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailsImage() {
        return detailsImage;
    }

    public void setDetailsImage(String detailsImage) {
        this.detailsImage = detailsImage;
    }

    public String getSortPrice() {
        return sortPrice;
    }

    public void setSortPrice(String sortPrice) {
        this.sortPrice = sortPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

    public Long getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Long productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductWeightUnit() {
        return productWeightUnit;
    }

    public void setProductWeightUnit(String productWeightUnit) {
        this.productWeightUnit = productWeightUnit;
    }

    public String getProductPackType() {
        return productPackType;
    }

    public void setProductPackType(String productPackType) {
        this.productPackType = productPackType;
    }


    public Long getOndoorProduct() {
        return ondoorProduct;
    }

    public void setOndoorProduct(Long ondoorProduct) {
        this.ondoorProduct = ondoorProduct;
    }


}
