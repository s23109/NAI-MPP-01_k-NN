public class Object_info implements Comparable<Object_info>{

    Integer id;
    String name ;
    double distance;

    public Object_info(Integer id, String name, double distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(Object_info o) {
        if (this.distance>o.distance) return 1;
        else if (this.distance<o.distance ) return -1;
        return 0;

    }
}
