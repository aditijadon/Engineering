package Java.record;

public class Driver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3,4);
        Rectangle r2 = new Rectangle(4,8);
        Rectangle r3 = new Rectangle(3,4);

        System.out.println(r1);
        System.out.println("length: " + r1.length() + " width: " + r1.width());
        System.out.println(r1.equals(r2));
        System.out.println(r1.hashCode() == r2.hashCode());
        System.out.println(r1.equals(r3));
        System.out.println(r1.hashCode() == r3.hashCode());

        try{
            Rectangle r4 = new Rectangle(-4,2);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Area :" + r1.area());
    }
}
