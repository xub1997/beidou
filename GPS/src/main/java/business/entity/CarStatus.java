package business.entity;

public enum CarStatus {
    ONLINE("ONLINE"),
    POSITIONING("POSITIONING"),
    OFFLINE("OFFLINE");

    public static final CarStatus ALL[]={ONLINE,POSITIONING,OFFLINE};

    private final String name;

    private CarStatus(String name){this.name = name;}

    public static CarStatus forname(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("ONLINE")){
            return ONLINE;
        }else if(name.toUpperCase().equals("POSITIONING")){
            return POSITIONING;
        }else if (name.toUpperCase().equals("OFFLINE")){
            return OFFLINE;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
