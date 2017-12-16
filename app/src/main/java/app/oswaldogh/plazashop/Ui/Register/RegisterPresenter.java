package app.oswaldogh.plazashop.Ui.Register;

/**
 * Created by oswaldogh89 on 16/12/17.
 */

class RegisterPresenter {
    private Interface.View view;

    RegisterPresenter(Interface.View view) {
        this.view = view;
    }

    void register(String email, String passwordOne, String passwordTwo) {
        if (view != null) {
            if (email.equals("") || passwordOne.equals("") || passwordTwo.equals("")  ) {
                view.allFields();
            }else if(!passwordOne.equals(passwordTwo)){
                view.passwordNotMatch();
            }
        }
    }
}
