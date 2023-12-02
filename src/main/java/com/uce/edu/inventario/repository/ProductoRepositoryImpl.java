package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Producto;
@Repository
public class ProductoRepositoryImpl implements IProductoRepository{

	private static List<Producto> base = new ArrayList<Producto>();
	@Override
	public Producto seleccionar(String codigoBarras) {
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				Producto prod = new Producto();
				prod.setCodigoBarras(producto.getCodigoBarras());
				prod.setNombre(producto.getNombre());
				prod.setStock(producto.getStock());
				return producto;
			}
		}
		return null;
	}
	
	public Producto seleccionarEliminar(String codigo) {

		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigo)) {

				return producto;
			}
		}
		return null;
	}

	@Override
	public void insertar(Producto producto) {
		base.add(producto);
		
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.eliminar(producto.getCodigoBarras());
		this.insertar(producto);

	}

	@Override
	public void eliminar(String codigoBarras) {
		// TODO Auto-generated method stub
		Producto producto = this.seleccionarEliminar(codigoBarras);
		base.remove(producto);
	}

}
