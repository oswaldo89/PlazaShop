package app.oswaldogh.plazashop.Ui.Main;

import android.content.Context;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

class MainPresenter implements Interface.Presenter {
    private Interface.View view;
    private Interface.Model model;

    MainPresenter(Interface.View view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    void openLoginDialog() {
        if (view != null)
            view.showLoginDialog();
    }

    void closeLoginDialog() {
        if (view != null)
            view.hideLoginDialog();
    }

    void doLogin(String user, String pass) {
        if (view != null)
            this.model.tryLogin(user, pass);
    }

    @Override
    public void loginError(String response) {
        if (view != null)
            this.view.loginFailed(response);
    }

    @Override
    public void loginSucces() {
        if (view != null)
            this.view.loginSucces();
    }

    @Override
    public Context getAppContext() {
        if (this.view != null) {
            return this.view.getActivityContext();
        }
        return null;
    }
}
