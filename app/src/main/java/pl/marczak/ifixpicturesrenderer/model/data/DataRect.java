package pl.marczak.ifixpicturesrenderer.model.data;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import org.xml.sax.Attributes;

import java.util.List;

import pl.marczak.ifixpicturesrenderer.model.Binding;
import pl.marczak.ifixpicturesrenderer.model.Bindings;
import pl.marczak.ifixpicturesrenderer.model.ForeignObject;
import pl.marczak.ifixpicturesrenderer.model.RangeAnimation;
import pl.marczak.ifixpicturesrenderer.model.Rectangle;

import static pl.marczak.ifixpicturesrenderer.model.data.SynopticView.scale;


/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 07.11.2016.
 */

public class DataRect implements AbstractData {
    public static final String TAG = DataRect.class.getSimpleName();
    public final String name;
    public final int width, height, x, y;
    public int strokeWidth = 1;
    public final String stroke, fill, backgroundFill;
    private final Paint backgroundPaint = new Paint() {{
        setColor(Color.LTGRAY);
    }};
    public RangeAnim rangeAnimation;
    public volatile double fulfillment = 1.0; // between 0 and 1
    public float rotation;
    public String id;
    public String dataConnector = "";
    public boolean bottomUp;
    private Paint paint;

    public DataRect(String name, int width, int height, int x, int y,
                    int strokeWidth, String stroke, String fill, String backgroundFill) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.strokeWidth = strokeWidth;
        this.stroke = stroke;
        this.fill = fill;
        this.backgroundFill = backgroundFill;
    }

    public DataRect(String qName, Attributes attributes) {
        name = qName;
        id = attributes.getValue("id");
        String widthAsString = attributes.getValue("width");
        width = Integer.parseInt(widthAsString);
        String heightAsString = attributes.getValue("height");
        height = Integer.parseInt(heightAsString);
        String xAsString = attributes.getValue("x");
        x = Integer.parseInt(xAsString);
        String yAsString = attributes.getValue("y");
        y = Integer.parseInt(yAsString);
        String[] rotationAsString = attributes.getValue("transform")
                .replace("rotate(", "").replace(")", "").split(",");
        rotation = Float.parseFloat(rotationAsString[0].replace("deg", ""));

        fill = attributes.getValue("fill");

        backgroundFill = attributes.getValue("background-fill");

        stroke = attributes.getValue("stroke");

        String strokeWidthAsString = attributes.getValue("stroke-width");
        strokeWidth = Integer.parseInt(strokeWidthAsString);
    }

    public void setCurrentValue(double newValue) {

        if (rangeAnimation != null) {
            fulfillment = rangeAnimation.adjustSignalValue(newValue);
        }

    }

    @Override public void initSelf() {
        this.paint = new Paint();
        try {
            Log.i(TAG, "initSelf: " + fill);
            paint.setColor(Color.parseColor(fill));
            paint.setStrokeWidth(strokeWidth);
        } catch (IllegalArgumentException exception) {
            Log.e(TAG, "initSelf: ", exception);
        }
    }

    @Override public void drawSelf(Canvas canvas) {


        if (!bottomUp) {

            canvas.drawRect(x * scale, y * scale,
                    (x + width) * scale, (y + height) * scale,
                    backgroundPaint);

            canvas.drawRect(x * scale, y * scale,
                    (x + width) * scale, (float) (y + height * fulfillment) * scale,
                    paint);
        } else {

            canvas.drawRect(x * scale, y * scale,
                    (x + width) * scale, (y + height) * scale,
                    paint);

            canvas.drawRect(x * scale, y * scale,
                    (x + width) * scale, (float) (y + height * (1 - fulfillment)) * scale,
                    backgroundPaint);
        }


        canvas.rotate(rotation);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataRect dataRect = (DataRect) o;

        if (width != dataRect.width) return false;
        if (height != dataRect.height) return false;
        if (x != dataRect.x) return false;
        if (y != dataRect.y) return false;
        if (Float.compare(dataRect.rotation, rotation) != 0) return false;
        if (strokeWidth != dataRect.strokeWidth) return false;
        if (!name.equals(dataRect.name)) return false;
        if (!stroke.equals(dataRect.stroke)) return false;
        if (!fill.equals(dataRect.fill)) return false;
        return backgroundFill.equals(dataRect.backgroundFill);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (rotation != +0.0f ? Float.floatToIntBits(rotation) : 0);
        result = 31 * result + strokeWidth;
        result = 31 * result + stroke.hashCode();
        result = 31 * result + fill.hashCode();
        result = 31 * result + backgroundFill.hashCode();
        return result;
    }

    public static DataRect create(Rectangle rekt, ForeignObject foreignObject) {
        int width = Integer.valueOf(rekt.width);
        int height = Integer.valueOf(rekt.height);
        int x = Integer.valueOf(rekt.x);
        int y = Integer.valueOf(rekt.y);

        String rectangleId = rekt.id; //Rect1 for example

        Bindings bindings = foreignObject.bindings;

        List<RangeAnimation> anims = foreignObject.auxiliaryObjects.animations.rangeAnimation;

        DataRect rect = new DataRect(rectangleId, width, height,
                x, y, rekt.strokeWidth,
                rekt.stroke, rekt.fill, rekt.backgroundFill);


        //example binding:
        // bindKey= Rect1 : bindValue= Linear3
        for (Binding b : bindings.bindingList) {
            if (b.bindKey.equals(rectangleId)) {
                String animationKey = b.bindValue;

                for (RangeAnimation anim : anims) {
                    if (anim.id.equalsIgnoreCase(animationKey)) {
                        //gotcha!
                        RangeAnim animation = new RangeAnim(anim);
                        rect.bottomUp = anim.verticalFillDirection.equalsIgnoreCase("bottomToUp");
                        rect.rangeAnimation = animation;
                        rect.dataConnector = anim.getSignalName();
                        Log.i(TAG, "create: " + rect.dataConnector);
                        break;
                    }
                }
                break;
            }
        }

        return rect;
    }
}
