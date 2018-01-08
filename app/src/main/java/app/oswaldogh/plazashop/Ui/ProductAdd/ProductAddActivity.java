package app.oswaldogh.plazashop.Ui.ProductAdd;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.oswaldogh89.picker.ImagePicker;

import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Tools.Permissions;

import static app.oswaldogh.plazashop.Tools.UtilsKt.log;

public class ProductAddActivity extends AppCompatActivity implements Interface.View {
    ImagePicker picker;
    EditText txtNameProduct, txtPrice, txtDescriptionProduct;
    Spinner spnCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] PERMISSIONS = {Manifest.permission.CAMERA};
        Permissions.enablePermissions(this, PERMISSIONS);

        initViews();
    }

    private void initViews() {
        txtNameProduct = findViewById(R.id.txtNameProduct);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescriptionProduct = findViewById(R.id.txtDescriptionProduct);
        spnCategories = findViewById(R.id.spnCategories);

        picker = findViewById(R.id.picker);
        picker.setMainactivity(ProductAddActivity.this);
        picker.SetBorderImageColor("#075e55");
        picker.enableDelateAll(true);
    }

    public void saveProduct(View view) {
        String name = txtNameProduct.getText().toString();
        float price = txtPrice.getText().toString().equals("") ? 0.0f : Float.parseFloat(txtPrice.getText().toString());
        String description = txtDescriptionProduct.getText().toString();
        int category = spnCategories.getSelectedItemPosition();

        log("name : " + name);
        log("precio : " + price);
        log("description : " + description);
        log("category : " + category);
    }

    @Override
    public void uploadError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case ImagePicker.REQUEST_CAMERA:
                if (resultCode == RESULT_OK)
                    picker.AddNewImage(imageReturnedIntent);
                break;
            case ImagePicker.REQUEST_GALLERY:
                if (resultCode == RESULT_OK)
                    picker.AddNewImage(imageReturnedIntent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
