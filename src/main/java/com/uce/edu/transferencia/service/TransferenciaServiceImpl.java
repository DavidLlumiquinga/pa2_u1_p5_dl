package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void elimiar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		 //1. Buscar Cta origen
		CuentaBancaria ctaorigen =this.bancariaRepository.seleccionar(numeroOrigen);
		 //2. Consultar saldo
		 //3. Validar saldo
		 //4. Restar el monto
		 //5. Actualizar Cta origen
		 
		 //6. Buscar Cta destino
		 //7. Consultar saldo
		 //8. Sumar el monto
		 //9. Actualizar cuenta destino
		 //10. Crear la transferencia 
		 
	}

}
