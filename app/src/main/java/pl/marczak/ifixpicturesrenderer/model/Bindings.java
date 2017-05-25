package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class Bindings {
    @SerializedName("gef:binding") public List<Binding> bindingList = new ArrayList<>();

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Bindings{");
        sb.append("bindingList=");
        for (Binding b : bindingList)
            sb.append(b).append("\n");
        sb.append('}');
        return sb.toString();
    }
}
