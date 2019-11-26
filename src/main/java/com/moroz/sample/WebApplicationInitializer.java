package com.moroz.sample;

import com.moroz.sample.config.Conf;
import com.moroz.sample.config.PersistenceContext;
import com.moroz.sample.config.WebServiceConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.h2.server.web.WebServlet;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MainAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebServiceConfig.class);
		context.register(Conf.class);
		context.register(PersistenceContext.class);
		servletContext.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic servlet = servletContext.addServlet(
				"h2-console", new WebServlet());
		servlet.setLoadOnStartup(2);
		servlet.addMapping("/console/*");

		ServletRegistration.Dynamic service = servletContext.addServlet("service", new CXFServlet());
		//servlet.setLoadOnStartup(2);
		service.addMapping("/services/*");

	}

}
