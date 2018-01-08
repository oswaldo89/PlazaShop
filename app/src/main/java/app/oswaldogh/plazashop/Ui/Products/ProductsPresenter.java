package app.oswaldogh.plazashop.Ui.Products;

import android.content.Context;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

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
        if (this.view != null) {
            this.model.getProducts(totalProducts);
        }
    }

    public void onLoadProucts(ArrayList<Product> products) {
        if (this.view != null) {
            if (this.view.adapterIsNull()) {
                this.view.createListProducts(products);
            } else {
                if (products.size() > 0)
                    this.view.addMoreProductsToList(products);
            }
            if (products.size() == 0 && this.view.adapterIsNull()) {
                this.view.setProductListEmpty();
            }
            this.view.hideLoadMoreProgress();
        }
    }

    @Override
    public Context getAppContext() {
        if (this.view != null) {
            return this.view.getActivityContext();
        }
        return null;
    }
}
