package ex.vaadin.app;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import javax.inject.Inject;
import javax.inject.Named;

public class MyApplication extends Application {

  @Inject
  @Named("welcome")
  protected String text;

  @Override
  public void init() {
      Window window = new Window();
      window.addComponent(new Label(text));

      Button btn = new Button("Click Me!");
      btn.addListener(ON_CLICK);

      window.addComponent(btn);

      setMainWindow(window);
  }

  private final ClickListener ON_CLICK = new ClickListener() {
    @Override
    public void buttonClick(ClickEvent event) {

      event.getButton().getWindow().showNotification("Hello!", "This is ON CLICK event listener.", Window.Notification.TYPE_HUMANIZED_MESSAGE);

    }
  };


}
