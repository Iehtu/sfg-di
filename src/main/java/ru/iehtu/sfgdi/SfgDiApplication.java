package ru.iehtu.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ru.iehtu.pets.PetController;
import ru.iehtu.sfgdi.controllers.ConstructorInjectedController;
import ru.iehtu.sfgdi.controllers.I18nController;
import ru.iehtu.sfgdi.controllers.MyController;
import ru.iehtu.sfgdi.controllers.PropertyInjectorController;
import ru.iehtu.sfgdi.controllers.SetterInjectedController;
import ru.iehtu.sfgdi.services.LifeCycleDemoBean;


@ComponentScan(basePackages={"ru.iehtu.sfgdi","ru.iehtu.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SfgDiApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		LifeCycleDemoBean bean = ctx.getBean(LifeCycleDemoBean.class);

		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController)ctx.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println("-------- Property");
		PropertyInjectorController propertyInjectorController = (PropertyInjectorController)ctx.getBean("propertyInjectorController");
		System.out.println(propertyInjectorController.getGreeting());

		System.out.println("-------- Setter");
		SetterInjectedController  setterInjectedController  = (SetterInjectedController)ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		PetController petController = (PetController)ctx.getBean("petController");
		System.out.println(petController.petName());
	}

}
