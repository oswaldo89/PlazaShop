package app.oswaldogh.plazashop.Ui.ProductAdd;

import android.content.Context;

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
        Context getActivityContext();
    }
    interface Presenter{
        void onSaveProduct();
        void onErrorUpload();
        Context getAppContext();
    }
    interface Model{
        void saveProduct(Product product);
    }
}
