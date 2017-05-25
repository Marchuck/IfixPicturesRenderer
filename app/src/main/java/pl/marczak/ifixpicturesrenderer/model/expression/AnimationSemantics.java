package pl.marczak.ifixpicturesrenderer.model.expression;

import com.google.gson.annotations.SerializedName;

import static java.lang.String.valueOf;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class AnimationSemantics {

    public @SerializedName("ci") String associatedSignal = "";

    @Override public String toString() {
        return valueOf(associatedSignal);

    }
}
