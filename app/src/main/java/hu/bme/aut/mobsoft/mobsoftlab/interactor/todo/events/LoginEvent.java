package hu.bme.aut.mobsoft.mobsoftlab.interactor.todo.events;

/**
 * Created by rapgo on 2017. 05. 18..
 */

public class LoginEvent {
    private String userName;
    private String password;
    private boolean success;
    private Throwable throwable;

    public LoginEvent() {
    }

    public LoginEvent(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
