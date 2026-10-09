import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getExtraFee() {
        return 0.0;
    }

    double getFee() {
        double fee = getTuition() + getExtraFee();

        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0;
    }

    double getExtraFee() {
        return 60000.0;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000.0;
    }
}

public class W9_PP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = s.getFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}