package org.sb.rm.inventory;

import org.springframework.http.HttpStatus;

import com.tngtech.jgiven.config.AbstractJGivenConfiguration;

public class InventoryJGivenConfiguration extends AbstractJGivenConfiguration {

    @Override
    public void configure() {
        setFormatter( HttpStatus.class, new HttpStatusFormatter() );
    }

}