package app.oswaldogh.plazashop.Ui.Products;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.Tools.RequestHandler;
import app.oswaldogh.plazashop.Tools.RestListener;
import cz.msebera.android.httpclient.Header;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public class ProductsModel implements Interface.Model {

    private Interface.Presenter presenter;

    ProductsModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getProducts(int totalProducts) {

        RequestHandler handler = RequestHandler.getInstance("");
        handler.get(BuildConfig.HOST + "/product_list/" + totalProducts, null, new RestListener() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String data) {
                Gson g = new Gson();
                ArrayList<Product> products = new ArrayList<>(Arrays.asList(g.fromJson(data, Product[].class)));
                presenter.onLoadProucts(products);
            }

            @Override
            public void onError(int statusCode, Header[] headers, String response) {
                
            }
        });
    }
}