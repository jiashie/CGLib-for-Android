package leo.android.cglib.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import leo.android.cglib.proxy.MethodInterceptor;
import leo.android.cglib.proxy.MethodProxy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Printer printer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //printer = (Printer) new MyProxy(this).getProxy(Printer.class);
        printer = CgLigProxy.newProxyInstance(this, Printer.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Logger.d("begin " + object.getClass().getName() + ".." + methodProxy.getMethodName());
                Object result = methodProxy.invokeSuper(object, args);
                Logger.d("end " + methodProxy.getMethodName());
                return result;
            }
        });

        Button btn = (Button) super.findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn) {
            printer.print();
            Printer.staticMethod();
            printer.testAbs();

        }
    }
}
