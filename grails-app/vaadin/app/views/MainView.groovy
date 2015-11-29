package app.views

import app.NavigatorUI
import com.vaadin.annotations.DesignRoot
import com.vaadin.navigator.Navigator
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.server.ThemeResource
import com.vaadin.ui.*
import com.vaadin.ui.declarative.Design

@DesignRoot
class MainView extends VerticalLayout implements View {

    VerticalLayout menuContent;
    Panel equalPanel;
    Button logout;

    public MainView(Navigator navigator) {
        Design.read this

        def button = {String title, String menuitem -> new Button(title,
                {navigator.navigateTo("$NavigatorUI.MAINVIEW/$menuitem")} as Button.ClickListener)}

        menuContent.addComponent button("Pig", "pig")
        menuContent.addComponent button("Cat", "cat")
        menuContent.addComponent button("Dog", "dog")
        menuContent.addComponent button("Reindeer", "reindeer");
        menuContent.addComponent button("Penguin", "penguin");
        menuContent.addComponent button("Sheep", "sheep");

        // Allow going back to the start
        logout.addClickListener { navigator.navigateTo("") }
    }

    @DesignRoot
    class AnimalViewer extends VerticalLayout {
        Label watching;
        Embedded pic;
        Label back;

        public AnimalViewer(String animal) {
            Design.read this

            watching.value="You are currently watching a $animal"
            pic.source = new ThemeResource("img/$animal-128px.png")
            back.value="and $animal is watching you back"
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        equalPanel.content = event.parameters ?
                new AnimalViewer(event.parameters) : new Label("Nothing to see here, just pass along.")
    }
}