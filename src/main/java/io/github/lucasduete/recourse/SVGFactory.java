
package io.github.lucasduete.recourse;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class SVGFactory {
   
    public static String getSVG (Geometry geometria) {
        
        StringBuilder builder = new StringBuilder();
        
        Coordinate[] coordenadas = geometria.getCoordinates();
        
        builder.append("M");
        builder.append(" ");
        builder.append(coordenadas[0].x);
        builder.append(" ");
        builder.append(coordenadas[0].y);
        
        builder.append(" ");
        
        for(Coordinate c: coordenadas) {
            builder.append("L");
            builder.append(" ");
            builder.append((Double) c.x);
            builder.append(" ");
            builder.append((Double) c.y);
            builder.append(" ");
        }
        
        builder.append("Z");
        
        return builder.toString();        
    }
}

