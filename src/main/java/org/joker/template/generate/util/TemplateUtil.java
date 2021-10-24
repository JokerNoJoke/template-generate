package org.joker.template.generate.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;

public class TemplateUtil {

    private static final String TEMPLATE_DIRECTORY = "template";

    private static final Configuration CONFIGURATION = getConfiguration();

    public static void process(String name, Object dataModel, Writer out) throws TemplateException, IOException {
        Template template = CONFIGURATION.getTemplate(name);
        template.process(dataModel, out);
    }

    private static Configuration getConfiguration() {
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.29) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        try {
            URL url = ClassLoader.getSystemResource(TEMPLATE_DIRECTORY);
            cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // From here we will set the settings recommended for new projects. These
        // aren't the defaults for backward compatibilty.

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

        // Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);

        // Do not fall back to higher scopes when reading a null loop variable:
        cfg.setFallbackOnNullLoopVariable(false);

        return cfg;
    }

}
