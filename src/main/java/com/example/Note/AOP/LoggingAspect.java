package com.example.Note.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @After("execution(* com.example.Note.repository.UserRepository.*(..))")
    public void logAfter(){
        System.out.println("succesfully added");
    }
}
