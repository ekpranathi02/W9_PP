import java.util.Scanner;

abstract class Ticket {
    static final double FEE = 20.0;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getAmount() {
        return (getPrice() + FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }
}

public class W9_PP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket t;

            switch (seat) {
                case "REGULAR":
                    t = new Regular(count);
                    break;
                case "PREMIUM":
                    t = new Premium(count);
                    break;
                case "RECLINER":
                    t = new Recliner(count);
                    break;
                default:
                    continue;
            }

            double amount = t.getAmount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}