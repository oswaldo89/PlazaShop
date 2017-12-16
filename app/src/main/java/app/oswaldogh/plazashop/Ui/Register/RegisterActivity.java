package app.oswaldogh.plazashop.Ui.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.Main.MainActivity;

public class RegisterActivity extends AppCompatActivity implements Interface.View {
    RegisterPresenter presenter;
    EditText txtEmail, txtPassOne, txtPassTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new RegisterPresenter(this);
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
        presenter.register(txtEmail.getText().toString(), txtPassOne.getText().toString(), txtPassTwo.getText().toString());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void allFields() {
        Toast.makeText(this,"Favor de llenar todos los campos.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void passwordNotMatch() {
        Toast.makeText(this,"Las contraseñas no coinsiden.", Toast.LENGTH_LONG).show();
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
