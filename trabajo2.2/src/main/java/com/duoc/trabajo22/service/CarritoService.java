package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Carrito;
import com.duoc.trabajo22.repository.CarritoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
class CarritoService {

    CarritoRepository carritoRepository;

    private Carrito crear(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito obtenerPorId(int id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    public List<Carrito> obtenerTodos() {
        return (List<Carrito>) carritoRepository.findAll();
    }

    public Carrito actualizar(int id, Carrito carritoActualizado) {
        Carrito carritoExistente = obtenerPorId(id);
        carritoExistente.setId(carritoActualizado.getId());
        carritoExistente.setCantidad(carritoActualizado.getCantidad());
        carritoExistente.setUsuario(carritoActualizado.getUsuario());
        return carritoRepository.save(carritoExistente);
    }
}
