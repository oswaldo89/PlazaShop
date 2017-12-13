package app.oswaldogh.plazashop.Tools

import android.util.Log

/**
 * Created by oswaldogomez on 12/12/17.
 */

val LOG_ENABLED: Boolean = true;
val TAG: String = "ps_log"

fun log(text : String){
    if(LOG_ENABLED){
        Log.v(TAG,text)
    }
}