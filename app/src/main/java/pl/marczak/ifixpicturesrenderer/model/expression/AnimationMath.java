package pl.marczak.ifixpicturesrenderer.model.expression;

import com.google.gson.annotations.SerializedName;

import static java.lang.String.valueOf;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class AnimationMath {
    public @SerializedName("semantics") AnimationSemantics semantics;

    @Override public String toString() {
        return valueOf(semantics);
    }
}
