package ru.kim.course.dto;

public class ErrorResponseDto {

    private Integer httpCode;
    private Object errorDescriptions;
    private String errorMessage;

    public ErrorResponseDto(Integer httpCode, Object errorDescriptions, String errorMessage) {
        this.httpCode = httpCode;
        this.errorDescriptions = errorDescriptions;
        this.errorMessage = errorMessage;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Object getErrorDescriptions() {
        return errorDescriptions;
    }

    public void setErrorDescriptions(Object errorDescriptions) {
        this.errorDescriptions = errorDescriptions;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
