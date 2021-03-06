package app.oswaldogh.plazashop.Ui.Products;

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
    }

    interface Presenter {
        void onLoadProucts(ArrayList<Product> products);
    }

    interface Model {
        void getProducts(int totalProducts);
    }
}
