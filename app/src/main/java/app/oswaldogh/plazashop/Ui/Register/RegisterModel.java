package app.oswaldogh.plazashop.Ui.Register;

import com.loopj.android.http.RequestParams;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.User;
import app.oswaldogh.plazashop.Tools.RequestHandler;
import app.oswaldogh.plazashop.Tools.RestListener;
import cz.msebera.android.httpclient.Header;

/**
 * Created by oswaldogh89 on 12/02/18.
 */

public class RegisterModel implements Interface.Model {
    private Interface.Presenter presenter;

    RegisterModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveUser(User user) {
        RequestHandler handler = RequestHandler.getInstance("");
        RequestParams params = new RequestParams();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        params.put("confirm_password", user.getConfirm_password());

        handler.post(BuildConfig.HOST + "/register", params, new RestListener() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String data) {
                presenter.onSavedUser("Usuario agregado correctamente, le hemos enviado un correo electronico para activar su cuenta ( este puede tardar unos minutos en llegar ).");
            }

            @Override
            public void onError(int statusCode, Header[] headers, String response) {
                presenter.onErrorSavedUser("Ocurrio un error inesperado, intente nuevamente.");
            }
        });
    }
}
