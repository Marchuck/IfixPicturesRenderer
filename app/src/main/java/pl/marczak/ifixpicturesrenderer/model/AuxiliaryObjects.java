package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class AuxiliaryObjects {

    @SerializedName("gef:animations") public Animations animations;

    @Override public String toString() {
        return String.valueOf(animations);
    }
}
