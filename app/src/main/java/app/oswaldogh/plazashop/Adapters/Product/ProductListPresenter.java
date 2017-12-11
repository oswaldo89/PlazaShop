package app.oswaldogh.plazashop.Adapters.Product;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Entities.Product;

/**
 * Created by oswaldogomez on 11/12/17.
 */

public class ProductListPresenter {

    private ArrayList<Product> products;

    public void onBindRepositoryRowViewAtPosition(AdapterProductList.ListViewHolder holder, int position, Context context) {

        Product prod = products.get(position);

        Glide.with(context).load(prod.getUrl()).into(holder.image);
        holder.description.setText(prod.getDescription());
    }

    public int getRepositoriesRowsCount() {
        return products.size();
    }
}
