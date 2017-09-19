/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.byrjun.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author Ebba Þóra Hvannberg
 */
@Service
public class DaginnServiceImp implements DaginnService{

    @Override
    public boolean erNafnRett(String nafn) {
        return true;
    }
    
}
