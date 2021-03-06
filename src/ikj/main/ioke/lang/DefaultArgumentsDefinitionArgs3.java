/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package ioke.lang;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Collection;

import ioke.lang.exceptions.ControlFlow;

/**
 *
 * @author <a href="mailto:ola.bini@gmail.com">Ola Bini</a>
 */
public class DefaultArgumentsDefinitionArgs3 implements ArgumentsDefinition {
    private final String name0;
    private final String name1;
    private final String name2;

    public DefaultArgumentsDefinitionArgs3(String name0, String name1, String name2) {
        this.name0 = name0;
        this.name1 = name1;
        this.name2 = name2;
    }

    public void assignArgumentValues(final IokeObject locals, final IokeObject context, final IokeObject message, final Object on, final Call call) throws ControlFlow {
        final Runtime runtime = context.runtime;
        if(call.cachedPositional == null) {
            call.cachedArgCount = 3;
            call.cachedPositional = DefaultArgumentsDefinitionArgs1.assign(context, message, on, 3);
            locals.setCell(name0, call.cachedPositional.get(0));
            locals.setCell(name1, call.cachedPositional.get(1));
            locals.setCell(name2, call.cachedPositional.get(2));
        } else {
            locals.setCell(name0, call.cachedPositional.get(0));
            locals.setCell(name1, call.cachedPositional.get(1));
            locals.setCell(name2, call.cachedPositional.get(2));
        }
    }

    public void assignArgumentValues(final IokeObject locals, final IokeObject context, final IokeObject message, final Object on) throws ControlFlow {
        List<Object> result = DefaultArgumentsDefinitionArgs1.assign(context, message, on, 3);
        locals.setCell(name0, result.get(0));
        locals.setCell(name1, result.get(1));
        locals.setCell(name2, result.get(2));
    }

    public String getCode() {
        return getCode(true);
    }

    public String getCode(boolean lastComma) {
        if(lastComma) {
            return name0 + ", " + name1 + ", " + name2 + ", ";
        } else {
            return name0 + ", " + name1 + ", " + name2;
        }
    }

    public Collection<String> getKeywords() {
        return new ArrayList<String>();
    }

    public List<DefaultArgumentsDefinition.Argument> getArguments() {
        return Arrays.asList(new DefaultArgumentsDefinition.Argument(name0), new DefaultArgumentsDefinition.Argument(name1), new DefaultArgumentsDefinition.Argument(name2));
    }

    public boolean isEmpty() {
        return false;
    }

    public String getRestName() {
        return null;
    }

    public String getKrestName() {
        return null;
    }
}
