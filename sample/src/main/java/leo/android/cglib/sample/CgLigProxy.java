package leo.android.cglib.sample;

import android.content.Context;

import leo.android.cglib.proxy.Enhancer;
import leo.android.cglib.proxy.MethodInterceptor;

public class CgLigProxy {
    private CgLigProxy() {

    }
    public static <T> T newProxyInstance(Context context, Class<T> superClass, MethodInterceptor interceptor) {
        Enhancer e = new Enhancer(context);
        e.setSuperclass(superClass);
        e.setInterceptor(interceptor);
        return (T) e.create();
    }
}
