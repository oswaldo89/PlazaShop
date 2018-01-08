package app.oswaldogh.plazashop.Ui.Products;

import android.content.Context;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogh89 on 04/01/18.
 */

public interface Interface {

    interface View {
        void createListProducts(ArrayList<Product> products);
        void addMoreProductsToList(ArrayList<Product> products);
        void hideLoadMoreProgress();
        void setProductListEmpty();
        boolean adapterIsNull();
        Context getAppContext();
        Context getActivityContext();
    }

    interface Presenter {
        void onLoadProucts(ArrayList<Product> products);
        Context getAppContext();
    }

    interface Model {
        void getProducts(int totalProducts);
    }
}
