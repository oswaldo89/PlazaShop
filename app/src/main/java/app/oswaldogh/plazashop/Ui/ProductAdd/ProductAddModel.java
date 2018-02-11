package app.oswaldogh.plazashop.Ui.ProductAdd;

import com.loopj.android.http.RequestParams;

import java.io.FileNotFoundException;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.Tools.PreferencesHandler;
import app.oswaldogh.plazashop.Tools.RequestHandler;
import app.oswaldogh.plazashop.Tools.RestListener;
import cz.msebera.android.httpclient.Header;

import static app.oswaldogh.plazashop.Tools.UtilsKt.log;


/**
 * Created by oswaldogh89 on 10/02/18.
 */

public class ProductAddModel implements Interface.Model {
    private Interface.Presenter presenter;

    ProductAddModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveProduct(Product product) {
        String tokenApi = PreferencesHandler.getTokenApi(this.presenter.getAppContext());
        RequestHandler handler = RequestHandler.getInstance(tokenApi);

        RequestParams params = new RequestParams();
        params.put("nombre", product.getNombre());
        params.put("categoriaId", product.getCategoria());
        params.put("local", product.getLocal());
        params.put("descripcion", product.getDescripcion());
        params.put("precio", product.getPrecio());


        try {

            for (int i = 0; i < product.getImage().size(); i++) {
                params.put("image[" + i + "]", product.getImageFile(i), "image/jpeg");
            }

            params.setUseJsonStreamer(false);
        } catch (FileNotFoundException e) {
            log("error:" + e.getMessage());
        }


        handler.post(presenter.getAppContext(), BuildConfig.HOST + "/product", params, new RestListener() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String data) {
                presenter.onSaveProduct();
            }

            @Override
            public void onError(int statusCode, Header[] headers, String response) {
                log(response);
            }
        });
    }
}
