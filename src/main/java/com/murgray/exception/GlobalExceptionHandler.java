package com.murgray.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
 
import java.util.Date;
 
@ControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(CustomExceptions.ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(CustomExceptions.ResourceNotFoundException ex, WebRequest request, Model model) {
        return handleException(HttpStatus.NOT_FOUND, ex, request, model);
    }
 
    @ExceptionHandler(CustomExceptions.BadRequestException.class)
    public ModelAndView handleBadRequestException(CustomExceptions.BadRequestException ex, WebRequest request, Model model) {
        return handleException(HttpStatus.BAD_REQUEST, ex, request, model);
    }
 
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception ex, WebRequest request, Model model) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, ex, request, model);
    }
 
    private ModelAndView handleException(HttpStatus status, Exception ex, WebRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("timestamp", new Date());
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("details", request.getDescription(false));
        modelAndView.setStatus(status);
        return modelAndView;
    }
}


