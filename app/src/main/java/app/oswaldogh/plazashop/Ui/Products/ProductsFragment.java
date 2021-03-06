package app.oswaldogh.plazashop.Ui.Products;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Adapters.Product.AdapterProductList;
import app.oswaldogh.plazashop.Adapters.Product.ProductItemView;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Tools.PreferencesHandler;
import app.oswaldogh.plazashop.Ui.ProductDetail.ProductDetailActivity;

public class ProductsFragment extends Fragment implements Interface.View, ProductItemView {

    private ProductsPresenter presenter;
    private SuperRecyclerView rv_productList;
    private AdapterProductList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_products, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Productos");
        PreferencesHandler.setReloadList(false, getActivity());
        presenter = new ProductsPresenter(this);
        initRecycler(v);
        return v;
    }

    private void initRecycler(View v) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv_productList = v.findViewById(R.id.product_list);
        rv_productList.setLayoutManager(llm);
        presenter.getDataProducts(0);
        rv_productList.setupMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
                presenter.getDataProducts(numberOfItems);
            }
        }, 10);
    }

    @Override
    public void createListProducts(ArrayList<Product> products) {
        adapter = new AdapterProductList(getActivity(), products, this);
        rv_productList.setAdapter(adapter);
    }

    @Override
    public void addMoreProductsToList(ArrayList<Product> products) {
        adapter.addItems(products);
        rv_productList.setAdapter(adapter);
    }

    @Override
    public void hideLoadMoreProgress() {
        rv_productList.hideMoreProgress();
    }

    @Override
    public void setProductListEmpty() {
        rv_productList.getEmptyView();
    }

    @Override
    public boolean adapterIsNull() {
        return adapter == null;
    }

    @Override
    public void onClickProductItem(Product item, int position) {
        Gson gson = new Gson();
        Product product = adapter.getItem(position);
        Intent i = new Intent(getContext(), ProductDetailActivity.class);
        i.putExtra("ProductDetail", gson.toJson(product));
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (rv_productList.getAdapter() != null && PreferencesHandler.getReloadList(getActivity())) {
            PreferencesHandler.setReloadList(false, getActivity());
            adapter = null;
            rv_productList.showProgress();
            rv_productList.hideMoreProgress();
            presenter.getDataProducts(0);
        }


    }
}
