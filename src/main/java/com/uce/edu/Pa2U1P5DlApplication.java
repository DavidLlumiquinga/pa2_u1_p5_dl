package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5DlApplication implements CommandLineRunner {

	//DI por atributo
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;

	/*
	 * DI for constructor
	 * @Autowired public Pa2U1P5DlApplication(ITransferenciaService iTransServi) {
	 * this.iTransferenciaService=iTransServi; }
	 */

	/*
	 * DI for metodo set()
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1.Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1725689611");
		ctaOrigen.setNumero("12345");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.bancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1725456895");
		ctaDestino.setNumero("654321");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.bancariaService.guardar(ctaDestino);

		this.bancariaService.depositar("12345", new BigDecimal(200));
		System.out.println(ctaOrigen);

		this.iTransferenciaService.realizar("12345", "654321", new BigDecimal(50));

		this.iTransferenciaService.realizar("12345", "654321", new BigDecimal(30));
		this.iTransferenciaService.realizar("654321", "12345", new BigDecimal(10));

		// Construir un estado de cuenta de todas las transferencia

		List<Transferencia> lista = new ArrayList<>();
		int indice = 0;
		for (Transferencia trans : lista) {

			indice++;
			System.out.println(indice + " : " + trans);
		}
		CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("12345");
		System.out.println(ctaOrigen1);
		CuentaBancaria ctaDestino1 = this.bancariaService.buscar("654321");
		System.out.println(ctaDestino1);

	}

}
