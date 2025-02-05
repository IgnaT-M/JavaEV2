package cl.ipss.crudev2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudev2.models.mesa;
import cl.ipss.crudev2.repositories.mesaRepository;




@Service
public class mesaService {

    @Autowired
    private mesaRepository mesaRepository;

    public List<mesa> listarTodas(){
        return mesaRepository.findAll();
    }

    public mesa guardar(mesa mesa) {
        return mesaRepository.save(mesa);
    }   
   
    public mesa obtenerPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }
}