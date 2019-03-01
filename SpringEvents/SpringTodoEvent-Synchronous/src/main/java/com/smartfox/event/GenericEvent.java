package com.smartfox.event;

import org.springframework.context.ApplicationEvent;

/**
 * Any generic event - does not need to extend application event
 * @author hdargaye
 *https://zoltanaltfatter.com/2016/05/11/application-events-with-spring/
 * @param <T>
 */
public class GenericEvent<T> extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    protected boolean success;
    private T what;

    public GenericEvent(T what, boolean success) {
        super(what);
        this.what = what;
        this.success = success;
    }

    public T getWhat() {
        return this.what;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setWhat(T what) {
        this.what = what;
    }

}
