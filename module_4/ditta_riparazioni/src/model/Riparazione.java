package model;

public class Riparazione {
    private String address;
    private int priority;
    private StatoRiparazione repairStatus;

    public Riparazione(String address, int priority) {
        this.address = address;
        this.priority = priority;
        repairStatus = StatoRiparazione.PENDING;
    }

    public String getAddress() {
        return address;
    }

    public int getPriority() {
        return priority;
    }

    public StatoRiparazione getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(StatoRiparazione repairStatus) {
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return "Riparazione{" +
                "address='" + address + '\'' +
                ", priority=" + priority +
                ", repairStatus=" + repairStatus +
                '}';
    }
}
