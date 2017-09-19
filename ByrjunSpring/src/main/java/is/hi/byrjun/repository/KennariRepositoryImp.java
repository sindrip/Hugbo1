/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.byrjun.repository;

import is.hi.byrjun.model.Kennari;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ebba Þóra Hvannberg 
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * 
 * Safn af kennurum 
 */
@Repository
public class KennariRepositoryImp implements KennariRepository{

    // Listi af kennurum 
    private final List<Kennari> kennarar;

    public KennariRepositoryImp() {
        this.kennarar = new ArrayList<Kennari>();
    }
    
    
    @Override
    public List<Kennari> getAll() {
        return kennarar; 
    }

    @Override
    public void add (Kennari kennari) {
        kennarar.add(kennari);
    }

}
