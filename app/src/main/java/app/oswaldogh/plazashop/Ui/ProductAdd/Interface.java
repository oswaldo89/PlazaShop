package app.oswaldogh.plazashop.Ui.ProductAdd;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogh89 on 04/01/18.
 */

public interface Interface {
    interface View{
        void uploadError(String message);
        void showLoading();
        void hideLoading();
        void productSaved(String info);
        String tokenApi();
    }
    interface Presenter{
        void onSaveProduct();
        void onErrorUpload();
        String onLoadTokenApi();
    }
    interface Model{
        void saveProduct(Product product);
    }
}
