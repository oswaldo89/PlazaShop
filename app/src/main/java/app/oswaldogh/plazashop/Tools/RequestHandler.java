package app.oswaldogh.plazashop.Tools;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class RequestHandler{

    private static RequestHandler instance;

    private AsyncHttpClient client;

    private RequestHandler(){
        client = new AsyncHttpClient();
        client.addHeader("Accept", "application/json");
        client.addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijg1MDk0NTNiNDYwZjc5MTkzN2RmNDY4OTBmZTNjMjI0ZDc5OTc5MzNjMWMxMTdiMjJlY2NiNDMxNjg4YjNhOWIyMDI0OGUyYjMxMzIyMGM3In0.eyJhdWQiOiIxIiwianRpIjoiODUwOTQ1M2I0NjBmNzkxOTM3ZGY0Njg5MGZlM2MyMjRkNzk5NzkzM2MxYzExN2IyMmVjY2I0MzE2ODhiM2E5YjIwMjQ4ZTJiMzEzMjIwYzciLCJpYXQiOjE1MTM2NjY0MDYsIm5iZiI6MTUxMzY2NjQwNiwiZXhwIjoxNTQ1MjAyNDA2LCJzdWIiOiI2Iiwic2NvcGVzIjpbXX0.OwYWoNBcpIQweItyXVIMh-l2Js3ukWqCMoX2QkqEQwoAygDyt57gQXM0zVVmqb62dD39KUxqGzHpY9mf9skP0jvGpNCMFYbsNotXRyBbJHkiPs1F30ioF5bIPPjQC9eL3u8dbVSs97NTiWFy8e8C4ZUg7VLSYT3bmaPu-ZztnC9njbEIj-ywyKBbkQEMmx0hPtKejlHajsOV2OIupU7L0jIU7Z0k29enKOhUMB2YomWbgZp8tIMdXxeSmHyy8hZRnkyNBv21d4DaiYdukPltmv345od-TcqMmIdJjE34wG3vB92EERXTJ7WjL8rIl1elXo0qLLpaQxfeqxY6rQUyib4D7Po7gsb6hzZ4970RxygTnvVw_UiDEvGSG8-r3Om9uJGUckVmXrxpi7GqY7dUfmFDuetFMyGZDiBWwTvwaO1TnxZ6rXHXTsj60poZSrIk7pxt9TjrSkcNvH7LStWIzj3gmwGns5qPBk7oS8A4r0qbRJ5712UeOvMxs21eKheSU0WZlpCmHMI4pYDTavFCqldef6ZTcATTxPljZoAwrOx2R6SzmRJrK_qaHDHgIycKUmLnOM2FYg98bTVWPrewPXnHacidwf11T0A1Rp45V7S-EuSqSLuL35KQLBftUgyNy7FRvWe1h-u8AmKS-rs0Mir0S9XmaT6UdEhcaZZuvUk");
    }

    public static RequestHandler getInstance(){
        if(instance == null){
            instance = new RequestHandler();
        }
        return instance;
    }

    // You can add more parameters if you need here.
    public void get(String url, final RestListener listener){
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
                //Some debugging code here
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                String data = new String(response);
                listener.onSuccess(statusCode, headers, data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                //Some debugging code here, show retry dialog, feedback etc.
            }

            @Override
            public void onRetry(int retryNo) {
                //Some debugging code here-------

            }
        });
    }
}

