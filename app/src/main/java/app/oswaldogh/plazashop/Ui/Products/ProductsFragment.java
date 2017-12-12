package app.oswaldogh.plazashop.Ui.Products;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Adapters.Product.AdapterProductList;
import app.oswaldogh.plazashop.Adapters.Product.ProductItemView;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.ProductDetail.ProductDetailActivity;

public class ProductsFragment extends Fragment implements Interface.View, ProductItemView {

    private ProductsPresenter presenter;
    private RecyclerView rv_productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_products, container, false);
        presenter = new ProductsPresenter(this);
        initRecycler(v);
        return v;
    }

    private void initRecycler(View v) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv_productList = v.findViewById(R.id.product_list);
        rv_productList.setHasFixedSize(true);
        rv_productList.setLayoutManager(llm);
        presenter.getDataProducts();
    }

    @Override
    public void showProducts(ArrayList<Product> products) {
        AdapterProductList adapter = new AdapterProductList(getActivity(), products, this);
        rv_productList.setAdapter(adapter);
    }

    @Override
    public void onClickProductItem(Product item, int position) {
        Intent i = new Intent(getContext(), ProductDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString("url_image",item.getUrl());
        i.putExtras(extras);
        startActivity(i);
    }
}
