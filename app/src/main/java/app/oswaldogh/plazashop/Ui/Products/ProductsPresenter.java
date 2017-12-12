package app.oswaldogh.plazashop.Ui.Products;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public class ProductsPresenter implements Interface.Presenter {

    private Interface.View view;
    private Interface.Model model;

    ProductsPresenter(Interface.View view){
        this.view = view;
        this.model = new ProductsModel(this);
    }

    void getDataProducts(){
        if(view != null){
            model.getProducts();
        }
    }

    @Override
    public void onLoadProucts(ArrayList<Product> products) {
        if(view != null){
            view.showProducts(products);
        }
    }
}
