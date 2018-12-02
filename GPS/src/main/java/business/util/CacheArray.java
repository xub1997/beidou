package business.util;

import java.util.ArrayList;
import java.util.List;

public class CacheArray<T> {

    public CacheArray(){super();}

    private List<T> list = new ArrayList<T>();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
