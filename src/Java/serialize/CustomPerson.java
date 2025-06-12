package Java.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomPerson implements Serializable {
    private String name;
    private transient int age;

    public CustomPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize non-transient fields
        out.writeInt(age + 10); // Customize serialization of age
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize non-transient fields
        this.age = in.readInt() - 10; // Customize deserialization of age
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
}
