package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import java.io.IOException;

@ApplicationScoped
public class TemplateProvider {
    private static final String TEMPLATE_DIRECTORY_PATH = "WEB-INF/fm-templates";
    private static final String TEMPLATE_EXT = ".ftlh";

    public TemplateProvider() {
    }

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(true);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setServletContextForTemplateLoading(servletContext, "WEB-INF/fm-templates");
        return cfg.getTemplate(templateName + ".ftlh");
    }
}
