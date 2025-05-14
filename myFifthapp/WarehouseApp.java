package pl.pp;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(1, 5000, "Default Owner", "default@warehouse.com", "+48 000 000 000");

        warehouse.addGoods(3000);
        warehouse.removeGoods(1000);
        warehouse.addGoods(2500);
        warehouse.checkOccupancy();
        warehouse.updateContact("owner@magazyn.pl", "+48 123 456 789");
        warehouse.addGoods(1000); // This should display: Not enough space
    }
}

class Warehouse {
    private int warehouseNumber;
    private int totalSpace;
    private int occupiedSpace;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;

    // Constructor
    public Warehouse(int warehouseNumber, int totalSpace, String ownerName, String ownerEmail, String ownerPhone) {
        this.warehouseNumber = warehouseNumber;
        this.totalSpace = totalSpace;
        this.occupiedSpace = 0;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
    }

    // Getters and Setters
    public int getWarehouseNumber() { return warehouseNumber; }
    public void setWarehouseNumber(int warehouseNumber) { this.warehouseNumber = warehouseNumber; }

    public int getTotalSpace() { return totalSpace; }
    public void setTotalSpace(int totalSpace) { this.totalSpace = totalSpace; }

    public int getOccupiedSpace() { return occupiedSpace; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public String getOwnerPhone() { return ownerPhone; }
    public void setOwnerPhone(String ownerPhone) { this.ownerPhone = ownerPhone; }

    // Methods
    public void addGoods(int amount) {
        if (occupiedSpace + amount <= totalSpace) {
            occupiedSpace += amount;
            System.out.println("Added " + amount + " units of goods. Remaining warehouse space: " + (totalSpace - occupiedSpace) + " units.");
        } else {
            System.out.println("Not enough space in the warehouse. Remaining warehouse space: " + (totalSpace - occupiedSpace) + " units.");
        }
    }

    public void removeGoods(int amount) {
        if (amount <= occupiedSpace) {
            occupiedSpace -= amount;
            System.out.println("Removed " + amount + " units of goods. Remaining warehouse space: " + (totalSpace - occupiedSpace) + " units.");
        } else {
            System.out.println("Not enough goods in the warehouse to remove. Currently occupied space: " + occupiedSpace + " units.");
        }
    }

    public void checkOccupancy() {
        System.out.println("Occupied warehouse space: " + occupiedSpace + " units.");
        System.out.println("Available warehouse space: " + (totalSpace - occupiedSpace) + " units.");
    }

    public void updateContact(String newEmail, String newPhone) {
        this.ownerEmail = newEmail;
        this.ownerPhone = newPhone;
        System.out.println("Owner's contact details updated.");
        System.out.println("New email: " + ownerEmail);
        System.out.println("New phone number: " + ownerPhone);
    }
}





