package app.oswaldogh.plazashop.Ui.ProductAdd;

/**
 * Created by oswaldogh89 on 04/01/18.
 */

public interface Interface {
    interface View{
        void uploadError(String message);
        void showLoading();
        void hideLoading();
    }
    interface Presenter{
        void onSaveProduct();
    }
    interface Model{
        void saveProduct();
    }
}
