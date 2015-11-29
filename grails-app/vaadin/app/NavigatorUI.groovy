package app

import app.views.MainView
import app.views.StartView
import com.vaadin.navigator.Navigator
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI

class NavigatorUI extends UI {

    static final MAINVIEW = "main"
    static final STARTVIEW = ""

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        page.title = "Navigation Example";

        // Create a navigator to control the views
        new Navigator(this, this).with { navigator->
            // Create and register the views
            addView STARTVIEW, new StartView(navigator)
            addView MAINVIEW, new MainView(navigator)
        }

    }
}
