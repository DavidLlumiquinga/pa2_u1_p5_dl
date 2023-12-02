package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5DlApplication implements CommandLineRunner {


	@Autowired 
	private IProductoService iProductoService;
	@Autowired
	private IBodegaService iBodegaService;
	@Autowired
	private IInventarioService iInventarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p1=new Producto();
		p1.setCodigoBarras("123456");
		p1.setNombre("HP 15 Laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2=new Producto();
		p2.setCodigoBarras("654321");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		
		this.iProductoService.guardar(p2);

		
		Bodega bodega=new Bodega();
		bodega.setCapacidad(20);
		bodega.setCodigo("789456");
		bodega.setDireccion("San Rafael");
		bodega.setNombre("SuperAnimo");
		this.iBodegaService.guardar(bodega);
		
		
		this.iInventarioService.registrar("654321", "123456", 50);
		this.iInventarioService.registrar("654321", "654321", 100);
		this.iInventarioService.registrar("654321", "123456", 20);
		
		
		Producto num1=this.iProductoService.buscar("123456");
		System.out.println("Producto 1"+num1.getStock());
		
		Producto num2=this.iProductoService.buscar("654321");
		System.out.println("Producto 1"+num2.getStock());
		
	}

}
