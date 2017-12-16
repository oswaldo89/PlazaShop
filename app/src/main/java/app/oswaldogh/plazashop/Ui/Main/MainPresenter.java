package app.oswaldogh.plazashop.Ui.Main;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

class MainPresenter implements Interface.Presenter {
    private Interface.View view;

    MainPresenter(Interface.View view){
        this.view = view;
    }

    void openLoginDialog() {
        if(view != null)
            view.showLoginDialog();
    }

    void closeLoginDialog() {
        if(view != null)
            view.hideLoginDialog();
    }
}
