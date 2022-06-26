package org.joker.template.generate.freemarker.method;

import java.util.List;

import org.joker.template.generate.util.NameCaseUtil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class UnderscorecaseToUppercamelcase implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (arguments.isEmpty()) {
            throw new NullPointerException();
        }
        Object arg1 = arguments.get(0);
        if (arg1 == null) {
            throw new NullPointerException();
        }
        return NameCaseUtil.underscorecaseToUppercamelcase(arg1.toString());
    }

}
