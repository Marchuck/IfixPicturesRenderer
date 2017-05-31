package pl.marczak.ifixpicturesrenderer.model.data;

import android.graphics.Canvas;
import android.renderscript.Double2;

import org.xml.sax.Attributes;

import pl.marczak.ifixpicturesrenderer.model.RangeAnimation;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 25.04.2017.
 */

public class RangeAnim implements AbstractData {

    public String id;
    Attributes attributes;
    public String name;
    public double highInputValue;
    public double maxOutputValue;
    public double lowInputValue;
    public double minOutputValue;
    public double verticalFillPercentage;
    public String verticalFillDirection; //bottomToTop or ? todo: check this

    public RangeAnim() {

    }

    public RangeAnim(RangeAnimation anim) {
        id = anim.id;
        name = anim.id;
        highInputValue = Double.valueOf(anim.highInputValue);
        maxOutputValue = Double.valueOf(anim.maxOutputValue);

        lowInputValue = Double.valueOf(anim.lowInputValue);
        minOutputValue = Double.valueOf(anim.minOutputValue);
        verticalFillPercentage = Double.valueOf(anim.verticalFillPercentage);
        verticalFillDirection = (anim.verticalFillDirection);
    }


    @Override public void initSelf() {

    }

    @Override public void drawSelf(Canvas c) {

    }

    @Override public String toString() {
        return "RangeAnim{" +
                "attributes=" + attributes +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", highInputValue=" + highInputValue +
                ", maxOutputValue=" + maxOutputValue +
                ", lowInputValue=" + lowInputValue +
                ", minOutputValue=" + minOutputValue +
                ", verticalFillPercentage=" + verticalFillPercentage +
                ", verticalFillDirection='" + verticalFillDirection + '\'' +
                '}';
    }

    public double adjustSignalValue(double newValue) {
        return newValue / highInputValue;
    }
}
