package model;

public class DittaRiparazioni {
    private ListaDiTecnici technicians;
    private ListaDiRiparazioni repairs;

    public DittaRiparazioni() {
        technicians = new ListaDiTecnici();
        repairs = new ListaDiRiparazioni();
    }

    public void addRepairs(String address, int priority) {
        Riparazione repair = new Riparazione(address, priority);
        repairs.add(repair);
    }

    public ListaDiRiparazioni pendingRepairs() {
        ListaDiRiparazioni pendingRepairs = new ListaDiRiparazioni();

        for (int i = 0; i < repairs.length(); i++) {
            if (repairs.get(i).getRepairStatus().equals(StatoRiparazione.PENDING)) {
                pendingRepairs.add(repairs.get(i));
            }
        }

        return pendingRepairs;
    }

    public Riparazione priorityRepair() {
        if (repairs.length() != 0) {
            int max = 0;

            for (int i = 1; i < repairs.length(); i++) {
                if (repairs.get(max).getPriority() < repairs.get(i).getPriority() && repairs.get(i).getRepairStatus().equals(StatoRiparazione.PENDING)) {
                    max = i;
                }
            }

            return repairs.get(max);
        }

        return null;
    }

    public void addRepairToTechnician(String address, String name) {
        if (repairs.contains(address) && technicians.contains(name)) {
            int indexTechnician = technicians.indexOf(name);
            int indexRepairs = repairs.indexOf(address);

            repairs.get(indexRepairs).setRepairStatus(StatoRiparazione.ONGOING);
            technicians.get(indexTechnician).setTechnicianStatus(StatoTecnico.AT_WORK);

            technicians.get(indexTechnician).setRepair(repairs.get(indexRepairs));
        }
    }

    public void repairCompleted(String name) {
        if (technicians.contains(name)) {
            int indexTechnician = technicians.indexOf(name);
            int indexRepairs = repairs.indexOf(technicians.get(indexTechnician).getRepair().getAddress());

            technicians.get(indexTechnician).setTechnicianStatus(StatoTecnico.AVAILABLE);
            repairs.get(indexRepairs).setRepairStatus(StatoRiparazione.CONCLUDED);
        }
    }

    public void addTechnician(String name) {
        if (!technicians.contains(name)) {
            Tecnico technician = new Tecnico(name);
            technicians.add(technician);
        }
    }

    public void onVacation(String[] name) {
        for (String s : name) {
            onVacation(s);
        }
    }

    private void onVacation(String name) {
        if (technicians.contains(name)) {
            int indexTechnician = technicians.indexOf(name);

            if (technicians.get(indexTechnician).getRepair() != null && technicians.get(indexTechnician).getRepair().getRepairStatus().equals(StatoRiparazione.ONGOING)) {
                int indexRepairs = repairs.indexOf(technicians.get(indexTechnician).getRepair().getAddress());

                repairs.get(indexRepairs).setRepairStatus(StatoRiparazione.PENDING);
                technicians.get(indexTechnician).setRepair(null);
            }

            technicians.get(indexTechnician).setTechnicianStatus(StatoTecnico.ON_VACATION);
        }
    }

    @Override
    public String toString() {
        return "DittaRiparazioni{" +
                "technicians=" + technicians +
                ", repairs=" + repairs +
                '}';
    }
}
