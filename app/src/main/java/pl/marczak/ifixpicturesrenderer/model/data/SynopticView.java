package pl.marczak.ifixpicturesrenderer.model.data;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult;


/**
 * Project "SynopticScreens"
 * <p/>
 * Created by Lukasz Marczak
 * on 23.10.16.
 */
public class SynopticView extends View {

    public static final String TAG = SynopticView.class.getSimpleName();

    public static volatile float scale = 2.5f;

    IfixScreen svg;

    public SynopticView(Context context) {
        super(context);
    }

    public SynopticView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SynopticView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SynopticView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init(IfixScreen svg) {
        this.svg = svg;
        svg.initSelf();
        for (AbstractData data : svg.getChildren()) {
            data.initSelf();
        }
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (svg != null) {
            for (AbstractData data : svg.getChildren()) {
                Log.d(TAG, "onDraw: ");
                data.drawSelf(canvas);
            }
        }
    }

    public void invalidateData(List<ItemValueResult> results) {

        for (ItemValueResult r : results) {

            int size = svg.getChildren().size();
            for (int i = 0; i < size; i++) {
                AbstractData data = svg.getChildren().get(i);
                if (data instanceof DataRect) {

                    if (((DataRect) data).dataConnector.equalsIgnoreCase(r.m_itemName)) {
                        ((DataRect) data).setCurrentValue(r.m_value);
                        Log.i(TAG, "invalidateData: " + r.m_itemName + ", " + r.m_value);
                    }
                }
            }
        }
        postInvalidate();
    }
}
