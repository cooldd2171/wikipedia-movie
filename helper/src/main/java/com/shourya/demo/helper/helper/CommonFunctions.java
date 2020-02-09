package com.shourya.demo.helper.helper;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunctions {

    public static SimpleDateFormat dateFormatter() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf;
    }

    public static Date getDate(String date) throws ParseException {
        try {
            if(StringUtils.isEmpty(date)){
                return null;
            }
            return CommonFunctions.dateFormatter().parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
