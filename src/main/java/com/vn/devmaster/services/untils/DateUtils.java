package com.vn.devmaster.services.untils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Timestamp stringToTimestamp(String date) throws ParseException {
        SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm");
        Date lFromDate1 = datetimeFormatter1.parse(date);
        Timestamp fromTS1 = new Timestamp(lFromDate1.getTime());
        return fromTS1;
    }
}
