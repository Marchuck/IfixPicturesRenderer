package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import pl.marczak.ifixpicturesrenderer.model.data.DataRect;
import pl.marczak.ifixpicturesrenderer.model.data.IfixScreen;


/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class IfixPicture {
    @SerializedName("@width") public String width;

    @SerializedName("@height") public String height;

    @SerializedName("@New_Width") public String newWidth;

    @SerializedName("@New_Height") public String newHeight;

    @SerializedName("@background-fill") public String backgroundFill;

    @SerializedName("title") public String title;

    @SerializedName("gef:author") public String author;

    @SerializedName(value = "g") public Graph graph;

    @SerializedName(value = "foreignObject") public ForeignObject foreignObject;

    @Override public String toString() {
        return "IfixPicture{" +
                "width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", newWidth='" + newWidth + '\'' +
                ", newHeight='" + newHeight + '\'' +
                ", author='" + author + '\'' +
                ", graph=" + graph +
                ",\n foreignObject=" + foreignObject +
                '}';
    }

    public IfixScreen createScreen() {
        IfixScreen screen = new IfixScreen("iFix", null);
        screen.width = Integer.valueOf(width);
        screen.height = Integer.valueOf(width);
        screen.backgroundFill = backgroundFill;


        if (graph != null) {
            for (Rectangle rekt :graph.rectangles){
                DataRect dataRect =  DataRect.create(rekt,foreignObject);
                screen.addRect(dataRect);
            }
            //// TODO: 25.05.2017 add dataLinks
//            for (DataLink dataLink : graph.dataLinks) {
//                screen.addChild(dataLink.create());
//            }
        }

        return screen;
    }
}
