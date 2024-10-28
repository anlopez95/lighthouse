package com.meli.lighthouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.utils.Constantes;

import java.util.Arrays;
import java.util.List;

public class ConsultaTopSecretRqDTOTest {

    @Test
    public void testTieneMensajesInconsistencias_LongitudInconsistente_LanzaExcepcion() {
    	SatelitesDTO satelite1 = new SatelitesDTO();
        satelite1.setName("Kenobi");
        satelite1.setDistance(100.0);
        satelite1.setMessage(new String[]{"este", "", "un", ""});

        SatelitesDTO satelite2 = new SatelitesDTO();
        satelite2.setName("Skywalker");
        satelite2.setDistance(115.5);
        satelite2.setMessage(new String[]{"", "es", "", "secreto"});

        SatelitesDTO satelite3 = new SatelitesDTO();
        satelite3.setName("Sato");
        satelite3.setDistance(142.7);
        satelite3.setMessage(new String[]{"", "mensaje", ""}); // Longitud diferente
        List<SatelitesDTO> satelitesList = Arrays.asList(satelite1, satelite2, satelite3);
        
        ConsultaTopSecretRqDTO consultaTopSecretRqDTO = new ConsultaTopSecretRqDTO();
        consultaTopSecretRqDTO.setSatelites(satelitesList);

        ExcepcionNegocio exception = Assertions.assertThrows(ExcepcionNegocio.class, consultaTopSecretRqDTO::tieneMensajesInconsistencias);
        Assertions.assertEquals(Constantes.DISTINTA_LONGITUD_MENSAJES, exception.getMessage());
    }
    
    @Test
    public void testTieneMensajesInconsistencias_PalabrasDiferentesMismaPosicion_LanzaExcepcion() {
    	SatelitesDTO satelite1 = new SatelitesDTO();
        satelite1.setName("Kenobi");
        satelite1.setDistance(100.0);
        satelite1.setMessage(new String[]{"este", "", "un", "", ""});

        SatelitesDTO satelite2 = new SatelitesDTO();
        satelite2.setName("Skywalker");
        satelite2.setDistance(115.5);
        satelite2.setMessage(new String[]{"", "es", "", "", "secreto"});

        SatelitesDTO satelite3 = new SatelitesDTO();
        satelite3.setName("Sato");
        satelite3.setDistance(142.7);
        satelite3.setMessage(new String[]{"otro", "es", "un", "", ""}); // Palabra diferente en la misma posición
        List<SatelitesDTO> satelitesList = Arrays.asList(satelite1, satelite2, satelite3);
        
        ConsultaTopSecretRqDTO consultaTopSecretRqDTO = new ConsultaTopSecretRqDTO();
        consultaTopSecretRqDTO.setSatelites(satelitesList);

        ExcepcionNegocio exception = Assertions.assertThrows(ExcepcionNegocio.class, consultaTopSecretRqDTO::tieneMensajesInconsistencias);
        String expectedMessage = String.format(Constantes.MENSAJE_PALABRAS_DUPLICIDAD, 0, "[este, otro]");
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    
    }
    
}

