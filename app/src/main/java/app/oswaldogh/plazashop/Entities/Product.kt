package app.oswaldogh.plazashop.Entities

/**
 * Created by oswaldogomez on 05/12/17.
 */

class Product {
    var id: Int = 0
    var description: String? = null
    var url: String? = null
    var price: Float = 0.toFloat()
    var local: Int = 0
    var views: Int = 0

    constructor( id: Int,  description: String?,  price: Float,  local: Int,  views: Int,  url: String?){
        this.id = id
        this.description = description
        this.price = price
        this.local = local
        this.views = views
        this.url = url
    }
}
