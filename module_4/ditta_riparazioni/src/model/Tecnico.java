package model;

public class Tecnico {
    private String name;
    private Riparazione repair;
    private StatoTecnico technicianStatus;

    public Tecnico(String name) {
        this.name = name;
        repair = null;
        technicianStatus = StatoTecnico.AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public Riparazione getRepair() {
        return repair;
    }

    public void setRepair(Riparazione repair) {
        this.repair = repair;
    }

    public void setTechnicianStatus(StatoTecnico technicianStatus) {
        this.technicianStatus = technicianStatus;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "name='" + name + '\'' +
                ", repair=" + repair +
                ", technicianStatus=" + technicianStatus +
                '}';
    }
}
