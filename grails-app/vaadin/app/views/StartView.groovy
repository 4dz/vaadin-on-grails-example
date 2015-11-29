package app.views

import app.NavigatorUI
import com.vaadin.navigator.Navigator
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Notification
import com.vaadin.ui.VerticalLayout

class StartView extends VerticalLayout implements View {
    public StartView(Navigator navigator) {
        setSizeFull();

        Button button = new Button()
        button.with {
            caption="Go to Main View"
            addClickListener { navigator.navigateTo NavigatorUI.MAINVIEW }
        }

        addComponent button
        setComponentAlignment button, Alignment.MIDDLE_CENTER
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show "Welcome to the Animal Farm"
    }


}
