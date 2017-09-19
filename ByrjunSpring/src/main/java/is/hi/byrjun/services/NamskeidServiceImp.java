package is.hi.byrjun.services;

import is.hi.byrjun.model.Namskeid;
import is.hi.byrjun.repository.NamskeidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamskeidServiceImp implements NamskeidService {

    @Autowired
    NamskeidRepository namskeidRep;

    @Override
    public List<Namskeid> namskeid() {
        return namskeidRep.getAll();
    }
}
