import business.SpringBusinessConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.SpringWebConfig;

import javax.servlet.Filter;


public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String CHARACTER_ENCODING = "UTF-8";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringBusinessConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        return new Filter[] { encodingFilter };
    }

}

