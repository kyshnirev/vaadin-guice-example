package ex.vaadin.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.servlet.ServletScopes;
import com.vaadin.Application;
import ex.vaadin.app.MyApplication;
import ex.vaadin.servlet.GuiceApplicationServlet;
import javax.inject.Singleton;

@Singleton
public class ServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {

    ServletModule module = new ServletModule() {
        @Override
        protected void configureServlets() {
            serve("/*").with(GuiceApplicationServlet.class);

            bind(Application.class).to(MyApplication.class).in(ServletScopes.SESSION);
            bindConstant().annotatedWith(Names.named("welcome")).to("This is my first Vaadin/Guice Application");
        }
    };

    Injector injector = Guice.createInjector(module);

    return injector;
  }

}
