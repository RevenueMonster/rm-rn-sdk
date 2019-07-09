package my.revenuemonster.reactlibrary;

import my.revenuemonster.reactlibrary.RevenueMonsterModule;
import com.revenuemonster.payment.PaymentResult;
import com.revenuemonster.payment.model.Transaction;
import com.revenuemonster.payment.model.Error;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

// Callback Result
public class Result implements PaymentResult {
    private final ReactApplicationContext reactContext;

    public Result(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    public void onPaymentSuccess(Transaction transaction) {
//        Log.d("SUCCESS", transaction.getStatus());
        WritableMap params = Arguments.createMap();
        params.putString("Status", transaction.getStatus());
        sendEvent(this.reactContext, "rm:success", params);
    }
    public void onPaymentFailed(Error error) {
//        Log.d("FAILED", error.getCode());
        WritableMap params = Arguments.createMap();
        params.putString("Error", error.getCode());
        sendEvent(this.reactContext, "rm:failed", params);
    }
    public void onPaymentCancelled() {
//        Log.d("CANCELLED", "User cancelled payment");
        WritableMap params = Arguments.createMap();
        params.putString("Error", "User cancelled payment");
        sendEvent(this.reactContext, "rm:cancelled", params);
    }

    private void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }
}