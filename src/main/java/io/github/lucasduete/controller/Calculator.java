/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.lucasduete.controller;

import com.vividsolutions.jts.geom.Geometry;

/**
 * 
 * @author lucasduete
 */
public class Calculator {
    
    public static boolean equalsAB(Geometry a, Geometry b) {
        return a.equals(b);
    }
    
    public static boolean equalsBA(Geometry a, Geometry b) {
        return b.equals(a);
    }
    
    public static boolean disjointAB(Geometry a, Geometry b) {
        return a.disjoint(b);
    }
    
    public static boolean disjointBA(Geometry a, Geometry b) {
        return b.disjoint(a);
    }
    
    public static boolean intersectsAB(Geometry a, Geometry b) {
        return a.intersects(b);
    }
    
    public static boolean intersectsBA(Geometry a, Geometry b) {
        return b.intersects(a);
    }   
    
    public static boolean touchsAB(Geometry a, Geometry b) {
        return a.touches(b);
    }
    
    public static boolean touchsBA(Geometry a, Geometry b) {
        return b.touches(a);
    }
    
    public static boolean crossesAB(Geometry a, Geometry b) {
        return a.crosses(b);
    }
    
    public static boolean crossesBA(Geometry a, Geometry b) {
        return b.crosses(a);
    }
    
    public static boolean withinAB(Geometry a, Geometry b) {
        return a.within(b);
    }
    
    public static boolean withinBA(Geometry a, Geometry b) {
        return b.within(a);
    }
    
    public static boolean containsAB(Geometry a, Geometry b) {
        return a.contains(b);
    }
    
    public static boolean containsBA(Geometry a, Geometry b) {
        return b.contains(a);
    }
    
    public static boolean overlapsAB(Geometry a, Geometry b) {
        return a.overlaps(b);
    }
    
    public static boolean overlapsBA(Geometry a, Geometry b) {
        return b.overlaps(a);
    }
    
    public static boolean coversAB(Geometry a, Geometry b) {
        return a.covers(b);
    }
    
    public static boolean coversBA(Geometry a, Geometry b) {
        return b.covers(a);
    }
    
    public static boolean coveredByAB(Geometry a, Geometry b) {
        return a.coveredBy(b);
    }
    
    public static boolean coveredByBA(Geometry a, Geometry b) {
        return b.coveredBy(a);
    }  
    
}

