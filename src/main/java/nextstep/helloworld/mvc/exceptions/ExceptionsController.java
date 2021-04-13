package nextstep.helloworld.mvc.exceptions;

import nextstep.helloworld.HelloController;
import nextstep.helloworld.mvc.exceptions.exception.CustomException;
import nextstep.helloworld.mvc.exceptions.exception.HelloException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;

@RestController
@RequestMapping("/exceptions")
public class ExceptionsController {

    @GetMapping("/hello")
    public ResponseEntity exceptionHandler() {
        throw new CustomException();
    }

    @GetMapping("/hi")
    public ResponseEntity exceptionHandler2() {
        throw new HelloException();
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> handle() {
        return ResponseEntity.badRequest().body("CustomException");
    }
}