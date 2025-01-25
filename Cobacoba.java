import java.util.Scanner;

class Location {
    double x;
    double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Driver {
    String name;
    String id;
    Location currentLocation;
    boolean alreadyHasOrder;

    public Driver(String name, String id, Location location, boolean alreadyHasOrder) {
        this.name = name;
        this.id = id;
        this.currentLocation = location;
        this.alreadyHasOrder = alreadyHasOrder;
    }
}

class Menu {
    String name;
    int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
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

    public Customer(String name, Location location, int balance) {
        this.name = name;
        this.currentLocation = location;
        this.balance = balance;
    }
}

public class Cobacoba {
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
        if (countMenus < MAX_MENUS) {
            menus[countMenus] = new Menu(name, price);
            countMenus++;
            return true;
        }
        return false;
    }

    public static void removeMenuByName(String name) {
        for (int i = 0; i < countMenus; i++) {
            if (menus[i].name.equals(name)) {
                menus[i] = menus[--countMenus];
                menus[countMenus] = null;
                return;
            }
        }
    }

    public static Menu findMenuByName(String name) {
        for (int i = 0; i < countMenus; i++) {
            if (menus[i].name.equals(name)) {
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
            if (orderDetails[i].menu.name.equals(name)) {
                orderDetails[i] = orderDetails[--countOrderDetails];
                orderDetails[countOrderDetails] = null;
                return true;
            }
        }
        return false;
    }

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static Driver findNearestDriver(Customer cust, Driver[] drivers) {
        Driver nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < countDriver; i++) {
            if (!drivers[i].alreadyHasOrder) {
                double distance = euclideanDistance(
                        cust.currentLocation.x, cust.currentLocation.y,
                        drivers[i].currentLocation.x, drivers[i].currentLocation.y
                );
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = drivers[i];
                }
            }
        }
        return nearest;
    }

    public static int getOrderDetailsTotal() {
        int total = 0;
        for (int i = 0; i < countOrderDetails; i++) {
            total += orderDetails[i].menu.price * orderDetails[i].count;
        }
        return total;
    }

    public static void displayMenus() {
        if (countMenus == 0) {
            System.out.println("Belum ada menu yang tersedia.");
        } else {
            System.out.println("=== Daftar Menu ===");
            for (int i = 0; i < countMenus; i++) {
                System.out.println((i + 1) + ". " + menus[i].name + " - Rp" + menus[i].price);
            }
        }
    }   
    
    public static void viewOrders() {
        System.out.println("=== Daftar Pesanan ===");
        if (countOrderDetails == 0) {
            System.out.println("Belum ada pesanan.");
            return;
            }
            
        int totalHarga = 0;
        for (int i = 0; i < countOrderDetails; i++) {
            OrderDetails order = orderDetails[i];
            int hargaTotal = order.menu.price * order.count;
            totalHarga += hargaTotal;
            System.out.println((i + 1) + ". " + order.menu.name + 
                                   " - Jumlah: " + order.count + 
                                   " - Harga Total: Rp" + hargaTotal);
        }
            System.out.println("Total Semua Pesanan: Rp" + totalHarga);
    }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
    
            while (running) {
                System.out.println("\n=== Sistem Pemesanan ===");
                System.out.println("1. Tambah Menu");
                System.out.println("2. Hapus Menu");
                System.out.println("3. Lihat Menu");
                System.out.println("4. Tambah Driver");
                System.out.println("5. Tambah Pesanan");
                System.out.println("6. Lihat Total Pesanan");
                System.out.println("7. Cari Driver Terdekat");
                System.out.println("8. Lihat Pesanan");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline
    
                switch (choice) {
                    case 1:
                        System.out.print("Nama Menu: ");
                        String menuName = scanner.nextLine();
                        System.out.print("Harga Menu: ");
                        int price = scanner.nextInt();
                        addMenu(menuName, price);
                        System.out.println("Menu berhasil ditambahkan.");
                        break;
                    case 2:
                        System.out.print("Nama Menu yang akan dihapus: ");
                        String menuToDelete = scanner.nextLine();
                        removeMenuByName(menuToDelete);
                        System.out.println("Menu berhasil dihapus.");
                        break;
                    case 3:
                        displayMenus();
                        break;
                    case 4:
                        System.out.print("Nama Driver: ");
                        String driverName = scanner.nextLine();
                        System.out.print("ID Driver: ");
                        String driverId = scanner.nextLine();
                        System.out.print("Lokasi X: ");
                        double driverX = scanner.nextDouble();
                        System.out.print("Lokasi Y: ");
                        double driverY = scanner.nextDouble();
                        drivers[countDriver++] = new Driver(driverName, driverId, new Location(driverX, driverY), false);
                        System.out.println("Driver berhasil ditambahkan.");
                        break;
                    case 5:
                        System.out.print("Nama Menu: ");
                        String orderMenuName = scanner.nextLine();
                        System.out.print("Jumlah Pesanan: ");
                        int orderCount = scanner.nextInt();
                        addOrderDetails(orderMenuName, orderCount);
                        System.out.println("Pesanan berhasil ditambahkan.");
                        break;
                    case 6:
                        System.out.println("Total biaya pesanan: " + getOrderDetailsTotal());
                        break;
                    case 7:
                        System.out.print("Nama Pelanggan: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Lokasi X Pelanggan: ");
                        double customerX = scanner.nextDouble();
                        System.out.print("Lokasi Y Pelanggan: ");
                        double customerY = scanner.nextDouble();
                        Customer customer = new Customer(customerName, new Location(customerX, customerY), 0);
                        Driver nearestDriver = findNearestDriver(customer, drivers);
                        if (nearestDriver != null) {
                            System.out.println("Driver terdekat: " + nearestDriver.name + " (ID: " + nearestDriver.id + ")");
                        } else {
                            System.out.println("Tidak ada driver tersedia.");
                        }
                        break;
                    case 8:
                        viewOrders();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan sistem.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
    
            scanner.close();
        }
    }
    