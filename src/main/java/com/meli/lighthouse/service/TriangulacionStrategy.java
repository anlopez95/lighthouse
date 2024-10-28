package com.meli.lighthouse.service;

import java.awt.Point;
import java.awt.geom.Point2D;

public interface TriangulacionStrategy {
    Point triangulate(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, double r1, double r2, double r3);
}
