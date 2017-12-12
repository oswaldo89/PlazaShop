package app.oswaldogh.plazashop.Ui.Products

import java.util.ArrayList

import app.oswaldogh.plazashop.Entities.Product

/**
 * Created by oswaldogomez on 05/12/17.
 */

class ProductsModel(private val presenter: Interface.Presenter) : Interface.Model {

    override fun getProducts() {
        val products = ArrayList<Product>()

        products.add(Product(1, "Reparacion cristal Iphone 6", 980f, 150, 300, "https://tecnoandroid.net/wp-content/uploads/2017/04/cristal-templado-para-galaxy-s8-y-s8-plus-smrt.jpg"))
        products.add(Product(1, "Case para Iphone", 158f, 94, 640, "https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/M/KY/MKY32/MKY32_AV1_SPACE_GRAY?wid=1000&hei=1000&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=1486508198813"))
        products.add(Product(2, "Cristal Templado", 200f, 30, 120, "https://i.ytimg.com/vi/d8oMXVXoOfg/maxresdefault.jpg"))
        products.add(Product(3, "Abanico USB", 280f, 13, 35, "https://http2.mlstatic.com/8gb-kingston-memorias-usb-D_NQ_NP_486511-MPE20592728950_022016-F.jpg"))


        presenter.onLoadProucts(products)

    }
}
