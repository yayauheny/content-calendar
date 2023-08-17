package by.yayauheny.contentcalendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


public class ContentNotFoundException extends ResponseStatusException {

    public ContentNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Content not found!");
    }
}
