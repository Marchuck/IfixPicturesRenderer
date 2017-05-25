package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import pl.marczak.ifixpicturesrenderer.model.expression.AnimationExpression;
import pl.marczak.ifixpicturesrenderer.model.expression.AnimationMath;
import pl.marczak.ifixpicturesrenderer.model.expression.AnimationSemantics;


/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class RangeAnimation {

    @SerializedName("@id") public String id;
    @SerializedName("@gef:highInputValue") public String highInputValue;
    @SerializedName("@gef:maxOutputValue") public String maxOutputValue;

    @SerializedName("@gef:lowInputValue") public String lowInputValue;
    @SerializedName("@gef:minOutputValue") public String minOutputValue;
    @SerializedName("@gef:verticalFillDirection") public String verticalFillDirection;
    @SerializedName("@gef:verticalFillPercentage") public String verticalFillPercentage;

    @SerializedName("gef:expression") public AnimationExpression expression;


    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("RangeAnim{");
        sb.append("id='").append(id).append('\'');
        sb.append(", highInputValue='").append(highInputValue).append('\'');
        sb.append(", maxOutputValue='").append(maxOutputValue).append('\'');
        sb.append(", lowInputValue='").append(lowInputValue).append('\'');
        sb.append(", minOutputValue='").append(minOutputValue).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getSignalName() {
        String signal = "";
        if (expression != null) {
            AnimationMath math = expression.math;
            if (math != null) {
                AnimationSemantics semantics = math.semantics;
                signal = semantics.associatedSignal;
            }
        }
        return signal.replace("FIX32.", "");
    }
}
