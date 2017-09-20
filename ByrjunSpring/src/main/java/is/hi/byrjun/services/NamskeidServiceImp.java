package is.hi.byrjun.services;

import is.hi.byrjun.model.Namskeid;
import is.hi.byrjun.repository.NamskeidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NamskeidServiceImp implements NamskeidService {

    @Autowired
    NamskeidRepository namskeidRep;

    @Override
    public List<Namskeid> allNamskeid() {
        return namskeidRep.getAll();
    }

    @Override
    public List<Namskeid> searchNamskeid(String val) {
        ArrayList<Namskeid> listi = new ArrayList<Namskeid>();
        listi.add(new Namskeid("test1", "test1"));
        return listi;
    }
}
