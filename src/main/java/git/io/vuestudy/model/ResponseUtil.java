package git.io.vuestudy.model;

import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static <T> ApiModel success() {
        return success("SUCCESS!", null);
    }
    public static <T> ApiModel successToMsg(String msg) {
        return success(msg, null);
    }
    public static <T> ApiModel success(T body) {
        return success( "SUCCESS!", body);
    }
    public static <T> ApiModel<T> success(String msg, T body) {
        return (ApiModel<T>) ApiModel.builder()
            .body(body)
            .isSuccess(true)
            .message(msg)
            .statusCode(HttpStatus.OK.value())
            .build();
    }
    public static <T> ApiModel failureToMsg(String msg) {
        return (ApiModel<T>) ApiModel.builder()
            .isSuccess(false)
            .message(msg)
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .build();
    }
    public static <T> ApiModel<T> failureToData(String msg, HttpStatus httpStatus, Object dto) {
        return (ApiModel<T>) ApiModel.builder()
            .isSuccess(false)
            .message(msg)
            .statusCode(httpStatus.value())
            .body(dto)
            .build();
    }
    public static <T> ApiModel<T> failure(HttpStatus httpStatus) {
        return failure(httpStatus.name(), httpStatus);
    }
    public static <T> ApiModel<T> failure(String message, HttpStatus httpStatus) {
        return (ApiModel<T>) ApiModel.builder()
            .statusCode(httpStatus.value())
            .message(message)
            .isSuccess(false)
            .build();
    }

    public static <T> ApiModel<T> failure(int errorId, HttpStatus httpStatus, String errorMessage) {
        return (ApiModel<T>) ApiModel.builder()
                .errorId(errorId)
                .statusCode(httpStatus.value())
                .message(errorMessage)
                .isSuccess(false)
                .build();
    }
}