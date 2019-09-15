
package com.danielminami.memorygameshopify.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Product {

    @SerializedName("admin_graphql_api_id")
    private String mAdminGraphqlApiId;
    @SerializedName("body_html")
    private String mBodyHtml;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("handle")
    private String mHandle;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private Image mImage;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("options")
    private List<Option> mOptions;
    @SerializedName("product_type")
    private String mProductType;
    @SerializedName("products")
    private List<Product> mProducts;
    @SerializedName("published_at")
    private String mPublishedAt;
    @SerializedName("published_scope")
    private String mPublishedScope;
    @SerializedName("tags")
    private String mTags;
    @SerializedName("template_suffix")
    private Object mTemplateSuffix;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("variants")
    private List<Variant> mVariants;
    @SerializedName("vendor")
    private String mVendor;

    public String getAdminGraphqlApiId() {
        return mAdminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        mAdminGraphqlApiId = adminGraphqlApiId;
    }

    public String getBodyHtml() {
        return mBodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        mBodyHtml = bodyHtml;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getHandle() {
        return mHandle;
    }

    public void setHandle(String handle) {
        mHandle = handle;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public List<Option> getOptions() {
        return mOptions;
    }

    public void setOptions(List<Option> options) {
        mOptions = options;
    }

    public String getProductType() {
        return mProductType;
    }

    public void setProductType(String productType) {
        mProductType = productType;
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public String getPublishedScope() {
        return mPublishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        mPublishedScope = publishedScope;
    }

    public String getTags() {
        return mTags;
    }

    public void setTags(String tags) {
        mTags = tags;
    }

    public Object getTemplateSuffix() {
        return mTemplateSuffix;
    }

    public void setTemplateSuffix(Object templateSuffix) {
        mTemplateSuffix = templateSuffix;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public List<Variant> getVariants() {
        return mVariants;
    }

    public void setVariants(List<Variant> variants) {
        mVariants = variants;
    }

    public String getVendor() {
        return mVendor;
    }

    public void setVendor(String vendor) {
        mVendor = vendor;
    }

}
