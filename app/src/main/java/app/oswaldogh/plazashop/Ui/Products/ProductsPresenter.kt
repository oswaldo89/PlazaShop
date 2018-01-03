package app.oswaldogh.plazashop.Ui.Products

import app.oswaldogh.plazashop.Entities.Product
import java.util.*

/**
 * Created by oswaldogomez on 05/12/17.
 */

class ProductsPresenter internal constructor(private val view: Interface.View?) : Interface.Presenter {
    private val model: Interface.Model

    init {
        this.model = ProductsModel(this)
    }

    fun getDataProducts(totalProducts: Int) {
        if (view != null) {
            model.getProducts(totalProducts)
        }
    }

    override fun onLoadProucts(products: ArrayList<Product>) {
        view?.showProducts(products)
    }
}
