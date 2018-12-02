package business.entity.warn;

public enum  EnclosureType {
    CIRCLE("CIRCLE"),
    RECTANGLE("RECTANGLE"),
    POLYGON("POLYGON");

    public static final EnclosureType[] ALL = {CIRCLE, RECTANGLE, POLYGON};

    private final String name;

    EnclosureType(String name){this.name = name;}

    public static EnclosureType forName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("CIRCLE")){
            return CIRCLE;
        }else if(name.toUpperCase().equals("RECTANGLE")){
            return RECTANGLE;
        }else if(name.toUpperCase().equals("POLYGON")){
            return POLYGON;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() { return name; }

    @Override
    public String toString() { return getName(); }

}
