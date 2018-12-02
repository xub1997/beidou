package business.entity;

public enum Protocol {
    JT808("JT808");

    public static final Protocol All[] = {JT808};

    private final String name;

    Protocol(String name) {
        this.name = name;
    }

    public static Protocol forname(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("JT808")){
            return JT808;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
