package leo.android.cglib.sample;

public abstract class Printer {

	public static void staticMethod() {
		Logger.d("static stub");
	}
	public void print() {
		Logger.d("Hello, world!");
	}

	public abstract void testAbs();

}
