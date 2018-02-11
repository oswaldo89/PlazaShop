package app.oswaldogh.plazashop.Ui.Main;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.Credentials;
import app.oswaldogh.plazashop.Tools.PreferencesHandler;
import app.oswaldogh.plazashop.Tools.RequestHandler;
import app.oswaldogh.plazashop.Tools.RestListener;
import cz.msebera.android.httpclient.Header;

/**
 * Created by oswaldogh89 on 05/01/18.
 */

public class MainModel implements Interface.Model {
    private Interface.Presenter presenter;

    MainModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void tryLogin(String user, String pass) {

        RequestParams params = new RequestParams();
        params.put("email", user);
        params.put("password", pass);

        RequestHandler handler = RequestHandler.getInstance("");
        handler.post(presenter.getAppContext(),BuildConfig.HOST + "/login", params, new RestListener() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String data) {
                Gson g = new Gson();
                Credentials credentials = g.fromJson(data, Credentials.class);
                String token = credentials.getToken();
                if (!token.equals("")){
                    PreferencesHandler.setTokenApi(token, presenter.getAppContext());
                    presenter.loginSucces();
                }

            }

            @Override
            public void onError(int statusCode, Header[] headers, String response) {
                presenter.loginError("Verifica el correo o la contraseña e intenta nuevamente.");
            }
        });
    }
}
