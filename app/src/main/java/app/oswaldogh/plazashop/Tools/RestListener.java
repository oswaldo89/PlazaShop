package app.oswaldogh.plazashop.Tools;

import cz.msebera.android.httpclient.Header;

public interface RestListener{
    void onSuccess(int statusCode, Header[] headers, String response);
}
