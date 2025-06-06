package Java;

import java.util.HashMap;

public final class Immutable {
    private final int id;
    private final String name;
    private final HashMap<String,String> testMap;

    public int getId() { return id; }
    public String getName() { return name; }

    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();  // returning cloned copy of actual object
    }

    public Immutable(int i, String n, HashMap<String,String> hm){
        this.id=i;
        this.name=n;
        HashMap<String, String> tempMap = new HashMap<>(hm); // performing deep copy of hm
        this.testMap=tempMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");
        String s = "original";
        int i=10;
        Immutable ce = new Immutable(i,s,h1);
        System.out.println("ce id: "+ce.getId());
        System.out.println("ce name: "+ce.getName());
        System.out.println("ce testMap: "+ce.getTestMap());
        i=20; // change the local variable values
        s="modified";
        h1.put("3", "third");
        System.out.println("ce id after local variable change: "+ce.getId());
        System.out.println("ce name after local variable change: "+ce.getName());
        System.out.println("ce testMap after local variable change: "+ce.getTestMap());
        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");
        System.out.println("ce testMap after changing variable from getter methods: "+ce.getTestMap());

    }

}
