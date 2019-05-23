package dev.mvvasilev.engine;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Value;
import dev.mvvasilev.util.ConversionUtils;

import javax.script.*;
import java.io.Reader;

public class V8ScriptEngine extends AbstractScriptEngine {

    private V8ScriptEngineFactory factory;

    private V8 runtime;

    V8ScriptEngine(V8ScriptEngineFactory factory, V8 runtime) {
        this.factory = factory;
        this.runtime = runtime;
    }

    @Override
    public Object eval(String s, ScriptContext scriptContext) throws ScriptException {
        loadContext(scriptContext);
        return runtime.executeScript(s);
    }

    @Override
    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        loadContext(scriptContext);
        return null;
    }

    private void loadContext(ScriptContext context) {
        this.context = context;
        context.getBindings(ScriptContext.ENGINE_SCOPE).forEach((key, value) -> {
            if (value instanceof Integer) {
                runtime.add(key, (int) value);
                return;
            }

            if (value instanceof Double) {
                runtime.add(key, (double) value);
                return;
            }

            if (value instanceof String) {
                runtime.add(key, (String) value);
                return;
            }

            if (value instanceof Boolean) {
                runtime.add(key, (boolean) value);
                return;
            }

            if (value instanceof V8Value) {
                runtime.add(key, (V8Value) value);
                return;
            }

            // If the object in the context is none of the default types supported by V8, convert it to such and then add
            V8Value val = ConversionUtils.convertJavaObjectToV8Value(value);
            runtime.add(key, val);
        });
    }

    @Override
    public Bindings createBindings() {
        return context.getBindings(ScriptContext.ENGINE_SCOPE);
    }

    @Override
    public ScriptEngineFactory getFactory() {
        return factory;
    }

    @Override
    protected void finalize() throws Throwable {
        runtime.terminateExecution();
    }
}
