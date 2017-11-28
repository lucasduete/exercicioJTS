package io.github.lucasduete.controller;

import com.vividsolutions.jts.geom.Geometry;
import io.github.lucasduete.recourse.SVGFactory;
import io.github.lucasduete.recourse.ViewBox;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class ImageFactory {
    
    private static final String NAME_FILE = "Desenho";
    
    public static File GeneratePNG(Geometry a, Geometry b) {
        
        
        String svg_URI_input = null;
        TranscoderInput input_svg_image = null;
        OutputStream png_ostream = null;
        TranscoderOutput output_png_image = null;
        
        try {
            svg_URI_input = Paths.get(NAME_FILE + ".svg").toUri().toURL().toString();
            input_svg_image = new TranscoderInput(svg_URI_input); 
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        }
                
        
        try {
            png_ostream = new FileOutputStream(NAME_FILE + ".png");
            output_png_image = new TranscoderOutput(png_ostream); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }        
        
        PNGTranscoder my_converter = new PNGTranscoder();    
        try {
            my_converter.transcode(input_svg_image, output_png_image);
        } catch (TranscoderException ex) {
            
        }
        
        return new File(NAME_FILE + ".png");
    }
    
    public static File GenerateSVG(Geometry a, Geometry b) {
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//ENG\" \"http://www.w3c.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        
        ViewBox vb = new ViewBox(a, b);
        
        builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" "
                + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"400\" height=\"400\"");
        builder.append(" viewBox=\"");
        builder.append(vb.getViewBox());
        builder.append("\">");
        
        builder.append("<desc>Desenho das Coordenadas</desc>");
        builder.append("<title>Desenho</title>");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(a));
        builder.append("\" fill-opacity=\"1\" />");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(b));
        builder.append("\" fill=\"blue\" fill-opacity=\"1\" />");
        
        builder.append("</svg>");
        
        File file = new File(NAME_FILE + ".svg");
        try {
            if (file.exists()) 
                file.delete();
            
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

