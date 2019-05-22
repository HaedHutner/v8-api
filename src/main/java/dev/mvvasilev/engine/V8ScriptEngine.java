package dev.mvvasilev.engine;

import com.eclipsesource.v8.V8;

import javax.script.*;
import java.io.Reader;

public class V8ScriptEngine extends AbstractScriptEngine {

    private V8 runtime;

    @Override
    public Object eval(String s, ScriptContext scriptContext) throws ScriptException {
        return null;
    }

    @Override
    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        return null;
    }

    @Override
    public Bindings createBindings() {
        return null;
    }

    @Override
    public ScriptEngineFactory getFactory() {
        return null;
    }
}
