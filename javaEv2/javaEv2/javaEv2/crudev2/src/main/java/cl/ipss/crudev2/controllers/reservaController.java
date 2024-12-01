package cl.ipss.crudev2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.crudev2.models.reserva;
import cl.ipss.crudev2.services.mesaService;
import cl.ipss.crudev2.services.reservaService;

@Controller
@RequestMapping("/reserva")
public class reservaController {

    @Autowired
    private reservaService reservaService;
    @Autowired
    private mesaService mesaService;
    @GetMapping
    public String listarreservas(Model model) {
        model.addAttribute("titulo", "Listado de reservas");
        model.addAttribute("reserva", reservaService.listarTodas());
        return "reservaListar";
    }
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearreserva(Model model) {
        model.addAttribute("reserva", new reserva());
        model.addAttribute("mesa", mesaService.listarTodas()); // Cargar todas las mesas disponibles
        return "reservaCrear";
    }

    @PostMapping("/guardar")
    public String guardarreserva(reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reserva";
    }

    @GetMapping("/editar/{id}")
      public String editarreserva(@PathVariable Long id, Model model) {
          model.addAttribute("reserva", reservaService.obtenerPorId(id));
          return "reservaCrear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarreserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reserva";
    }
}