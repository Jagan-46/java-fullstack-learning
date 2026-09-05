package com.example.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.slf4j.*;
@ControllerAdvice
public class GlobalExceptionHandler {
private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
@ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException e){
    logger.error("Student not found "+ e.getMessage());
    ErrorResponse error = new ErrorResponse();
    error.setStatus(404);
    error.setMessage(e.getMessage());
    error.setTimestamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(TeacherNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleTeacherNotFound(TeacherNotFoundException e){
    logger.error("Teacher not found "+e.getMessage());
    ErrorResponse error = new ErrorResponse();
    error.setStatus(404);
    error.setMessage(e.getMessage());
    error.setTimestamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e){
    logger.error("Error: "+e.getMessage());
    ErrorResponse error = new ErrorResponse();
    error.setStatus(500);
    error.setMessage(e.getMessage());
    error.setTimestamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
}
