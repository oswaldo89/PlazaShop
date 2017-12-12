package app.oswaldogh.plazashop.Ui.Products;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogomez on 05/12/17.
 */

public class ProductsModel implements Interface.Model {

    private Interface.Presenter presenter;
    public ProductsModel(Interface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Reparacion cristal Iphone 6",980,150,300, "https://tecnoandroid.net/wp-content/uploads/2017/04/cristal-templado-para-galaxy-s8-y-s8-plus-smrt.jpg"));
        products.add(new Product(1, "Case para Iphone",158,94,640, "https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/M/KY/MKY32/MKY32_AV1_SPACE_GRAY?wid=1000&hei=1000&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=1486508198813"));
        products.add(new Product(2, "Cristal Templado",200,30,120, "https://i.ytimg.com/vi/d8oMXVXoOfg/maxresdefault.jpg"));
        products.add(new Product(3, "Abanico USB",280,13,35, "https://http2.mlstatic.com/8gb-kingston-memorias-usb-D_NQ_NP_486511-MPE20592728950_022016-F.jpg"));


        presenter.onLoadProucts(products);

    }
}
