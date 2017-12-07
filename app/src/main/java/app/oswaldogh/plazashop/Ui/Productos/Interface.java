package app.oswaldogh.plazashop.Ui.Productos;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public interface Interface {
    interface View {
        void showProducts(ArrayList<Product> products);
    }
    interface Presenter{
        void onLoadProucts(ArrayList<Product> products);
    }
    interface Model{
        void getProducts();
    }
}
