package my.revenuemonster.reactlibrary;

import android.util.Log;
import android.app.Activity;
import android.widget.Toast;
import android.support.annotation.Nullable;

import com.revenuemonster.payment.Checkout;
import com.revenuemonster.payment.PaymentResult;

import com.revenuemonster.payment.constant.Env;
import com.revenuemonster.payment.constant.Method;
import com.revenuemonster.payment.model.Error;
import com.revenuemonster.payment.model.Transaction;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RevenueMonsterModule extends ReactContextBaseJavaModule implements PaymentResult {

    private final ReactApplicationContext reactContext;

    public RevenueMonsterModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RevenueMonster";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some real useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public void show(String message) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void triggerEvent(String name) {
        WritableMap params = Arguments.createMap();
        params.putString("Name", name);
        sendEvent(reactContext, "rm:success", params);
    }

    @ReactMethod
    public void checkout(String appID, String checkoutID) {
        try {
            Activity activity = getCurrentActivity();
            new Checkout(activity.getApplication()).getInstance().
                    setWeChatAppID(appID).setEnv(Env.SANDBOX).
                    pay(Method.GRABPAY_MY, checkoutID, this);
        } catch(Exception e) {
            e.printStackTrace();
            WritableMap params = Arguments.createMap();
            params.putString("Error", e.getMessage());
            sendEvent(reactContext, "rm:failed", params);
        }
    }

    private void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }

    public void onPaymentSuccess(Transaction transaction) {
        Log.d("SUCCESS", transaction.getStatus());
        WritableMap params = Arguments.createMap();
        params.putString("Status", transaction.getStatus());
        sendEvent(this.reactContext, "rm:success", params);
    }
    public void onPaymentFailed(Error error) {
        Log.d("FAILED", error.getMessage());
        WritableMap params = Arguments.createMap();
        params.putString("Error", error.getMessage());
        sendEvent(this.reactContext, "rm:failed", params);
    }
    public void onPaymentCancelled() {
        Log.d("CANCELLED", "cancelled");
        WritableMap params = Arguments.createMap();
        params.putString("Error", "User cancelled payment");
        sendEvent(this.reactContext, "rm:cancelled", params);
    }
}
