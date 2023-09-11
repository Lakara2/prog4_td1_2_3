package com.employee.manage.utils;

import com.employee.manage.Model.IndustryPhone;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Convert {
    public static String dateToStringAndFormat(LocalDate date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static IndustryPhone stringToIndustryPhone(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String phoneNumber = matcher.group();
            IndustryPhone industryPhone = new IndustryPhone();
            industryPhone.setNum(phoneNumber);
            return industryPhone;
        } else {
                return null;
        }
    }
}