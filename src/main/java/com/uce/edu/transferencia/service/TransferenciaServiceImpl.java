package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

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
		// 1. Buscar Cta origen
		CuentaBancaria ctaOrigen = this.bancariaRepository.seleccionar(numeroOrigen);
		// 2. Consultar saldo
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();

		// 3. Validar saldo
		if (saldoOrigen.compareTo(monto) >= 0) {
			// 4. Restar el monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			// 5. Actualizar Cta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualizar(ctaOrigen);
			// 6. Buscar Cta destino
			CuentaBancaria ctaDestino = this.bancariaRepository.seleccionar(numeroDestino);
			// 7. Consultar saldo
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			// 8. Sumar el monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			// 9. Actualizar cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(ctaDestino);
			// 10. Crear la transferencia
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero("123123");

			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("Transferencia realizada con exito");
		} else {
			System.out.println("Saldo no disponible");
		}

	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		
		return this.iTransferenciaRepository.seleccionarTodos();
	}

}
