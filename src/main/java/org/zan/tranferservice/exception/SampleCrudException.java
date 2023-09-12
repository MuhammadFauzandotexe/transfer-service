package org.zan.tranferservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Custom exception class representing unexpected or unauthorized errors in the application.
 * This exception is thrown when an unexpected or unauthorized situation occurs in the application
 * and cannot be handled without modifying the code. It includes an HTTP status code to indicate
 * the severity of the error.
 * try {
 *     // ...
 *     // Code that may throw SampleCrudException
 *     // ...
 * } catch (SampleCrudException ex) {
 *     // Handle the exception, log, or respond with an appropriate HTTP status code
 *     // ...
 * }
 *
 * @author Muhammad Fauzan
 */
@Getter
@Setter
public class SampleCrudException extends RuntimeException {
    private final HttpStatus httpStatus;

    /**
     * Constructs a new instance of SampleCrudException with a custom message and HTTP status code.
     *
     * @param message    A description of the exception.
     * @param httpStatus The HTTP status code to associate with the exception.
     */
    public SampleCrudException(String message, HttpStatus httpStatus) {
        super("Sample App Exception: " + message);
        this.httpStatus = httpStatus;
    }

    /**
     * Constructs a new instance of SampleCrudException with a custom message and a default
     * HTTP status code of INTERNAL_SERVER_ERROR.
     *
     * @param message A description of the exception.
     */
    public SampleCrudException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

