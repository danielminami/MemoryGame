
package com.danielminami.memorygameshopify.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Option {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("position")
    private Long mPosition;
    @SerializedName("product_id")
    private Long mProductId;
    @SerializedName("values")
    private List<String> mValues;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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

    public List<String> getValues() {
        return mValues;
    }

    public void setValues(List<String> values) {
        mValues = values;
    }

}
