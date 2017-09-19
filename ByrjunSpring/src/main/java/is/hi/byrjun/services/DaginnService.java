/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.byrjun.services;

/**
 * @author Ebba Þóra Hvannberg 
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 */
public interface DaginnService {
    /**
     * Athugar hvort nafn er á réttu formi, þ.e. verða að vera
     * a.m.k. tvö orð.
     * @param nafn
     * @return skilar satt ef nafn er á réttu formi annars ósatt
     */
    public boolean erNafnRett(String nafn); 
}
