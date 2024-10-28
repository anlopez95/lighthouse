package com.meli.lighthouse;

import com.meli.lighthouse.controller.ObtenerUbicacionController;
import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ObtenerUbicacionControllerTest {

    @InjectMocks
    private ObtenerUbicacionController obtenerUbicacionController;

    @Mock
    private IPosicionamientoSerive posicionamientoService;

    private ConsultaTopSecretRqDTO consultaTopSecretRqDTO;
    private ConsultaTopSecretRsDTO consultaTopSecretRsDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        consultaTopSecretRqDTO = new ConsultaTopSecretRqDTO();
        consultaTopSecretRsDTO = new ConsultaTopSecretRsDTO();
        // Inicializa tus DTOs según sea necesario
    }

    @Test
    public void testObtenerUbicacion_Success() throws ExcepcionNegocio {
        // Arrange
        when(posicionamientoService.GetPosicion(consultaTopSecretRqDTO)).thenReturn(consultaTopSecretRsDTO);

        // Act
        ResponseEntity<ConsultaTopSecretRsDTO> response = obtenerUbicacionController.obtenerUbicacion(consultaTopSecretRqDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(consultaTopSecretRsDTO, response.getBody());
    }

    @Test
    public void testObtenerUbicacion_ExcepcionNegocio() throws ExcepcionNegocio {
        // Arrange
        when(posicionamientoService.GetPosicion(consultaTopSecretRqDTO)).thenThrow(new ExcepcionNegocio("Error", HttpStatus.BAD_REQUEST));

        // Act & Assert
        ExcepcionNegocio exception = Assertions.assertThrows(ExcepcionNegocio.class, () -> {
            obtenerUbicacionController.obtenerUbicacion(consultaTopSecretRqDTO);
        });

        // Aquí puedes verificar el mensaje de error, el código de estado, etc.
        assertEquals("Error", exception.getMessage());
    }
}