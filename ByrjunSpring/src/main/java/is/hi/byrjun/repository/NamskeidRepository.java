package is.hi.byrjun.repository;

import is.hi.byrjun.model.Namskeid;

import java.util.List;

public interface NamskeidRepository {

    List<Namskeid> getAll();

    void add (Namskeid namskeid);
}
