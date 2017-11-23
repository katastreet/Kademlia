package main.gobinding;

import com.sun.jna.Native;

//math.go is a go file with multiply implementation
//built an so file using:  go build -o math.so -buildmode=c-shared math.go
//Math class is interface to this go binding


public class JNATest {
	public static void main(String[] args) {
		Math awesome = (Math) Native.loadLibrary("./math.so", Math.class);
        System.out.println(awesome.Multiply(2, 5));
	}


}
