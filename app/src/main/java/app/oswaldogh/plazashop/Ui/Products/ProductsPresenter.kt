package app.oswaldogh.plazashop.Ui.Products

import java.util.ArrayList

import app.oswaldogh.plazashop.Entities.Product

/**
 * Created by oswaldogomez on 05/12/17.
 */

class ProductsPresenter internal constructor(private val view: Interface.View?) : Interface.Presenter {
    private val model: Interface.Model

    init {
        this.model = ProductsModel(this)
    }

    fun getDataProducts() {
        if (view != null) {
            model.getProducts()
        }
    }

    override fun onLoadProucts(products: ArrayList<Product>) {
        view?.showProducts(products)
    }
}
