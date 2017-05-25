package pl.marczak.ifixpicturesrenderer.model;

import android.graphics.Canvas;

import com.google.gson.annotations.SerializedName;

import pl.marczak.ifixpicturesrenderer.model.data.AbstractData;
import pl.marczak.ifixpicturesrenderer.model.data.DataRect;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class DataLink {

    public @SerializedName("@textLength") String textLength;
    public @SerializedName("@gef:verticalScaleDirection") String verticalScaleDirection;
    public @SerializedName("@id") String id;
    public @SerializedName("@x") String x;
    public @SerializedName("@y") String y;
    public @SerializedName("@width") String width;
    public @SerializedName("@height") String height;
    public @SerializedName("@fill") String fill;
    public @SerializedName("@background-fill") String backgroundFill;
    public @SerializedName("@transform") String transform;

    @Override public String toString() {
        return "DataLink{" +
                " id='" + id + '\'' +
                ", textLength='" + textLength + '\'' +
                ", verticalScaleDirection='" + verticalScaleDirection + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", fill='" + fill + '\'' +
                ", backgroundFill='" + backgroundFill + '\'' +
                ", transform='" + transform + '\'' +
                '}';
    }

    public AbstractData create() {


        return new AbstractData() {
            @Override public void initSelf() {

            }

            @Override public void drawSelf(Canvas c) {

            }
        };
    }
}
