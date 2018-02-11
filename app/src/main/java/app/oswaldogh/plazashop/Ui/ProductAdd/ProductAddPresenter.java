package app.oswaldogh.plazashop.Ui.ProductAdd;

import android.content.Context;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogh89 on 10/02/18.
 */

public class ProductAddPresenter implements Interface.Presenter {
    private Interface.View view;
    private Interface.Model model;

    ProductAddPresenter(Interface.View view) {
        this.view = view;
        this.model = new ProductAddModel(this);
    }

    void saveProduct(Product product) {
        if (view != null) {
            model.saveProduct(product);
        }
    }

    @Override
    public void onSaveProduct() {
        if (view != null) {
            view.productSaved("Producto guardado correctamente", true);
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
