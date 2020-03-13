package com.allianzetechnologies.androidsplashscreenvector;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        try {
            convert("13-10-2019");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("com.allianzetechnologies.androidsplashscreenvector", appContext.getPackageName());
    }

    public void convert(String dateString) throws ParseException {

        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dateString);

        Log.d("dateformat", "yyyy-MM-dd formatted date : " + new SimpleDateFormat("yyyy-MM-dd").format(date));
        System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("yyyy-MM-dd").format(date));

    }
}
