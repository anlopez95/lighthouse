package com.meli.lighthouse;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.utils.Constantes;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class SatelitesDTOTest {

    private final Validator validator;

    public SatelitesDTOTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testNombreNoPuedeSerNulo() {
        SatelitesDTO satelite = new SatelitesDTO();
        satelite.setDistance(100.0);
        satelite.setMessage(new String[]{"mensaje"});

        Set<ConstraintViolation<SatelitesDTO>> violations = validator.validate(satelite);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream()
                .anyMatch(violation -> violation.getMessage().equals("El nombre del satélite es obligatorio")));
    }

    @Test
    public void testDistanciaNoPuedeSerNulo() {
        SatelitesDTO satelite = new SatelitesDTO();
        satelite.setName("Kenobi");
        satelite.setMessage(new String[]{"mensaje"});

        Set<ConstraintViolation<SatelitesDTO>> violations = validator.validate(satelite);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream()
                .anyMatch(violation -> violation.getMessage().equals("La distancia es obligatoria")));
    }

    @Test
    public void testMensajeNoPuedeSerVacio() {
        SatelitesDTO satelite = new SatelitesDTO();
        satelite.setName("Kenobi");
        satelite.setDistance(100.0);
        satelite.setMessage(new String[]{});

        Set<ConstraintViolation<SatelitesDTO>> violations = validator.validate(satelite);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertTrue(violations.stream()
                .anyMatch(violation -> violation.getMessage().equals("El mensaje es obligatorio y no puede estar vacío")));
    }

    @Test
    public void testTieneCamposNulos() {
        SatelitesDTO satelite = new SatelitesDTO();
        satelite.setMessage(new String[]{"mensaje"});
        Assertions.assertTrue(satelite.tieneCamposNulos());

        satelite.setName("Kenobi");
        satelite.setDistance(100.0);
        Assertions.assertFalse(satelite.tieneCamposNulos());
    }

    @Test
    public void testTieneValoresPorDefecto() {
        SatelitesDTO satelite = new SatelitesDTO();
        satelite.setName("");
        satelite.setMessage(new String[]{});
        Assertions.assertTrue(satelite.tieneValoresPorDefecto());

        satelite.setName("Kenobi");
        satelite.setMessage(new String[]{"mensaje"});
        Assertions.assertFalse(satelite.tieneValoresPorDefecto());
    }
    
}

