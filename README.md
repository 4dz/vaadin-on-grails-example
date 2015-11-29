# Vaadin On Grails: Navigator and Declarative Design
This project is a port of one of the examples within the Vaadin manual "[Book of Vaadin](https://vaadin.com/book/)" from
Java to Groovy on Grails.

Chapter 11.9. [Navigating in an Application](https://vaadin.com/book/-/page/advanced.navigator.html) introduces 
navigation between views but also uses a mixture of programmatic design (think, Swing-like programming) as well as 
declarative design (HTML or XML style UI definition).

## Getting Started
This project was created within IntelliJ Idea as advised by [Vaadin on Grails - Create project in IntelliJ IDEA](https://vaadin.com/wiki/-/wiki/Main/Vaadin%20on%20Grails%20-%20Create%20project%20in%20IntelliJ%20IDEA)

In essence,

1. [Download Grails](https://grails.org/download.html) - ensure you get the latest Grails v2 
   (the Vaadin plugin isn't usable with Grails 3 at the time of writing)
2. Create a Grails Project (e.g. within the IDE)
3. Edit `BuildConfig.groovy` and add the latest Vaadin plugin e.g. `compile ":vaadin:7.5.2"`
4. Also add the hibernate-validator dependancy to this file (see explanation below).
5. Remove all mappings from UrlMappings.groovy `class UrlMappings { static mappings = {} }`
6. Compile and Run the app
7. Manually create a grails-app/vaadin folder and add your UI classes


Note that in order to get this to work, there is an additional step mentioned within the comments on that page; 
in order to solve the `NoClassDefFoundError: javax/validation/ParameterNameProvider` exception, you must define 
hibernate-validator jar as a runtime dependency in BuildConfig.groovy:
                                                                                                         
    dependencies {
        ....
        runtime 'org.hibernate:hibernate-validator:5.1.1.Final'
    }

## Declarative Design
Vaadin on Grails can use declarative design, but you have to put the design HTML files on the classpath.
There are three places this appears to work,

 * In grails-app/conf/ : which isn't ideal, as I don't consider these to be configuration files
 * Alternatively can go in src/java/ : again not ideal as they are not Java source files
 * Alternatively can go in web-app/WEB-INF/ : probably the best option.
 
By default Vaadin looks for a HTML file named by the class simple name followed by ".html"; within the same package 
folder structure as the the View class.  In this example, app.views.MainView will look for /app/views/MainView.html.
This can be overridden in the @DesignRoot annotation if your wish.

    package app.views
    @DesignRoot
    class AnimalViewer extends VerticalLayout {
        // ...
    }

Hence by default the class above will look for /app/views/AnimalView.html on the classpath.


 
 
## References
* [Download Grails](https://grails.org/download.html)
* [Book of Vaadin](https://vaadin.com/book/)
* [Vaadin On Grails](http://vaadinongrails.com)