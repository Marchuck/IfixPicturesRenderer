package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "IfixPicturesRenderer"
 * <p>
 * Created by Lukasz Marczak
 * on 04.07.2017.
 */

public class Text {

    public @SerializedName("@id") String id;
    public @SerializedName("@x") String x;
    public @SerializedName("@y") String y;
    public @SerializedName("@textLength") String textLength;
    public @SerializedName("@lengthAdjust") String lengthAdjust;
    public @SerializedName("@fill") String fill;
    public @SerializedName("@stroke") String stroke;
    public @SerializedName("@stroke-width") String strokeWidth;
    public @SerializedName("@background-fill") String background;
    public @SerializedName("@font-family") String fontFamily;
    public @SerializedName("@font-size") String fontSize;
    public @SerializedName("@gef:verticalScaleDirection") String verticalScaleDirection;
    public @SerializedName("@gef:transparent") String transparent;
}
