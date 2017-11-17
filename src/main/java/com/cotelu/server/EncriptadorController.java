package com.cotelu.server;

import com.cotelu.encriptadores.Morse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EncriptadorController {

    @Autowired
    Morse morse;

    @RequestMapping(method = RequestMethod.POST, value = "/cotelu/encripta/morse")
    public String checkNotification(@RequestBody String texto) {
            return morse.encripta(texto);
        }
    }

}
