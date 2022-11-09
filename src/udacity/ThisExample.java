package udacity;

public final class ThisExample {
    // this keyword inside the lambda references the enclosing class, which is "class advance.ThisExample"
    private final Runnable withLambda = () -> System.out.println("From lambda: " + this.getClass());

    /*
    *  For the Runnable subclass, on the other hand, the program printed "class advance.ThisExample$1".
    *  You can see that the Java compiler generated a class called "class advance.ThisExample$1". for the anonymous lambda (yes, the class name contains a dollar sign),
    *  and the this keyword refers to that generated class! If you compile this program yourself, you'll even notice the Java compiler produces a file called "ThisExample$1.class", which contains the compiled byte code for the anonymous class.
     * */
    private final Runnable withSubclass = new Runnable() {
        @Override
        public void run() {
            System.out.println("From subclass: " + this.getClass());
        }
    };

    public static void main(String[] args) {
        ThisExample thisExample = new ThisExample();
        thisExample.withLambda.run();    // From lambda: class advance.ThisExample
        thisExample.withSubclass.run();  // From subclass: class advance.ThisExample$1
    }
}
