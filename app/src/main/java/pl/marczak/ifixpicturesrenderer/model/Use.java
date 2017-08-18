package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "IfixPicturesRenderer"
 * <p>
 * Created by Lukasz Marczak
 * on 04.07.2017.
 */

public class Use {

    public @SerializedName("@id") String id;
    public @SerializedName("@x") String x;
    public @SerializedName("@y") String y;
    public @SerializedName("@width") String width;
    public @SerializedName("@height") String height;
    public @SerializedName("@xlink:href") String link;
    public @SerializedName("@background-fill") String background;
    public @SerializedName("@gef:verticalScaleDirection") String verticalScaleDirection;
    public @SerializedName("@gef:enableSelect") String enableSelect;
    public @SerializedName("@gef:enableHighlight") String enableHighlight;
}
