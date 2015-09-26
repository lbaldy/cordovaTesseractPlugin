package pl.baldy.tesseractPlugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.googlecode.tesseract.android.TessBaseAPI;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by lukasz on 9/26/2015.
 */
public class TesseractPlugin extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("getText")){
            String base64Image = args.getString(0);
            String language = args.getString(1);
            TessBaseAPI baseApi = new TessBaseAPI();

            baseApi.init("/sdcard/tesseract/", language);
            byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            baseApi.setImage(bitmap);
            String recognizedText = baseApi.getUTF8Text();
            baseApi.end();

            callbackContext.success(recognizedText);


        }
        return true;
    }

}
