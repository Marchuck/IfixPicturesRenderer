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


    public static String image = "\n" +
            "<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n" +
            "<!-- Wygenerowano przez Kreator eksportowania rysunków iFIX w wersji 5.8.10383.0 na Monday, July 3, 2017 -->\n" +
            "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:gef=\"urn:schemas-gefanuc:gefschemas.xsd\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.2\" width=\"133\" height=\"100\" New_Width=\"956\" New_Height=\"691\" background-fill=\"#ffffff\" gef:runtimeVisible=\"true\" gef:alwaysOnTop=\"true\" gef:titlebar=\"true\" gef:systemMenu=\"true\" gef:resizable=\"false\" gef:gridEnabled=\"false\" gef:gridInterval=\"15\" gef:snapToGrid=\"false\" gef:gradientEnabled=\"false\" gef:gradientAngle=\"0.000000\" gef:fadeColor=\"#ffffff\" gef:fadeType=\"0\" gef:blend=\"50\" gef:cacheEnabled=\"false\" gef:displayLayer=\"-1\" gef:languageDesired=\"1045\" gef:translateOnOpen=\"true\" gef:DisableAutoScale=\"false\" gef:GlobalTimeSync=\"true\" gef:RecalculateViewport=\"true\" gef:EnhancedCoordinates=\"true\">\n" +
            "\t<title>PUMPFACEPLATE.GRF</title>\n" +
            "\t<gef:author>Lukasz</gef:author>\n" +
            "\t<gef:version gef:major=\"1\" gef:minor=\"1\" gef:revision=\"0\"/>\n" +
            "\t<defs>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text1\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text2\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text3\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text4\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_DataLink1\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_DataLink2\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_DataLink3\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_DataLink4\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<symbol id=\"button_WorkingButton\">\n" +
            "\t\t\t<rect width=\"100%\" height=\"100%\" rx=\"5\" fill=\"#3399ff\" stroke=\"black\" stroke-width=\"1\"/>\n" +
            "\t\t\t<text x=\"50%\" y=\"65%\" fill=\"#ffffff\" font-family=\"Arial\" font-size=\"16\" text-anchor=\"middle\">Dziala</text>\n" +
            "\t\t</symbol>\n" +
            "\t\t<symbol id=\"button_CommandButton2\">\n" +
            "\t\t\t<rect width=\"100%\" height=\"100%\" rx=\"5\" fill=\"#f0f0f0\" stroke=\"black\" stroke-width=\"1\"/>\n" +
            "\t\t\t<text x=\"50%\" y=\"65%\" fill=\"#000000\" font-family=\"Arial\" font-size=\"16\" text-anchor=\"middle\">Wylaczony</text>\n" +
            "\t\t</symbol>\n" +
            "\t\t<symbol id=\"button_start_pump_button\">\n" +
            "\t\t\t<rect width=\"100%\" height=\"100%\" rx=\"5\" fill=\"#3399ff\" stroke=\"black\" stroke-width=\"1\"/>\n" +
            "\t\t\t<text x=\"50%\" y=\"65%\" fill=\"#f4f7fc\" font-family=\"Arial\" font-size=\"16\" text-anchor=\"middle\">Start</text>\n" +
            "\t\t</symbol>\n" +
            "\t\t<symbol id=\"button_CommandButton4\">\n" +
            "\t\t\t<rect width=\"100%\" height=\"100%\" rx=\"5\" fill=\"#f0f0f0\" stroke=\"black\" stroke-width=\"1\"/>\n" +
            "\t\t\t<text x=\"50%\" y=\"65%\" fill=\"#000000\" font-family=\"Arial\" font-size=\"16\" text-anchor=\"middle\">Stop</text>\n" +
            "\t\t</symbol>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text6\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t\t<linearGradient id=\"FillStyleGradient_Text7\" x1=\"0%\" x2=\"100%\" spreadMethod=\"pad\">\n" +
            "\t\t\t<stop offset=\"0%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t\t<stop offset=\"100%\" stop-color=\"#ffffff\"/>\n" +
            "\t\t</linearGradient>\n" +
            "\t</defs>\n" +
            "\t<g stroke-linejoin=\"round\" stroke-linecap=\"round\" fill-rule=\"evenodd\">\n" +
            "\t\t<text id=\"Text1\" x=\"80\" y=\"132\" textLength=\"36\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text1)\" font-family=\"Arial\" font-size=\"16\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Stan:\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<text id=\"Text2\" x=\"80\" y=\"160\" textLength=\"34\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text2)\" font-family=\"Arial\" font-size=\"16\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Tryb:\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<text id=\"Text3\" x=\"80\" y=\"190\" textLength=\"45\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text3)\" font-family=\"Arial\" font-size=\"16\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Alarm:\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<text id=\"Text4\" x=\"80\" y=\"224\" textLength=\"46\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text4)\" font-family=\"Arial\" font-size=\"16\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Praca:\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<gef:dataLink id=\"DataLink1\" x=\"190\" y=\"130\" textLength=\"49\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_DataLink1)\" font-family=\"Arial\" font-size=\"16\" gef:charsPerLine=\"6\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">###,##\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</gef:dataLink>\n" +
            "\t\t<gef:dataLink id=\"DataLink2\" x=\"190\" y=\"158\" textLength=\"67\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_DataLink2)\" font-family=\"Arial\" font-size=\"16\" gef:charsPerLine=\"8\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">#####,##\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</gef:dataLink>\n" +
            "\t\t<gef:dataLink id=\"DataLink3\" x=\"190\" y=\"188\" textLength=\"67\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_DataLink3)\" font-family=\"Arial\" font-size=\"16\" gef:charsPerLine=\"8\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">#####,##\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</gef:dataLink>\n" +
            "\t\t<gef:dataLink id=\"DataLink4\" x=\"190\" y=\"222\" textLength=\"67\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#00008e\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_DataLink4)\" font-family=\"Arial\" font-size=\"16\" gef:charsPerLine=\"8\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\">#####,##\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</gef:dataLink>\n" +
            "\t\t<use id=\"WorkingButton\" x=\"81\" y=\"236\" width=\"96\" height=\"32\" xlink:href=\"#button_WorkingButton\" background-fill=\"#3399ff\" gef:verticalScaleDirection=\"bottomToTop\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\">\n" +
            "\t\t\t<gef:enableObject>true</gef:enableObject>\n" +
            "\t\t</use>\n" +
            "\t\t<use id=\"CommandButton2\" x=\"190\" y=\"236\" width=\"96\" height=\"32\" xlink:href=\"#button_CommandButton2\" background-fill=\"#f0f0f0\" gef:verticalScaleDirection=\"bottomToTop\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\">\n" +
            "\t\t\t<gef:enableObject>true</gef:enableObject>\n" +
            "\t\t</use>\n" +
            "\t\t<use id=\"start_pump_button\" x=\"307\" y=\"236\" width=\"96\" height=\"32\" xlink:href=\"#button_start_pump_button\" background-fill=\"#3399ff\" gef:verticalScaleDirection=\"bottomToTop\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\">\n" +
            "\t\t\t<gef:enableObject>true</gef:enableObject>\n" +
            "\t\t</use>\n" +
            "\t\t<use id=\"CommandButton4\" x=\"422\" y=\"236\" width=\"96\" height=\"32\" xlink:href=\"#button_CommandButton4\" background-fill=\"#f0f0f0\" gef:verticalScaleDirection=\"bottomToTop\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\">\n" +
            "\t\t\t<gef:enableObject>true</gef:enableObject>\n" +
            "\t\t</use>\n" +
            "\t\t<text id=\"Text6\" x=\"306\" y=\"106\" textLength=\"56\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#000000\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text6)\" font-family=\"Arial\" font-size=\"14\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Manualny\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<text id=\"Text7\" x=\"491\" y=\"106\" textLength=\"27\" lengthAdjust=\"spacingAndGlyphs\" fill=\"#000000\" stroke=\"none\" stroke-width=\"0\" background-fill=\"url(#FillStyleGradient_Text7)\" font-family=\"Arial\" font-size=\"14\" gef:verticalScaleDirection=\"bottomToTop\" gef:transparent=\"true\">Auto\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</text>\n" +
            "\t\t<image id=\"Bitmap5\" x=\"363\" y=\"131\" width=\"103\" height=\"95\" xlink:href=\"PumpFacePlate/PumpFacePlate_Bitmap5_0.png\" gef:verticalScaleDirection=\"bottomToTop\" gef:enableSelect=\"true\" gef:enableHighlight=\"true\" gef:transparentBitmap=\"true\" gef:transparentColor=\"#000000\">\n" +
            "\t\t\t<tooltipOption>TooltipDescription</tooltipOption>\n" +
            "\t\t</image>\n" +
            "\t\t<gef:variable id=\"WriteVal\" gef:variableType=\"8\" gef:initialValue=\"Fix32.FIX.PUMP_FACE_PLATE_JOB.F_CV\" gef:currentValue=\"Fix32.FIX.PUMP_FACE_PLATE_JOB.F_CV\" gef:enableAsVbaControl=\"true\"/>\n" +
            "\t\t<gef:variable id=\"ToggleVal\" gef:variableType=\"8\" gef:initialValue=\"Fix32.FIX.PUMP_FACE_PLATE_JOB.F_CV\" gef:currentValue=\"Fix32.FIX.PUMP_FACE_PLATE_JOB.F_CV\" gef:enableAsVbaControl=\"true\"/>\n" +
            "\t</g>\n" +
            "\t<foreignObject>\n" +
            "\t\t<gef:dataConnectors>\n" +
            "\t\t\t<gef:dataConnector id=\"Fix32\" gef:connectorType=\"FIX\">\n" +
            "\t\t\t\t<gef:progid>Intellution.OPCEDA</gef:progid>\n" +
            "\t\t\t\t<gef:physicalNodeName>FIX</gef:physicalNodeName>\n" +
            "\t\t\t\t<gef:dataItem id=\"FIX32.FIX.PUMP_FACE_PLATE_ALARM.F_CV\" gef:type=\"float\">FIX.PUMP_FACE_PLATE_ALARM.F_CV</gef:dataItem>\n" +
            "\t\t\t\t<gef:dataItem id=\"FIX32.FIX.PUMP_FACE_PLATE_JOB.F_CV\" gef:type=\"float\">FIX.PUMP_FACE_PLATE_JOB.F_CV</gef:dataItem>\n" +
            "\t\t\t\t<gef:dataItem id=\"FIX32.FIX.PUMP_FACE_PLATE_MODE.F_CV\" gef:type=\"float\">FIX.PUMP_FACE_PLATE_MODE.F_CV</gef:dataItem>\n" +
            "\t\t\t\t<gef:dataItem id=\"FIX32.FIX.PUMP_FACE_PLATE_STATE.F_CV\" gef:type=\"float\">FIX.PUMP_FACE_PLATE_STATE.F_CV</gef:dataItem>\n" +
            "\t\t\t</gef:dataConnector>\n" +
            "\t\t</gef:dataConnectors>\n" +
            "\t\t<gef:symbols/>\n" +
            "\t\t<gef:auxiliaryObjects>\n" +
            "\t\t\t<gef:graphicConnections/>\n" +
            "\t\t\t<gef:animations>\n" +
            "\t\t\t\t<gef:formatAnimation id=\"Format1\" gef:errorMode=\"errorTable\" gef:formatType=\"numeric\" gef:justification=\"left\" gef:integerDigits=\"3\" gef:decimalDigits=\"2\" gef:dataEntryType=\"0\" gef:confirmation=\"false\">\n" +
            "\t\t\t\t\t<gef:animatedProperty>caption</gef:animatedProperty>\n" +
            "\t\t\t\t\t<gef:expression>\n" +
            "\t\t\t\t\t\t<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
            "\t\t\t\t\t\t\t<semantics>\n" +
            "\t\t\t\t\t\t\t\t<apply>\n" +
            "\t\t\t\t\t\t\t\t\t<plus/>\n" +
            "\t\t\t\t\t\t\t\t\t<ci>FIX32.FIX.PUMP_FACE_PLATE_STATE.F_CV</ci>\n" +
            "\t\t\t\t\t\t\t\t</apply>\n" +
            "\t\t\t\t\t\t\t</semantics>\n" +
            "\t\t\t\t\t\t</math>\n" +
            "\t\t\t\t\t</gef:expression>\n" +
            "\t\t\t\t</gef:formatAnimation>\n" +
            "\t\t\t\t<gef:formatAnimation id=\"Format2\" gef:errorMode=\"errorTable\" gef:formatType=\"numeric\" gef:justification=\"left\" gef:integerDigits=\"5\" gef:decimalDigits=\"2\" gef:dataEntryType=\"0\" gef:confirmation=\"false\">\n" +
            "\t\t\t\t\t<gef:animatedProperty>caption</gef:animatedProperty>\n" +
            "\t\t\t\t\t<gef:expression>\n" +
            "\t\t\t\t\t\t<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
            "\t\t\t\t\t\t\t<semantics>\n" +
            "\t\t\t\t\t\t\t\t<apply>\n" +
            "\t\t\t\t\t\t\t\t\t<plus/>\n" +
            "\t\t\t\t\t\t\t\t\t<ci>FIX32.FIX.PUMP_FACE_PLATE_MODE.F_CV</ci>\n" +
            "\t\t\t\t\t\t\t\t</apply>\n" +
            "\t\t\t\t\t\t\t</semantics>\n" +
            "\t\t\t\t\t\t</math>\n" +
            "\t\t\t\t\t</gef:expression>\n" +
            "\t\t\t\t</gef:formatAnimation>\n" +
            "\t\t\t\t<gef:formatAnimation id=\"Format3\" gef:errorMode=\"errorTable\" gef:formatType=\"numeric\" gef:justification=\"left\" gef:integerDigits=\"5\" gef:decimalDigits=\"2\" gef:dataEntryType=\"0\" gef:confirmation=\"false\">\n" +
            "\t\t\t\t\t<gef:animatedProperty>caption</gef:animatedProperty>\n" +
            "\t\t\t\t\t<gef:expression>\n" +
            "\t\t\t\t\t\t<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
            "\t\t\t\t\t\t\t<semantics>\n" +
            "\t\t\t\t\t\t\t\t<apply>\n" +
            "\t\t\t\t\t\t\t\t\t<plus/>\n" +
            "\t\t\t\t\t\t\t\t\t<ci>FIX32.FIX.PUMP_FACE_PLATE_ALARM.F_CV</ci>\n" +
            "\t\t\t\t\t\t\t\t</apply>\n" +
            "\t\t\t\t\t\t\t</semantics>\n" +
            "\t\t\t\t\t\t</math>\n" +
            "\t\t\t\t\t</gef:expression>\n" +
            "\t\t\t\t</gef:formatAnimation>\n" +
            "\t\t\t\t<gef:formatAnimation id=\"Format4\" gef:errorMode=\"errorTable\" gef:formatType=\"numeric\" gef:justification=\"left\" gef:integerDigits=\"5\" gef:decimalDigits=\"2\" gef:dataEntryType=\"0\" gef:confirmation=\"false\">\n" +
            "\t\t\t\t\t<gef:animatedProperty>caption</gef:animatedProperty>\n" +
            "\t\t\t\t\t<gef:expression>\n" +
            "\t\t\t\t\t\t<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
            "\t\t\t\t\t\t\t<semantics>\n" +
            "\t\t\t\t\t\t\t\t<apply>\n" +
            "\t\t\t\t\t\t\t\t\t<plus/>\n" +
            "\t\t\t\t\t\t\t\t\t<ci>FIX32.FIX.PUMP_FACE_PLATE_JOB.F_CV</ci>\n" +
            "\t\t\t\t\t\t\t\t</apply>\n" +
            "\t\t\t\t\t\t\t</semantics>\n" +
            "\t\t\t\t\t\t</math>\n" +
            "\t\t\t\t\t</gef:expression>\n" +
            "\t\t\t\t</gef:formatAnimation>\n" +
            "\t\t\t</gef:animations>\n" +
            "\t\t\t<gef:commands>\n" +
            "\t\t\t\t<gef:writeValueCommand id=\"WorkingButton_Click\">\n" +
            "\t\t\t\t\t<gef:dataValue>1</gef:dataValue>\n" +
            "\t\t\t\t\t<gef:dataSource>WriteVal.InitialValue</gef:dataSource>\n" +
            "\t\t\t\t</gef:writeValueCommand>\n" +
            "\t\t\t\t<gef:writeValueCommand id=\"CommandButton2_Click\">\n" +
            "\t\t\t\t\t<gef:dataValue>0</gef:dataValue>\n" +
            "\t\t\t\t\t<gef:dataSource>WriteVal.InitialValue</gef:dataSource>\n" +
            "\t\t\t\t</gef:writeValueCommand>\n" +
            "\t\t\t\t<gef:toggleDigitalCommand id=\"CommandButton4_Click\">\n" +
            "\t\t\t\t\t<gef:dataSource>Fix32.FIX.PUMP_FACE_PLATE_STATE.F_CV</gef:dataSource>\n" +
            "\t\t\t\t</gef:toggleDigitalCommand>\n" +
            "\t\t\t</gef:commands>\n" +
            "\t\t</gef:auxiliaryObjects>\n" +
            "\t\t<gef:bindings>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>DataLink1</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>Format1</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>DataLink2</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>Format2</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>DataLink3</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>Format3</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>DataLink4</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>Format4</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>WorkingButton</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>WorkingButton_Click</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>CommandButton2</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>CommandButton2_Click</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t\t<gef:binding>\n" +
            "\t\t\t\t<gef:bindKey>CommandButton4</gef:bindKey>\n" +
            "\t\t\t\t<gef:bindValue>CommandButton4_Click</gef:bindValue>\n" +
            "\t\t\t</gef:binding>\n" +
            "\t\t</gef:bindings>\n" +
            "\t</foreignObject>\n" +
            "\t<gef:script id=\"PumpFacePlate.cls\" type=\"text/vbscript\">\n" +
            "\t\t<gef:scriptText>VERSION 1.0 CLASS</gef:scriptText>\n" +
            "\t\t<gef:scriptText>BEGIN</gef:scriptText>\n" +
            "\t\t<gef:scriptText>  MultiUse = -1  'True</gef:scriptText>\n" +
            "\t\t<gef:scriptText>END</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Attribute VB_Name = \"PumpFacePlate\"</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Attribute VB_GlobalNameSpace = False</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Attribute VB_Creatable = False</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Attribute VB_PredeclaredId = True</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Attribute VB_Exposed = True</gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub Bitmap5_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag = True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>      Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> GetFormPushbutton</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strOpenButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strCloseButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblLow As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblHigh As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblLow = 0</gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblHigh = 1</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub CommandButton2_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag = True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>      Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> GetFormPushbutton</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strOpenButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strCloseButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblLow As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblHigh As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblLow = 0</gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblHigh = 1</gef:scriptText>\n" +
            "\t\t<gef:scriptText> </gef:scriptText>\n" +
            "\t\t<gef:scriptText> WriteValue \"0\", WriteVal.InitialValue</gef:scriptText>\n" +
            "\t\t<gef:scriptText> ToggleDigitalPoint ToggleVal.InitialValue</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub start_pump_button_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag &lt;&gt; True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Dim dblLow, dblHigh As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Dim blnFetch, blnContinous As Boolean</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     GetFormSlider</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     dblLow = 0</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     dblHigh = 1</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     If (dblHigh &gt; 32767) Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>         MsgBox \" The high limit cannot be greater than 32,767 for this type of Data Entry, Please choose another.\"</gef:scriptText>\n" +
            "\t\t<gef:scriptText>         Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     blnFetch = False</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     blnContinous = False</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.SetWriteContinous blnContinous</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.Slider1.Min = CInt(dblLow)</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.Slider1.Max = CInt(dblHigh)</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.GetTheVars A:=1, B:=\"Fix32.FIX.PUMP_FACE_PLATE_MODE.F_CV\"</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.lblLow.Caption = dblLow</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.lblHigh.Caption = dblHigh</gef:scriptText>\n" +
            "\t\t<gef:scriptText>     Slider.Show</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub CommandButton4_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag = True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>      Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> GetFormPushbutton</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strOpenButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strCloseButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblLow As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblHigh As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblLow = 0</gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblHigh = 1</gef:scriptText>\n" +
            "\t\t<gef:scriptText> </gef:scriptText>\n" +
            "\t\t<gef:scriptText> ToggleDigitalPoint \"Fix32.FIX.PUMP_FACE_PLATE_STATE.F_CV\"</gef:scriptText>\n" +
            "\t\t<gef:scriptText> </gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub DataLink4_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim blnFetch As Boolean</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag = True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>      Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> GetFormNumeric</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Numeric.GetTheLimits H:=1, L:=0</gef:scriptText>\n" +
            "\t\t<gef:scriptText> blnFetch = False</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Numeric.IsAlpha A:=False</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Numeric.GetTheVars A:=1, B:=\"Fix32.FIX.pump_face_plate_job.F_CV\"</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Numeric.Show</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>Private Sub WorkingButton_Click()</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Poniższe komentarze zostały dodane automatycznie.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Jakiekolwiek zmiany mogą zmniejszyć funkcjonalność</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'Ekspertów autoryzacji skryptów.</gef:scriptText>\n" +
            "\t\t<gef:scriptText>    'WizardName=WprowadzanieDanych</gef:scriptText>\n" +
            "\t\t<gef:scriptText> On Error GoTo ErrorHandler</gef:scriptText>\n" +
            "\t\t<gef:scriptText> If blnDataEntryFrmFlag = True Then</gef:scriptText>\n" +
            "\t\t<gef:scriptText>      Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText> End If</gef:scriptText>\n" +
            "\t\t<gef:scriptText> GetFormPushbutton</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strOpenButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim strCloseButton As String</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblLow As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText> Dim dblHigh As Double</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblLow = 0</gef:scriptText>\n" +
            "\t\t<gef:scriptText> dblHigh = 1</gef:scriptText>\n" +
            "\t\t<gef:scriptText>  </gef:scriptText>\n" +
            "\t\t<gef:scriptText>  WriteValue \"1\", WriteVal.InitialValue</gef:scriptText>\n" +
            "\t\t<gef:scriptText>  ToggleDigitalPoint ToggleVal.InitialValue</gef:scriptText>\n" +
            "\t\t<gef:scriptText>  </gef:scriptText>\n" +
            "\t\t<gef:scriptText> Exit Sub</gef:scriptText>\n" +
            "\t\t<gef:scriptText></gef:scriptText>\n" +
            "\t\t<gef:scriptText>ErrorHandler:</gef:scriptText>\n" +
            "\t\t<gef:scriptText> HandleError</gef:scriptText>\n" +
            "\t\t<gef:scriptText>End Sub</gef:scriptText>\n" +
            "\t</gef:script>\n" +
            "</svg>\n";
}
