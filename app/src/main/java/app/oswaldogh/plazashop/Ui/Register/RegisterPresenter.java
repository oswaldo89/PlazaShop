package app.oswaldogh.plazashop.Ui.Register;

import app.oswaldogh.plazashop.Entities.User;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

class RegisterPresenter implements Interface.Presenter {
    private Interface.View view;
    private Interface.Model model;

    RegisterPresenter(Interface.View view) {
        this.view = view;
        this.model = new RegisterModel(this);
    }

    void register(String userName, String email, String passwordOne, String passwordTwo) {
        if (view != null) {
            view.hideKeyboard();
            if (userName.equals("") || email.equals("") || passwordOne.equals("") || passwordTwo.equals("")) {
                view.allFields();
            } else if (!passwordOne.equals(passwordTwo)) {
                view.passwordNotMatch();
            }else{
                User user = new User();
                user.setName(userName);
                user.setEmail(email);
                user.setPassword(passwordOne);
                user.setConfirm_password(passwordOne);
                view.showLoading();
                model.saveUser(user);
            }
        }
    }

    @Override
    public void onSavedUser(String text) {
        if(view != null){
            view.hideLoading();
            view.showSucces(text);
        }
    }

    @Override
    public void onErrorSavedUser(String text) {
        if(view != null){
            view.hideLoading();
            view.showError(text);
        }
    }
}
