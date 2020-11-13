package leo.android.cglib.sample;

import android.content.Context;

import leo.android.cglib.proxy.Enhancer;
import leo.android.cglib.proxy.MethodInterceptor;
import leo.android.cglib.proxy.MethodProxy;

public class MyProxy implements MethodInterceptor {
	
	private Context context;
	
	public MyProxy(Context context) {
		this.context = context;
	}
	
	public Object getProxy(Class cls) {
		Enhancer e = new Enhancer(context);
        e.setSuperclass(cls);
        e.setInterceptor(this);
        return e.create();
    }

	@Override
	public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
		Logger.d("begin " + object.getClass().getName() + ".." + methodProxy.getMethodName());
		Object result = methodProxy.invokeSuper(object, args);
		Logger.d("end " + methodProxy.getMethodName());
		return result;
	}

}
