package az.spring.rest.demo.springrestdemo.enums;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUNT(1001,"Can not find employee with given id"),
    VALIDATION_ERROR(1002,"is not valid");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode(){
        return code;
    }
}
