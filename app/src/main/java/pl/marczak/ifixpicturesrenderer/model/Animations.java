package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class Animations {

    @SerializedName("gef:rangeAnimation")public List<RangeAnimation> rangeAnimation = new ArrayList<>();

    @Override public String toString() {
        return  Arrays.toString(rangeAnimation.toArray());
    }
}
