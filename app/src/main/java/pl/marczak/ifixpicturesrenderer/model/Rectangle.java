package pl.marczak.ifixpicturesrenderer.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class Rectangle {

    public @SerializedName("@id") String id;
    public @SerializedName("@x") String x;
    public @SerializedName("@y") String y;
    public @SerializedName("@width") String width;
    public @SerializedName("@height") String height;
    public @SerializedName("@fill") String fill;
    public @SerializedName("@background-fill") String backgroundFill;
    public @SerializedName("@transform") String transform;
    public @SerializedName("@stroke") String stroke;
    public @SerializedName("@stroke-width") int strokeWidth;
    //foreign animation - may be null
    @Nullable public RangeAnimation rangeAnimation;

    @Override public String toString() {
        return "Rectangle{" +
                "id='" + id + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", fill='" + fill + '\'' +
                ", backgroundFill='" + backgroundFill + '\'' +
                ", transform='" + transform + '\'' +
                '}';
    }

}
