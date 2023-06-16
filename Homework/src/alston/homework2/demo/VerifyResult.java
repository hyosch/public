package alston.homework2.demo;

public class VerifyResult {

    private Boolean isVerifySuccess;
    private String id;
    private String message;

    public VerifyResult() {

    }

    public VerifyResult(Boolean isVerifySuccess, String id, String message) {
        this.isVerifySuccess = isVerifySuccess;
        this.id = id;
        this.message = message;
    }

    public Boolean getVerifySuccess() {
        return isVerifySuccess;
    }

    public void setVerifySuccess(Boolean verifySuccess) {
        isVerifySuccess = verifySuccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "VerifyResult{" +
                "isVerifySuccess=" + isVerifySuccess +
                ", id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}