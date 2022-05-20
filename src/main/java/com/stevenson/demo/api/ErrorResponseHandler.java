package com.stevenson.demo.api;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorResponseHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView processException(MethodArgumentNotValidException ioe)
    {
        ModelAndView mav = new ModelAndView("exceptionPage");
        mav.addObject("name", ioe.getClass().getSimpleName());
        mav.addObject("message", ioe.getMessage());

        return mav;
    }
}
