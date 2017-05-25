package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import static pl.marczak.ifixpicturesrenderer.Utils.printable;


/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class DataConnectors {

    @SerializedName("gef:dataConnector")
    public List<DataConnector> dataConnectors = new ArrayList<>();

    @Override public String toString() {
        return "DataConnectors{" +
                "dataConnectors=" + printable(dataConnectors) +
                '}';
    }
}
