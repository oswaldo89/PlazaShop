package app.oswaldogh.plazashop.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by oswaldogh89 on 04/01/18.
 */

public class Permissions {

    public static void enablePermissions(Activity ctx, String... PERMISSIONS) {
        int PERMISSION_ALL = 1;
        if (!hasPermissions(ctx, PERMISSIONS)) {
            ActivityCompat.requestPermissions(ctx, PERMISSIONS, PERMISSION_ALL);
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
