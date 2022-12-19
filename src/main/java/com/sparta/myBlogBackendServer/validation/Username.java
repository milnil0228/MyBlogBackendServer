//package com.sparta.myBlogBackendServer.validation;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//@Target({ElementType.FIELD})
//@Retention() // 런타임 생성
//@Constraint(validatedBy = UsernameValidator.class)
//@Documented
//public interface Username {
//    String message() default "Invalid Username";
//
//    Class<?>[] groups() default { };
//
//    Class<? extends Payload>[] payload() default { };
//
//}
