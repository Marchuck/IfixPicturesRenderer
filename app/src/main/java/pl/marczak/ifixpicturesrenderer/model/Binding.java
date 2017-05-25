package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class Binding {
    @SerializedName("gef:bindKey") public String bindKey;
    @SerializedName("gef:bindValue") public String bindValue;

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Binding{");
        sb.append("bindKey='").append(bindKey).append('\'');
        sb.append(", bindValue='").append(bindValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
