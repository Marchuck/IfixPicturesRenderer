package pl.marczak.ifixpicturesrenderer.parsing;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */

public class XmlParserWrapper {

    public XmlParserWrapper() {
    }

    public static final String TAG = XmlParserWrapper.class.getSimpleName();

    public static String readStream(InputStream iStream) throws IOException {
        //build a Stream Reader, it can read char by char
        InputStreamReader iStreamReader = new InputStreamReader(iStream);
        //build a buffered Reader, so that i can read whole line at once
        BufferedReader bReader = new BufferedReader(iStreamReader);
        String line = null;
        StringBuilder builder = new StringBuilder();
        while ((line = bReader.readLine()) != null) {  //Read till end
            builder.append(line);
            builder.append("\n"); // append new line to preserve lines
        }
        bReader.close();         //close all opened stuff
        iStreamReader.close();
        //iStream.close(); //EDIT: Let the creator of the stream close it!
        // some readers may auto close the inner stream
        return builder.toString();
    }


    public static String readFullyAsString(InputStream inputStream, String encoding)
            throws IOException {
        return readFully(inputStream).toString(encoding);
    }

    public static byte[] readFullyAsBytes(InputStream inputStream)
            throws IOException {
        return readFully(inputStream).toByteArray();
    }

    private static ByteArrayOutputStream readFully(InputStream inputStream)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos;
    }

    @NonNull
    public <T> XmlParseResponse<T> parse(AssetManager manager, String filePath, Class<T> destinationClass) {

        InputStream is = null;
        XmlParseResponse<T> synopticScreen = null;
        try {
            is = manager.open(filePath);
            String str = readFullyAsString(is, "UTF-8");


            synopticScreen = parse(str, destinationClass);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                }
            }
        }
        return synopticScreen;
    }

    @NonNull public <T> XmlParseResponse<T> parse(String xml, Class<T> destinationClass) {
        Log.d(TAG, "parse: " + xml);
        XmlParserCreator parserCreator =
                new XmlParserCreator() {
                    @Override public XmlPullParser createParser() {
                        try {
                            return XmlPullParserFactory.newInstance().newPullParser();
                        } catch (XmlPullParserException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                };

        GsonXml gsonXml = new GsonXmlBuilder().setXmlParserCreator(parserCreator)
                .setPrimitiveArrays(true)
                .setSameNameLists(true)
                .create();

        try {

            T model = gsonXml.fromXml(xml, destinationClass);
            if (model == null) {
                return new XmlParseResponse<T>("nullable response");
            } else {
                return new XmlParseResponse<T>(model);
            }
        } catch (JsonSyntaxException x) {
            return new XmlParseResponse<T>("error: " + x.getMessage());
        }
    }

}
