package dev.mvvasilev.engine;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

public class V8ScriptEngineFactoryTests {

    private ScriptEngineFactory v8Factory;

    public V8ScriptEngineFactoryTests() {
        v8Factory = new V8ScriptEngineFactory();
    }

    @Test
    public void testFactoryParameters() {
        Assert.assertEquals(v8Factory.getEngineName(), v8Factory.getParameter(ScriptEngine.ENGINE));
        Assert.assertEquals(v8Factory.getEngineVersion(), v8Factory.getParameter(ScriptEngine.ENGINE_VERSION));
        Assert.assertEquals(v8Factory.getLanguageName(), v8Factory.getParameter(ScriptEngine.LANGUAGE));
        Assert.assertEquals(v8Factory.getLanguageVersion(), v8Factory.getParameter(ScriptEngine.LANGUAGE_VERSION));
    }

}
