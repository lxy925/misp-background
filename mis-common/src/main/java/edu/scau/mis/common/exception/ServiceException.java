package edu.scau.mis.common.exception;

import edu.scau.mis.common.web.domain.HttpCode;

/**
 * 业务异常类 (Service Exception)
 * 用于表示在业务逻辑处理过程中发生的、可预期的、非系统性的错误。
 */
public class ServiceException extends RuntimeException{
    private int code;
    private String message;
    public ServiceException(String message) {
        this.message = message;
    }
    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public ServiceException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ServiceException(HttpCode httpCode) {
        this.code = httpCode.getCode();
        this.message = httpCode.getMessage();
    }

    public int getCode() {
        return code;
    }

     @Override
    public String getMessage() {
        return message;
    }
}
