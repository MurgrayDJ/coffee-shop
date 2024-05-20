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
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("timestamp", new Date());
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("details", request.getDescription(false));
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
 
    @ExceptionHandler(CustomExceptions.BadRequestException.class)
    public ModelAndView handleBadRequestException(CustomExceptions.BadRequestException ex, WebRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("timestamp", new Date());
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("details", request.getDescription(false));
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
 
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception ex, WebRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("timestamp", new Date());
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("details", request.getDescription(false));
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}
