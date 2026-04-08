class HillPlace {
    void food() {
        System.out.println("Common hill station dishes");
    }

    void specialty() {
        System.out.println("Famous for natural beauty");
    }
}

class Shimla extends HillPlace {
    void food() {
        System.out.println("Shimla Food: Chana Madra");
    }

    void specialty() {
        System.out.println("Shimla is famous for colonial architecture and snow");
    }
}

class Darjeeling extends HillPlace {
    void food() {
        System.out.println("Darjeeling Food: Momos");
    }

    void specialty() {
        System.out.println("Darjeeling is famous for tea and Kanchenjunga views");
    }
}

class Coorg extends HillPlace {
    void food() {
        System.out.println("Coorg Food: Pandi Curry");
    }

    void specialty() {
        System.out.println("Coorg is famous for coffee plantations and hills");
    }
}

public class HillDemo {
    public static void main(String[] args) {
        HillPlace ref;

        ref = new Shimla();
        ref.food();
        ref.specialty();

        ref = new Darjeeling();
        ref.food();
        ref.specialty();

        ref = new Coorg();
        ref.food();
        ref.specialty();
    }
}
