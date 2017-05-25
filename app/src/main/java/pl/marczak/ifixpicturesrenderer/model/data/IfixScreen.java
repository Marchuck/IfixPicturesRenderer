package pl.marczak.ifixpicturesrenderer.model.data;

import android.graphics.Canvas;
import android.support.annotation.Nullable;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 07.11.2016.
 */

public class IfixScreen implements AbstractData {

    public String name;

    public int New_Height, New_Width, width, height;

    public String backgroundFill;
    public List<AbstractData> children = new ArrayList<>();
    public List<RangeAnim> animations = new ArrayList<>();
    public List<String> keys;
    public List<String> values;

    public IfixScreen(String qName, @Nullable Attributes attrs) {
        this.name = qName;

        if (attrs == null) return;

        String newWidth = attrs.getValue("New_Width");
        New_Width = Integer.parseInt(newWidth);

        String newHeight = attrs.getValue("New_Height");
        New_Height = Integer.parseInt(newHeight);

        String _width = attrs.getValue("width");
        width = Integer.parseInt(_width);

        String _height = attrs.getValue("height");
        height = Integer.parseInt(_height);

        backgroundFill = attrs.getValue("background-fill");
    }

    public void addRangeAnimation(RangeAnim data) {
        animations.add(data);
    }

    public void addChild(AbstractData newItem) {
        this.children.add(newItem);
    }

    public void addRect(DataRect newItem) {
        this.children.add(newItem);
    }

    public List<AbstractData> getChildren() {
        return children;
    }

    @Override
    public void initSelf() {

    }

    @Override
    public void drawSelf(Canvas c) {

    }
}
