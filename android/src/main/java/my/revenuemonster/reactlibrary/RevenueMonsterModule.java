package my.revenuemonster.reactlibrary;

import android.app.Activity;
import android.widget.Toast;
import android.support.annotation.Nullable;

import com.revenuemonster.payment.Checkout;

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

public class RevenueMonsterModule extends ReactContextBaseJavaModule {

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
                    pay(Method.WECHATPAY_MY, checkoutID, new Result(this.reactContext));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }
}
