package dev.mvvasilev.engine;

import com.eclipsesource.v8.V8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.List;
import java.util.Objects;

public class V8ScriptEngineFactory implements ScriptEngineFactory {

    private static final String ENGINE = "v8";

    private static final String ENGINE_VERSION = V8.getV8Version();

    private static final String FILENAME = "js";

    private static final String LANGUAGE = "javascript";

    private static final String LANGUAGE_VERSION = "ECMAScript 6+";

    private static final String NAME = "v8";

    private static final List<String> LANGUAGE_EXTENSIONS = List.of("js");

    private static final List<String> MIME_TYPES = List.of("application/javascript");

    private static final List<String> NAMES = List.of("v8");

    @Override
    public String getEngineName() {
        return NAME;
    }

    @Override
    public String getEngineVersion() {
        return ENGINE_VERSION;
    }

    @Override
    public List<String> getExtensions() {
        return LANGUAGE_EXTENSIONS;
    }

    @Override
    public List<String> getMimeTypes() {
        return MIME_TYPES;
    }

    @Override
    public List<String> getNames() {
        return NAMES;
    }

    @Override
    public String getLanguageName() {
        return LANGUAGE;
    }

    @Override
    public String getLanguageVersion() {
        return LANGUAGE_VERSION;
    }

    @Override
    public Object getParameter(String param) {
        switch (param) {
            case ScriptEngine.ENGINE:
                return ENGINE;
            case ScriptEngine.ENGINE_VERSION:
                return ENGINE_VERSION;
            case ScriptEngine.FILENAME:
                return FILENAME;
            case ScriptEngine.LANGUAGE:
                return LANGUAGE;
            case ScriptEngine.LANGUAGE_VERSION:
                return LANGUAGE_VERSION;
            case ScriptEngine.NAME:
                return NAME;
            default:
                return null;
        }
    }

    @Override
    public String getMethodCallSyntax(String object, String method, String... arguments) {
        StringBuilder result = new StringBuilder(Objects.requireNonNull(object))
                .append(".")
                .append(Objects.requireNonNull(method))
                .append("(");

        for (int i = 0; i < arguments.length; i++) {

            result.append(arguments[i]);

            if (i < arguments.length - 1) {
                result.append(",");
            }
        }

        result.append(")");

        return result.toString();
    }

    @Override
    public String getOutputStatement(String content) {
        return "print(" + content + ");";
    }

    @Override
    public String getProgram(String... statements) {
        Objects.requireNonNull(statements);

        StringBuilder sb = new StringBuilder();

        for (String statement : statements) {
            sb.append(Objects.requireNonNull(statement)).append(';');
        }

        return sb.toString();
    }

    @Override
    public ScriptEngine getScriptEngine() {
        return new V8ScriptEngine();
    }
}
