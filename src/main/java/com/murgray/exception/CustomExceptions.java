package com.murgray.exception;

public class CustomExceptions {
    public static class ResourceNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String message){
            super(message);
        }
    }

    public static class BadRequestException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public BadRequestException(String message){
            super(message);
        }
    }
}
