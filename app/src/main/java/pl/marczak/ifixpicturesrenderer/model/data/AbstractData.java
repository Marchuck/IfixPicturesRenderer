package pl.marczak.ifixpicturesrenderer.model.data;

import android.graphics.Canvas;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 07.11.2016.
 */

public interface AbstractData {

    void initSelf();

    void drawSelf(Canvas c);
}
