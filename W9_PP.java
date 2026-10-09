import java.util.Scanner;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return getPower() * hours / 1000.0;
    }

    double getCost() {
        return getUnits() * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    double getSaverUnits() {
        return getUnits() * SAVER_FACTOR;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    double getSaverUnits() {
        return getUnits() * SAVER_FACTOR;
    }
}

public class W9_PP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                saver = remaining.equalsIgnoreCase("SAVER");
            }

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.getUnits();

            if (saver) {
                units *= 0.75;
            }

            double cost = units * 8.0;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}