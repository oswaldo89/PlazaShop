package app.oswaldogh.plazashop.Ui.Main;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

public interface Interface {
    interface View {
        void loginFailed(String message);
        void loginSucces();
        void logout();
        void showLoginDialog();
        void hideLoginDialog();
        void setTokenApi(String tokenApi);
    }

    interface Presenter {
        void loginError(String response);
        void loginSucces();
        void onSaveTokenApi(String tokenApi);
    }

    interface Model{
        void tryLogin(String user, String pass);
    }
}
