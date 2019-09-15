
package com.danielminami.memorygameshopify.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Image {

    @SerializedName("admin_graphql_api_id")
    private String mAdminGraphqlApiId;
    @SerializedName("alt")
    private Object mAlt;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("height")
    private Long mHeight;
    @SerializedName("id")
    private Long mId;
    @SerializedName("position")
    private Long mPosition;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("src")
    private String mSrc;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("variant_ids")
    private List<Object> mVariantIds;
    @SerializedName("width")
    private Long mWidth;

    public String getAdminGraphqlApiId() {
        return mAdminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        mAdminGraphqlApiId = adminGraphqlApiId;
    }

    public Object getAlt() {
        return mAlt;
    }

    public void setAlt(Object alt) {
        mAlt = alt;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getPosition() {
        return mPosition;
    }

    public void setPosition(Long position) {
        mPosition = position;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public String getSrc() {
        return mSrc;
    }

    public void setSrc(String src) {
        mSrc = src;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public List<Object> getVariantIds() {
        return mVariantIds;
    }

    public void setVariantIds(List<Object> variantIds) {
        mVariantIds = variantIds;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

}
