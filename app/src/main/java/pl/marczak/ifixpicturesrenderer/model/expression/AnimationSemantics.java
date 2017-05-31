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

    public static class Apply {

        public @SerializedName("ci") String associatedSignal;

        @Override public String toString() {
            return String.valueOf(associatedSignal);
        }
    }

    public @SerializedName("apply") Apply apply;

    @Override public String toString() {
        return "apply=" + apply +
                '}';
    }
}
