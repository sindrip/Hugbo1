package is.hi.byrjun.services;

import is.hi.byrjun.model.Namskeid;

import java.util.List;

public interface NamskeidService {

    public List<Namskeid> allNamskeid();

    public List<Namskeid> searchNamskeid(String val);

}
