package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class DataItem {


    @SerializedName("@gef:type") public String type;
    @SerializedName("@id") public String id;

    /**
     * @param parentId
     * @return upper - cased signal name
     */
    public String getSignalName(String parentId) {

        String lowerCased = id.toLowerCase();
        return lowerCased.replaceAll(parentId.toLowerCase(), "").substring(1).toUpperCase();
    }

    @Override public String toString() {
        return "DataItem{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
