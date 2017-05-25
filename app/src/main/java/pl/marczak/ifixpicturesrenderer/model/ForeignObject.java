package pl.marczak.ifixpicturesrenderer.model;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class ForeignObject {
    public static final String TAG = ForeignObject.class.getSimpleName();

   public  @SerializedName("gef:bindings") Bindings bindings;
   public  @SerializedName("gef:auxiliaryObjects") AuxiliaryObjects auxiliaryObjects;
   public  @SerializedName("gef:dataConnectors") DataConnectors dataConnectors;

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("\nForeignObject{");
        sb.append("bindings=").append(bindings);
        sb.append("\nauxiliaryObjects=").append(auxiliaryObjects);
        sb.append("\ndataConnectors=").append(dataConnectors);
        sb.append("}\n");
        return sb.toString();
    }

    /**
     * each rectangle needs to be associated with
     *
     * @param rect
     * @return null if there is no bindings for this rectangle
     */
    @Nullable public Rectangle bindRectangle(Rectangle rect) {
        if (auxiliaryObjects == null || auxiliaryObjects.animations == null) {
            return null;
        }
        String id = rect.id;
        String animationBinding = null;
        for (Binding binding : bindings.bindingList) {
            if (binding.bindKey.equalsIgnoreCase(id)) {
                animationBinding = binding.bindValue;
            }
        }
        if (animationBinding == null) {
            Log.e(TAG, "bindRectangle: no binding for rectangle " + id);
            return null;
        } else {
            for (RangeAnimation animation : auxiliaryObjects.animations.rangeAnimation) {
                if (animation.id.equalsIgnoreCase(animationBinding)) {
                    rect.rangeAnimation = animation;
                    return rect;
                }
            }
        }
        Log.e(TAG, "bindRectangle: no animation for rectangle " + id);
        return null;
    }

}
