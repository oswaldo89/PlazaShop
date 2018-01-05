package app.oswaldogh.plazashop.Ui.Products;

import java.util.ArrayList;

/**
 * Created by oswaldogh89 on 04/01/18.
 */

public final class ProductsPresenter implements Interface.Presenter {
    private final Interface.Model model;
    private final Interface.View view;

    ProductsPresenter(Interface.View view) {
        this.view = view;
        this.model = new ProductsModel(this);
    }

    void getDataProducts(int totalProducts) {
        if(this.view != null) {
            this.model.getProducts(totalProducts);
        }
    }

    public void onLoadProucts(ArrayList products) {
        if(this.view != null) {
            this.view.showProducts(products);
        }
    }
}
