package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class Pa2U1P5DlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Soy David Llumiquinga");
		System.out.println("Programacion Avanzada 2");
		System.out.println("Uso del github");
		System.out.println("Parte 2");
		System.out.println("Cambio en el branch");
		System.out.println("CAMBIO");
	}

}

/*Crear un proyecto nuevo subir 
 * Crea cambio y subir al branch
 * Crear cambio en nuevo branch
 * 
 */
