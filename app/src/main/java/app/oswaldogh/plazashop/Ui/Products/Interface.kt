package app.oswaldogh.plazashop.Ui.Products

import app.oswaldogh.plazashop.Entities.Product
import java.util.*

/**
 * Created by oswaldogomez on 05/12/17.
 */

interface Interface {
    interface View {
        fun showProducts(products: ArrayList<Product>)
    }

    interface Presenter {
        fun onLoadProucts(products: ArrayList<Product>)
    }

    interface Model {
        fun getProducts(totalProducts: Int)
    }
}
