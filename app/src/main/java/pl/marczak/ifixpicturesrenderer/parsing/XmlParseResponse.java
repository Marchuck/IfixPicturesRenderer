package pl.marczak.ifixpicturesrenderer.parsing;

import android.support.annotation.NonNull;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class XmlParseResponse<T> {

    public String errorMessage = "";
    public T obj;
    private boolean success;

    public XmlParseResponse(@NonNull T obj) {
        this.obj = obj;
        this.success = true;
    }

    public XmlParseResponse(String errorMessage) {
        this.errorMessage = errorMessage;

    }

    public boolean isSuccesful() {
        return success;
    }

    @Override public String toString() {
        return "XmlParseResponse{ " + (success ? String.valueOf(obj) : errorMessage) + " }";
    }
}
