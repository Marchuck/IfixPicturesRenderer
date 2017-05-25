package pl.marczak.ifixpicturesrenderer.connection.opc_da_model;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 22.04.2017.
 */

public class ItemValueResult {
    /**
     * MOST IMPORTANT
     */
    public String m_itemName;
    public Double m_value;


    public OpcDaResult m_resultID;
    public Object m_diagnosticInfo;
    public OpcDaQuality m_quality;
    public boolean m_qualitySpecified;
    public String m_timestamp;
    public boolean m_timestampSpecified;
    public Object m_itemPath;
    public Object m_clientHandle;
    public Integer m_serverHandle;

    public ItemValueResult() {
    }

    public static ItemValueResult mock() {
        ItemValueResult item = new ItemValueResult();
        item.m_value = 50.0;
        item.m_itemName = "MOCK ITEM";
        return item;
    }
}
