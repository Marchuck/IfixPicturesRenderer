package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class IfixSvg {

    @SerializedName("svg")
    public IfixPicture picture;

    @Override public String toString() {
        return "IfixSvg{" +
                "picture=" + picture +
                '}';
    }
}
