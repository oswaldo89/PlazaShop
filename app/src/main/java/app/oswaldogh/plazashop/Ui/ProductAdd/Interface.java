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
        void productSaved(String info, boolean status);
        Context getActivityContext();
    }
    interface Presenter{
        void onSaveProduct();
        Context getAppContext();
    }
    interface Model{
        void saveProduct(Product product);
    }
}
