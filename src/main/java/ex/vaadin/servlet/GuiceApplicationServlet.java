package ex.vaadin.servlet;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Singleton
public class GuiceApplicationServlet extends AbstractApplicationServlet {

  protected final Provider<Application> applicationProvider;

  @Inject
  public GuiceApplicationServlet(Provider<Application> applicationProvider) {
      this.applicationProvider = applicationProvider;
  }

  @Override
  protected Application getNewApplication(HttpServletRequest request) throws ServletException {
    return applicationProvider.get();
  }

  @Override
  protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
    return Application.class;
  }

}
