package com.wisezone.synthesis.exception;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 9:02
 * @注释:声明一个自定义异常类
 */
public class AgeException extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public AgeException(String message) {
        super(message);
    }
}
