import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Location {
    double x;
    double y;

    Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Driver {
    String name;
    String id;
    Location currentLocation;
    boolean alreadyHasOrder;

    Driver(String name, String id, Location currentLocation, boolean alreadyHasOrder) {
        this.name = name;
        this.id = id;
        this.currentLocation = currentLocation;
        this.alreadyHasOrder = alreadyHasOrder;
    }
}

class Menu {
    String name;
    int price;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void tampilkanMenu() {
        System.out.println(name + " " + price); // Menambahkan spasi antara nama dan harga
    }
}

class OrderDetails {
    Menu menu;
    int count;

    public OrderDetails(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }
}

class Customer {
    String name;
    Location currentLocation;
    int balance;

    public Customer(String name, Location currentLocation, int balance) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.balance = balance;
    }
}

class History {
    static final int MAX_HISTORY = 20;
    static OrderDetails[] history = new OrderDetails[MAX_HISTORY];
    static int countHistory = 0;

    public static void addHistory(OrderDetails order) {
        if (countHistory < MAX_HISTORY) {
            history[countHistory++] = order;
        }
    }

    public static void printHistory() {
        System.out.println("ORDER HISTORY");
        if (countHistory == 0) {
            System.out.println("Belum ada riwayat pesanan.");
            return;
        }
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DDD, dd MM yyyy hh:mm");
        int totalSemuaPesanan = 0;

        for (int i = 0; i < countHistory; i++) {
            OrderDetails order = history[i];
            int totalHarga = order.menu.price * order.count;
            totalSemuaPesanan += totalHarga;
            System.out.println("Date: " + waktuSekarang.format(formatter) +
                    ", Items: " + order.count +
                    ", Total: " + totalHarga);
        }
        System.out.println("TOTAL: " + totalSemuaPesanan);
    }
}

public class TP_245150207111028_MeylisaPutriVeramita_2 {
    static final int MAX_ORDER_DETAILS = 20;
    static final int MAX_DRIVERS = 10;
    static final int MAX_MENUS = 10;
    static OrderDetails[] orderDetails = new OrderDetails[MAX_ORDER_DETAILS];
    static int countOrderDetails = 0;
    static Driver[] drivers = new Driver[MAX_DRIVERS];
    static int countDriver = 0;
    static Menu[] menus = new Menu[MAX_MENUS];
    static int countMenus = 0;

    public static boolean addMenu(String name, int price) {
        for (int i = 0; i < countMenus; i++) {
            if (menus[i].name.equalsIgnoreCase(name)) {
                return false;
            }
        }
        if (countMenus < MAX_MENUS) {
            menus[countMenus] = new Menu(name, price);
            countMenus++;
            return true;
        } else {
            return false;
        }
    }

    public static void removeMenuByName(String name) {
        for (int i =  0; i < countMenus; i++) {
            if (menus[i].name.equalsIgnoreCase(name)) {
                menus[i] = menus[--countMenus];
                menus[countMenus] = null;
                return;
            }
        }
    }

    public static Menu findMenuByName(String name) {
        for (int i = 0; i < countMenus; i++) {
            if (menus[i].name.equalsIgnoreCase(name)) {
                return menus[i];
            }
        }
        return null;
    }

    public static void addOrderDetails(String name, int count) {
        Menu menu = findMenuByName(name);
        if (menu != null && countOrderDetails < MAX_ORDER_DETAILS) {
            orderDetails[countOrderDetails++] = new OrderDetails(menu, count);
        }
    }

    public static boolean removeOrderDetailsByName(String name) {
        for (int i = 0; i < countOrderDetails; i++) {
            if (orderDetails[i].menu.name.equalsIgnoreCase(name)) {
                orderDetails[i] = orderDetails[--countOrderDetails];
                orderDetails[countOrderDetails] = null;
                return true;
            }
        }
        return false;
    }

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static Driver findNearestDriver(Customer cust, Driver[] drivers) {
        Driver terdekat = null;
        double maxJarak = Double.MAX_VALUE;

        for (int i = 0; i < countDriver; i++) {
            if (!drivers[i].alreadyHasOrder) {
                double jarak = euclideanDistance(
                    cust.currentLocation.x, cust.currentLocation.y,
                    drivers[i].currentLocation.x, drivers[i].currentLocation.y
                );
                if (jarak < maxJarak) {
                    maxJarak = jarak;
                    terdekat = drivers[i];
                }
            }
        }
        return terdekat;
    }

    public static int getOrderDetailsTotal() {
        int total = 0;
        for (int i = 0; i < countOrderDetails; i++) {
            total += orderDetails[i].menu.price * orderDetails[i].count;
        }
        return total;
    }

    public static void viewOrders() {
        System.out.println("ORDER:");
        int totalHarga = 0;
        for (int i = 0; i < countOrderDetails; i++) {
            OrderDetails order = orderDetails[i];
            int hargaTotal = order.menu.price * order.count;
            totalHarga += hargaTotal;
            System.out.println(order.menu.name + " " + order.count + " = " + hargaTotal);
        }
        System.out.println("TOTAL = " + totalHarga);
    }

    public static void displayMenus() {
        System.out.println("MENU:");
        for (int i = 0; i < countMenus; i++) {
            System.out.println(menus[i].name + " " + menus[i].price);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalHistori, countItem, balance, totalTagihan = 0;
        boolean siapAntar = false;

        String namaPembeli = input.nextLine();
        balance = input.nextInt();
        double xPembeli = input.nextDouble();
        double yPembeli = input.nextDouble();
        input.nextLine();
        Location lokPembeli = new Location(xPembeli, yPembeli);
        Customer dataPembeli = new Customer(namaPembeli, lokPembeli, balance);

        while (true) {
            String perintah = input.next();
            input.nextLine();
            switch (perintah) {
                case "PRINT_CUST":
                    System.out.printf("%s @ %.1f %.1f\n", namaPembeli, xPembeli, yPembeli);
                    break;

                case "ADD_DRIVER":
                    String namaDriver = input.nextLine();
                    String id = input.nextLine();
                    double xDriver = input.nextDouble();
                    double yDriver = input.nextDouble();
                    Location lokDriver = new Location(xDriver, yDriver);
                    drivers[countDriver++] = new Driver(namaDriver, id, lokDriver, false);
                    break;

                case "ADD_MENU":
                    String nameMenu = input.nextLine();
                    int harga = input.nextInt();
                    addMenu(nameMenu, harga);
                    break;

                case "REMOVE_MENU":
                    String remove = input.nextLine();
                    removeMenuByName(remove);
                    break;

                case "PRINT_MENU":
                    displayMenus();
                    break;

                case "ADD_ORDER":
                    String menuPesanan = input.nextLine();
                    int jumlahPesanan = input.nextInt();
                    addOrderDetails(menuPesanan, jumlahPesanan);
                    break;

                case "REMOVE_ORDER":
                    String orderDihapus = input.nextLine();
                    if (removeOrderDetailsByName(orderDihapus)) {
                        System.out.println(orderDihapus + " IS DEDUCTED/REMOVED");
                    } else {
                        System.out.println(orderDihapus + " IS NOT EXISTS");
                    }
                    break;

                case "PRINT_ORDER":
                    viewOrders();
                    break;

                case "CHECKOUT_DELIVER":
                    totalTagihan = getOrderDetailsTotal();
                    if (balance < totalTagihan) {
                        System.out.println("BALANCE IS NOT ENOUGH TO PROCEED");
                    } else if (countOrderDetails == 0) {
                        System.out.println("MAKE AN ORDER FIRST");
                    } else {
                        Driver driverTerdekat = findNearestDriver(dataPembeli, drivers);
                        if (driverTerdekat != null) {
                            double jarakTerdekat = euclideanDistance(driverTerdekat.currentLocation.x, driverTerdekat.currentLocation.y, xPembeli, yPembeli);
                            if (jarakTerdekat > 5) {
                                System.out.println("NO DRIVER NEARBY AVAILABLE");
                            } else {
                                System.out.println("ORDER IS PLACED AND WILL BE DELIVERED BY " + driverTerdekat.name + " " + jarakTerdekat);
                                driverTerdekat.alreadyHasOrder = true;
                                balance -= totalTagihan;
                                siapAntar = true;
                            }
                        }
                    }
                    break;

                case "FINISH_DELIVER":
                    if (siapAntar) {
                        System.out.println("FOOD IS DELIVERED. BALANCE = " + balance);
                        siapAntar = false;
                    } else if (countOrderDetails == 0) {
                        System.out.println("MAKE AN ORDER FIRST");
                    } else {
                        System.out.println("ORDER IS NOT CHECKED OUT");
                    }
                    break;

                case "TOPUP":
                    System.out.print("Enter amount to top up: ");
                    int topup = input.nextInt();
                    System.out.println("BALANCE " + balance + " -> " + (balance + topup));
                    balance += topup;
                    break;

                case "PRINT_HISTORY":
                    History.printHistory();
                    break;
                default:
                    break;
            }
        }
    }
} 