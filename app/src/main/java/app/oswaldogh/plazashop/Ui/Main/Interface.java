package app.oswaldogh.plazashop.Ui.Main;

import android.content.Context;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

public interface Interface {
    interface View {
        void loginFailed(String message);
        void loginSucces();
        void showLoginDialog();
        void hideLoginDialog();
        Context getAppContext();
        Context getActivityContext();
    }

    interface Presenter {
        //void openLoginDialog();
        //void closeLoginDialog();
        void loginError(String response);
        void loginSucces();
        Context getAppContext();
    }

    interface Model{
        void tryLogin(String user, String pass);
    }
}
