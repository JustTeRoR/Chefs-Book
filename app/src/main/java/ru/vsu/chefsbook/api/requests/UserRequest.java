package ru.vsu.chefsbook.api.requests;

public class UserRequest {
    private String code;

    public UserRequest(String code) {
        this.code = code;
    }

    public UserRequest() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
