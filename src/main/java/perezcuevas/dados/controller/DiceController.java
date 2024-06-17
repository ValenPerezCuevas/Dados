package perezcuevas.dados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class DiceController {
    // Endpoint para recibir las solicitudes de tirar dados
    @GetMapping("/")
    public String lanzarDado(@RequestParam(name="tipoDado", required=false, defaultValue="6") String tipoDado, Model model) {
        int carasDado = Integer.parseInt(tipoDado);
        model.addAttribute("resultado", tirarDado(carasDado));
        return "dado";
    }

    // Método para simular la tirada de dado
    private int tirarDado(int caras) {
        return new Random().nextInt(caras) + 1;
    }
}
