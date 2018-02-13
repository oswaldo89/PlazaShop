package app.oswaldogh.plazashop.Ui.Register;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.Main.MainActivity;

public class RegisterActivity extends AppCompatActivity implements Interface.View {
    ProgressDialog progressNewProduct;
    RegisterPresenter presenter;
    EditText txtName, txtEmail, txtPassOne, txtPassTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new RegisterPresenter(this);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassOne = findViewById(R.id.txtPassOne);
        txtPassTwo = findViewById(R.id.txtPassTwo);
    }

    private void goToMain() {
        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void onRegister(View v) {
        presenter.register(txtName.getText().toString(), txtEmail.getText().toString(), txtPassOne.getText().toString(), txtPassTwo.getText().toString());
    }

    @Override
    public void showLoading() {
        progressNewProduct = new ProgressDialog(this);
        progressNewProduct.setTitle("PlazaShop");
        progressNewProduct.setMessage("Estamos registrando tu usuario.");
        progressNewProduct.setCancelable(false);
        progressNewProduct.show();
    }

    @Override
    public void hideLoading() {
        progressNewProduct.hide();
    }

    @Override
    public void allFields() {
        Toast.makeText(this, "Favor de llenar todos los campos.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSucces(String text) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("PlazaShop");
        alertDialog.setMessage(text);
        alertDialog.setIcon(R.drawable.ic_iconapp);
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                goToMain();
            }
        });
        alertDialog.show();
    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void passwordNotMatch() {
        Toast.makeText(this, "Las contraseñas no coinsiden.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMain();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                goToMain();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
