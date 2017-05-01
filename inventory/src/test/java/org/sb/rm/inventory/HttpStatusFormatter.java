package org.sb.rm.inventory;

import java.lang.annotation.Annotation;

import org.springframework.http.HttpStatus;

import com.tngtech.jgiven.format.Formatter;

public class HttpStatusFormatter implements Formatter<HttpStatus> {

    @Override
    public String format( HttpStatus httpStatus, Annotation... annotations ) {
        return httpStatus.getReasonPhrase() + " (" + httpStatus.value() + ")";
    }
}