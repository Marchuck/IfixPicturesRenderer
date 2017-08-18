package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 22.04.2017.
 */

public class Graph {

    @SerializedName(value = "gef:dataLink") public List<DataLink> dataLinks = new ArrayList<>();

    @SerializedName("rect") public List<Rectangle> rectangles = new ArrayList<>();

    @SerializedName("use") public List<Use> uses = new ArrayList<>();

    @SerializedName("text") public List<Text> texts = new ArrayList<>();

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("dataLinks: \n");

        for (DataLink dataLink : dataLinks) {
            sb.append(dataLink).append("\n");
        }
        sb.append("\n\n");
        for (Rectangle rect : rectangles) {
            sb.append(rect).append("\n");
        }

        sb.append('}');
        return sb.toString();
    }
}
