package app.oswaldogh.plazashop.Ui.ProductAdd;

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
            view.showLoading();
            model.saveProduct(product);
        }
    }

    @Override
    public void onSaveProduct() {
        if (view != null) {
            view.hideLoading();
            view.productSaved("Producto guardado correctamente");
        }
    }

    @Override
    public void onErrorUpload() {
        if (view != null) {
            view.hideLoading();
            view.uploadError("Ocurrio un error al guardar su producto, intente nuevamente.");
        }
    }

    @Override
    public String onLoadTokenApi() {
        return view.tokenApi();
    }
}
