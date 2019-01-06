package servlet;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FibonacciNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(
        urlPatterns = {"/aplikacja"}
)
public class FibonacciNumberServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(FibonacciNumber.class);
    private static final String TEMPLATE_ENTER = "getNumber";
    private static final String TEMPLATE_FIBONACCI = "fibonacciList";
    private static final String TEMPLATE_BAD_VALUES = "badValues";

    @Inject
    TemplateProvider templateProvider;
    @Inject
    FibonacciNumber fibonacciNumber;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Map<String, Object> model = new HashMap();

        Template template = templateProvider.getTemplate(getServletContext(), "getNumber");

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            LOG.info("Error while processing the template: " + e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        String userNumber = req.getParameter("number");

        if (!Pattern.matches("\\d",userNumber)|| userNumber==null){
            Template template = templateProvider.getTemplate(getServletContext(), "badValues");
        }
        Long number = Long.parseLong(userNumber);

        LOG.info("Requested number: {}", number);
        Map<String, Object> model = new HashMap();

        if (number < 0 || number == null) {
            Template template = templateProvider.getTemplate(getServletContext(), "badValues");

            try {
                template.process(model, out);
            } catch (TemplateException e) {
                LOG.error("Error while processing the template: " + e);
            }
        } else {
            List<BigDecimal> result = fibonacciNumber.fnumbers(number);
            model.put("FibonacciList", result);
            model.put("FibonacciValue", result.get(result.size()-1));
            Template template = templateProvider.getTemplate(getServletContext(), "fibonacciList");

            try {
                template.process(model, out);
            } catch (TemplateException e) {
                LOG.info("Error while processing the template: " + e);
            }
        }

    }
}
