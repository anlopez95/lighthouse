package com.meli.lighthouse.service.imp;

import java.awt.Point;
import java.awt.geom.Point2D;

import org.springframework.stereotype.Component;

import com.meli.lighthouse.service.TriangulacionStrategy;
import com.meli.lighthouse.utils.Triangulacion;

@Component
public class TriangulacionImpl implements TriangulacionStrategy {
    @Override
    public Point triangulate(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, double r1, double r2, double r3) {
        return Triangulacion.trilateracion(p1, p2, p3, r1, r2, r3);
    }
}

