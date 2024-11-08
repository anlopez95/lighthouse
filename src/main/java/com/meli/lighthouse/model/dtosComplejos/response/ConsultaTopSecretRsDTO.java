package com.meli.lighthouse.model.dtosComplejos.response;

import lombok.Data;

@Data
public class ConsultaTopSecretRsDTO {
	
	private Position position;
    private String message;

    public ConsultaTopSecretRsDTO(double x, double y, String message) {
        this.position = new Position(x, y);
        this.message = message;
    }

    public ConsultaTopSecretRsDTO() {
	}

	// Clase anidada para representar la posición
    public static class Position {
        private double x;
        private double y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

        
    }

}
