package com.example.fundamentosspring.fundamentos.Bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyMessengeImplement implements MyMessenge{

    private final Log LOGGER = LogFactory.getLog(MyMessengeImplement.class);

    @Override
    public String saludaPersona(String persona) {
        LOGGER.info("El logger va hasta aquí");
        return "Hola "+persona;
    }
}
