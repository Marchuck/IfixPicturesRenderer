package pl.marczak.ifixpicturesrenderer.model.expression;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class AnimationExpression {

    public @SerializedName("math")  AnimationMath math;

    @Override public String toString() {
        return String.valueOf(math);
    }
}
