package laiCode.polymorphismP17;

public class Practice17_2 {
    // 1）哪些函数能调用取决于前面 ReferenceType   ——  compile time
    // 2）对于被 Override 的函数，调用哪个版本，取决于 ImplementedType  —— runtime
    public static void main(String[] args) {
        OrdinaryPeople Nate = new OrdinaryPeople();
        Nate.eat();
        RichPeople Anna = new RichPeople();
        Anna.eat();
        //Anna.eatBetter();   // Anna can .eatBetter() method
        OrdinaryPeople Sun = new RichPeople();
        Sun.eat();   //❤️ Sun cannot .eatBetter() method
    }

    static class OrdinaryPeople {
        public void eat() {
            System.out.println("吃土...");
        }
        public void doLaicode () {
            System.out.println("LaiCode 300 ?");
        }
    }

    static class RichPeople extends OrdinaryPeople {
        @Override
        public void eat() {
            eatBetter();
        }
        public void eatBetter() {
            System.out.println("吃龙虾");
        }

    }
}
