package com.smartfox.todo;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Config properties - loads the properties file and apply validation - hibernate-validator need to be present for it to
 * work
 *
 * @author hdargaye
 *
 */
@Validated
@Component
@ConfigurationProperties(prefix = "todo")
public class TodoConfigProperties {

    /** The name. */
    @NotNull
    private String name;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

}
