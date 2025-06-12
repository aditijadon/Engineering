package Java.record;

public record Rectangle(int length, int width) implements Shape {
    public Rectangle {
        if(length <= 0 || width <= 0){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int area(){
        return length*width;
    }
}

/* EQUIVALENT CLASS FOR RECORD  for (record Point(int x, int y) {}

    public final class Point implements Shape{
        private final int length;
        private final int width;

        public Point(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public int getLength() {
            return length;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return length == rectangle.length && y == rectangle.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(length, width);
        }

        @Override
        public String toString() {
            return "Rectangle[length=" + length + ", width=" + width + "]";
        }
    }
*/

