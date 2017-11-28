package io.github.lucasduete.controller;

import com.vividsolutions.jts.geom.Geometry;
import io.github.lucasduete.recourse.SVGFactory;
import io.github.lucasduete.recourse.ViewBox;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PNGFactory {
    
    public static File GenerateSVG(Geometry a, Geometry b) {
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//ENG\" \"http://www.w3c.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        
        ViewBox vb = new ViewBox(a, b);
        
        builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" "
                + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"400\" height=\"400\"");
        builder.append("viewBox=\"");
        builder.append(vb.getViewBox());
        builder.append("\">");
        
        builder.append("<desc>Desenho das Coordenadas</desc>");
        builder.append("<title>Desenho</title>");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(a));
        builder.append("\" stroke=\"black\" stroke-width=\"5\" stroke-opacity=\"1\" fill=\"red\" fill-opacity=\"1\" />");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(b));
        builder.append("\" stroke=\"black\" stroke-width=\"5\" stroke-opacity=\"1\" fill=\"blue\" fill-opacity=\"1\" />");
        
        builder.append("</svg>");
        
        File file = new File("teste.svg");
        try {
            file.createNewFile();
        
            BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileWriter(file, true), true));
            
            writer.write(builder.toString());
            writer.close();
        } catch (Exception fodasse) {
            fodasse.printStackTrace();
        }
        
        
        return file;
    }

}

