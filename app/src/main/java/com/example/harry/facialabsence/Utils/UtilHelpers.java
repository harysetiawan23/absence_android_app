package com.example.harry.facialabsence.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilHelpers {


    public static String compareSubject(String time, String timeStop) {

        String message = "";

        String pattern = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            Date dateStart = sdf.parse(time);
            Date dateStop = sdf.parse(timeStop);


            Date alertStart = new Date();
            alertStart.setHours(dateStart.getHours());
            alertStart.setMinutes(dateStart.getMinutes() - 15);


            Date nowTime = new Date();
            Date now =  sdf.parse(nowTime.getHours()+":"+nowTime.getMinutes());

            if (now.after(alertStart) && now.before(dateStart)) {
                Log.d("TIME_UTILS", "TRUE NOW : " + now.toString() + " ALERT START : " + alertStart.toString() + " HOUR START " + dateStart.toString());
                message = "Segera Dimulai";
            } else if (now.after(dateStart) && now.before(dateStop)) {
                Log.d("TIME_UTILS", "ONGOING");
                message = "Sedang Berlangsung";
            } else if (now.after(dateStop)) {
                Log.d("TIME_UTILS", "FALSE NOW : " + now.toString() + " HOUR STOP " + dateStop.toString());
                message = "Kelas Berakhir";
            } else {
                message = "Segerai Dimulai";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
    }


    public static boolean isNowSubject(String timeStart, String timeStop) {


        String pattern = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            Date dateStart = sdf.parse(timeStart);
            Date dateStop = sdf.parse(timeStop);


            Date alertStart = new Date();
            alertStart.setHours(dateStart.getHours());
            alertStart.setMinutes(dateStart.getMinutes() - 15);


            Date nowTime = new Date();
            Date now =  sdf.parse(nowTime.getHours()+":"+nowTime.getMinutes());

            if (now.after(alertStart) && now.before(dateStart)) {
                Log.d("TIME_UTILS", "TRUE NOW : " + now.toString() + " ALERT START : " + alertStart.toString() + " HOUR START " + dateStart.toString());
                return false;
            } else if (now.after(dateStart) && now.before(dateStop)) {
                Log.d("TIME_UTILS", "ONGOING");
                return true;
            } else if (now.after(dateStop)) {
                Log.d("TIME_UTILS", "FALSE NOW : " + now.toString() + " HOUR STOP " + dateStop.toString());
                return false;
            } else {
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
