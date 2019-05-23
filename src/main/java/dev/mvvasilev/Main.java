package dev.mvvasilev;

import com.eclipsesource.v8.V8;

import javax.script.ScriptEngineManager;

public class Main {

    public static void main(String[] args) {
        V8 v8Runtime = V8.createV8Runtime();
        System.out.println(V8.getV8Version());
    }

}
