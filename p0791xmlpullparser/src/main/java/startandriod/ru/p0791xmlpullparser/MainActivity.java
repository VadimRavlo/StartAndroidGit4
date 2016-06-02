package startandriod.ru.p0791xmlpullparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    String tmp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseXml();
    }

    void parseXml(){
        try {
            XmlPullParser xmlPullParser = prepareXmlPullParser();

            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT){
                switch (xmlPullParser.getEventType()){
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(LOG_TAG, "START_DOCUMENT");
                        break;
                    case XmlPullParser.START_TAG:
                        Log.d(LOG_TAG, "START_TAG: name = " + xmlPullParser.getName() + ", depth = "
                                + xmlPullParser.getDepth() + ", attrCount = " + xmlPullParser.getAttributeCount());
                        tmp = "";
                        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                            tmp += xmlPullParser.getAttributeName(i) + " = " + xmlPullParser.getAttributeValue(i) + ", ";
                        }
                        if (!TextUtils.isEmpty(tmp)){
                            Log.d(LOG_TAG, "Attributes: " + tmp);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d(LOG_TAG, "END_TAG: name = " + xmlPullParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        Log.d(LOG_TAG, "text = " + xmlPullParser.getText());
                        break;
                    default:
                        break;
                }
                xmlPullParser.next();
            }
            Log.d(LOG_TAG, "END_DOCUMENT");
        } catch (XmlPullParserException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    XmlPullParser prepareXmlPullParser() throws XmlPullParserException {
//        return getResources().getXml(R.xml.data);
        XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        xmlPullParserFactory.setNamespaceAware(true);
        XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
        xmlPullParser.setInput(new StringReader("<data><phone><company>Samsung</company></phone></data>"));
        return xmlPullParser;
    }
}
