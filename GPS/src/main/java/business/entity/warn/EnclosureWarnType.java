package business.entity.warn;

public enum EnclosureWarnType {
    INWARN("INWARN"),
    OUTWARN("OUTWARN");

    public static final EnclosureWarnType[] ALL = {INWARN, OUTWARN};

    private final String name;

    EnclosureWarnType(String name){this.name = name;}

    public static EnclosureWarnType forName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("INWARN")){
            return INWARN;
        }else if(name.toUpperCase().equals("OUTWARN")){
            return OUTWARN;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() { return name; }

    @Override
    public String toString() { return getName(); }

}
