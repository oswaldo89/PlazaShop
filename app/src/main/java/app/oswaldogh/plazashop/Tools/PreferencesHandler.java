package app.oswaldogh.plazashop.Tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by oswaldogh89 on 05/01/18.
 */

public class PreferencesHandler {
    public void setTokenApi(String token_api, Context context) {
        SharedPreferences preferences = context.getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token_api", token_api);
        editor.apply();
    }

    public static String getTokenApi(Context context) {
        SharedPreferences prfs = context.getSharedPreferences("AUTHENTICATION_FILE_NAME", Context.MODE_PRIVATE);
        return prfs.getString("token_api", "");
    }
}
