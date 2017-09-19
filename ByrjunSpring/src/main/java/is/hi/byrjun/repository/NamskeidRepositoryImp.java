package is.hi.byrjun.repository;

import is.hi.byrjun.model.Namskeid;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NamskeidRepositoryImp implements NamskeidRepository {
    private final List<Namskeid> namskeid;

    public NamskeidRepositoryImp() {
        this.namskeid = new ArrayList<Namskeid>();
        this.namskeid.add( new Namskeid("test1", "test1"));
        this.namskeid.add( new Namskeid("test2", "test2"));
        this.namskeid.add( new Namskeid("test3", "test3"));

    }

    @Override
    public List<Namskeid> getAll() {
        return namskeid;
    }

    @Override
    public void add(Namskeid namskeid) {
        this.namskeid.add(namskeid);
    }
}

