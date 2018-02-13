package app.oswaldogh.plazashop.Ui.Register;

import app.oswaldogh.plazashop.Entities.User;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

public interface Interface {
    interface View{
        void showLoading();
        void hideLoading();
        void allFields();
        void showSucces(String text);
        void showError(String text);
        void passwordNotMatch();
        void hideKeyboard();
    }

    interface Presenter {
        void onSavedUser(String text);
        void onErrorSavedUser(String text);
    }

    interface Model{
        void saveUser(User user);
    }

}
