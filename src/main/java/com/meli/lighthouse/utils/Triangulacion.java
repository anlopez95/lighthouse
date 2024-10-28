package com.meli.lighthouse.utils;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Triangulacion {
	
	
	public static Point trilateracion(Point2D.Double p1,Point2D.Double p2,Point2D.Double p3, double r1, double r2, double r3) {
		
		// Calculamos (x, y) resolviendo el sistema de ecuaciones de trilateracion (Calculo de posicion usando geometria de triangulos)
        // Formula de ejemplo: (x−x1)^2+(y−y1)^2 = d^2
        double A = 2 * p2.x - 2 * p1.x;
        double B = 2 * p2.y - 2 * p1.y;
        double C = Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(p1.x, 2) + Math.pow(p2.x, 2) - Math.pow(p1.y, 2) + Math.pow(p2.y, 2);
        double D = 2 * p3.x - 2 * p2.x;
        double E = 2 * p3.y - 2 * p2.y;
        double F = Math.pow(r2, 2) - Math.pow(r3, 2) - Math.pow(p2.x, 2) + Math.pow(p3.x, 2) - Math.pow(p2.y, 2) + Math.pow(p3.y, 2);

        double x = (C * E - F * B) / (E * A - B * D);
        double y = (C * D - A * F) / (B * D - A * E);

		return new Point((int) x, (int) y);
	}

}
