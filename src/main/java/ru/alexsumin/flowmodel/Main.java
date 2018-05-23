package ru.alexsumin.flowmodel;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.alexsumin.flowmodel.views.AuthorizationView;



@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launch(Main.class, AuthorizationView.class, args);
	}
}

