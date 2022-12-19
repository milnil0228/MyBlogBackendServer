//package com.sparta.myBlogBackendServer.validation;
//
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class UsernameValidator implements ConstraintValidator< , String> {
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        Pattern pattern = Pattern.compile("\"^[a-z0-9]{4,10}$\"");
//        Matcher matcher = pattern.matcher(value);
//        return matcher.matches();
//    }
//}
