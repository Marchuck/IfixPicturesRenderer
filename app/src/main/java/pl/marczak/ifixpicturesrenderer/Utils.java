package pl.marczak.ifixpicturesrenderer;

import java.util.Arrays;
import java.util.Collection;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 18.12.2016.
 */

public class Utils {
    public static <T> boolean nonEmpty(Collection<T> tCollection) {
        return tCollection != null && !tCollection.isEmpty();
    }


    public static <T> String printable(Collection<T> tCollection) {
        return Arrays.toString(tCollection.toArray());
    }

}
