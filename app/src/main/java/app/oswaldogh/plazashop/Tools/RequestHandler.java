package app.oswaldogh.plazashop.Tools;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

import static app.oswaldogh.plazashop.Tools.UtilsKt.log;

public class RequestHandler {

    private static RequestHandler instance;

    private AsyncHttpClient client;

    private RequestHandler() {
        client = new AsyncHttpClient();
        client.addHeader("Accept", "application/json");
    }

    private RequestHandler(String token_api) {
        client = new AsyncHttpClient();
        client.addHeader("Accept", "application/json");
        client.addHeader("Authorization", "Bearer " + token_api);
    }

    public static RequestHandler getInstance() {
        if (instance == null) {
            instance = new RequestHandler();
        }
        return instance;
    }

    public static RequestHandler getInstance(String token_api) {
        if (instance == null) {
            instance = new RequestHandler(token_api);
        }
        return instance;
    }

    // You can add more parameters if you need here.
    public void get(final String url, RequestParams params, final RestListener listener) {
        client.get(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                listener.onSuccess(statusCode, headers, new String(response));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                log("**********************");
                log(url);
                log(new String(errorResponse));
                listener.onError(statusCode, headers, new String(errorResponse));
            }

            @Override
            public void onRetry(int retryNo) {
            }
        });
    }

    public void post(final String url, RequestParams params, final RestListener listener) {
        client.post(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                listener.onSuccess(statusCode, headers, new String(response));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                log("**********************");
                log(url);
                log(new String(errorResponse));
                listener.onError(statusCode, headers, new String(errorResponse));
            }

            @Override
            public void onRetry(int retryNo) {
            }
        });
    }
}

