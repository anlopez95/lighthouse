package com.meli.lighthouse;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.service.imp.PosicionamientoService;
import com.meli.lighthouse.utils.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.awt.Point;
import static org.mockito.Mockito.*;

public class PosicionamientoServiceTest {

    @InjectMocks
    private PosicionamientoService posicionamientoService;

    @Mock
    private ConsultaTopSecretRqDTO consultaTopSecretRqDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPosicion_Exitoso() throws ExcepcionNegocio {
        // Arrange: Configuramos la entrada con datos de tres satélites.
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
        satelite3.setMessage(new String[]{"", "", "", "mensaje", ""});

        List<SatelitesDTO> satelitesList = Arrays.asList(satelite1, satelite2, satelite3);
        when(consultaTopSecretRqDTO.getSatelites()).thenReturn(satelitesList);

        // Act: Llamamos al método GetPosicion con los datos de prueba.
        ConsultaTopSecretRsDTO resultado = posicionamientoService.GetPosicion(consultaTopSecretRqDTO);

        // Assert: Comprobamos que los valores de resultado son los esperados.
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(-487, resultado.getPosition().getX());
        Assertions.assertEquals(1557, resultado.getPosition().getY());
        Assertions.assertEquals("este es un mensaje secreto", resultado.getMessage());
    }

    @Test
    public void testGetPosicion_DatosInsuficientes_LanzaExcepcion() {
        // Arrange: Configuramos la entrada con datos insuficientes (menos de 3 satélites).
        SatelitesDTO satelite1 = new SatelitesDTO();
        satelite1.setName("Kenobi");
        satelite1.setDistance(100.0);
        satelite1.setMessage(new String[]{"este", "", "un", "", ""});

        List<SatelitesDTO> satelitesList = Arrays.asList(satelite1);
        when(consultaTopSecretRqDTO.getSatelites()).thenReturn(satelitesList);

        // Act & Assert: Comprobamos que se lanza la excepción ExcepcionNegocio.
        ExcepcionNegocio exception = Assertions.assertThrows(ExcepcionNegocio.class, () -> {
            posicionamientoService.GetPosicion(consultaTopSecretRqDTO);
        });

        Assertions.assertEquals(Constantes.DATOS_INSUFICIENTES, exception.getMessage());
    }

}
