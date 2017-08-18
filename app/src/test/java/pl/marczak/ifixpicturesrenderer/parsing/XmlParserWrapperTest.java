package pl.marczak.ifixpicturesrenderer.parsing;

import android.app.Application;

import com.google.gson.annotations.SerializedName;
import com.stanfy.gsonxml.GsonXml;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Project "IfixPicturesRenderer"
 * <p>
 * Created by Lukasz Marczak
 * on 26.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class XmlParserWrapperTest {

    static GsonXml gsonXml;

    @BeforeClass
    public static void beforeTesting() {
        gsonXml = XmlParserWrapper.provideGsonXml(XmlParserWrapper.provideXmlParserCreator());
    }


    public static class Ci {
        @SerializedName("ci") String name;

        @Override public String toString() {
            return "Klazz{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Apply2 {

    }

    public static class Semantics2 {
        @SerializedName("apply") Ci apply2;

        @Override public String toString() {
            return "Semantics2{" +
                    "apply2=" + apply2 +
                    '}';
        }
    }

    XmlParserWrapper wrapper;

    @Before
    public void setUp() {
        wrapper = new XmlParserWrapper();
    }


    @Test public void testParsing() throws Exception {
        String xml = "<semantics>" +
                "<apply>" +
                "<plus/>" +
                "<ci>FIX.32.FIX.GREEN.F_CV</ci>" +
                "</apply>" +
                "</semantics>";
        XmlParseResponse<Semantics2> response = wrapper.parse(gsonXml, xml, Semantics2.class);
        Assert.assertEquals(response.isSuccesful(), true);
    }
}