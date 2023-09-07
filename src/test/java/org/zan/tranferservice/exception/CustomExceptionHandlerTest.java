package org.zan.tranferservice.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zan.tranferservice.dto.CommonResponseDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomExceptionHandlerTest {

    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleGenericException() {
        // Arrange
        Exception exception = new Exception("Internal Server Error");

        // Act
        ResponseEntity<CommonResponseDTO<?>> responseEntity = customExceptionHandler.handleGenericException(exception);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        CommonResponseDTO<?> responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseBody.getStatusCode());
        assertEquals("there is an server error", responseBody.getMessage());
        assertEquals("Internal Server Error", responseBody.getData());
    }

    @Test
    void testHandleSampleAppException() {
        // Arrange
        SampleCrudException exception = new SampleCrudException("Not Found", HttpStatus.NOT_FOUND);

        // Act
        ResponseEntity<CommonResponseDTO<?>> responseEntity = customExceptionHandler.handleSampleAppException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        CommonResponseDTO<?> responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.NOT_FOUND.value(), responseBody.getStatusCode());
        assertEquals("Not Found", responseBody.getMessage());
        assertEquals(exception.getMessage(), responseBody.getData());
    }
}
