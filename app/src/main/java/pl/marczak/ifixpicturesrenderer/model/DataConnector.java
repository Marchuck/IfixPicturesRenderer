package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import pl.marczak.ifixpicturesrenderer.Utils;


/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class DataConnector {

    @SerializedName("@id") public String id;
    @SerializedName("@gef:connectorType") public String connectorType;
    @SerializedName("gef:physicalNodeName") public String physicalNodeName;

    @SerializedName("gef:dataItem") public List<DataItem> dataItems = new ArrayList<>();

    @Override public String toString() {
        return "DataConnector{" +
                "id='" + id + '\'' +
                ", connectorType='" + connectorType + '\'' +
                ", physicalNodeName='" + physicalNodeName + '\'' +
                ", dataItems=" + Utils.printable(dataItems) +
                '}';
    }
}
