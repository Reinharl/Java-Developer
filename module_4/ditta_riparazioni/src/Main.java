import model.DittaRiparazioni;

public class Main {
    public static void main(String[] args) {
        DittaRiparazioni dittaRiparazioni = new DittaRiparazioni();
        dittaRiparazioni.addRepairs("Via Rossi", 1);
        dittaRiparazioni.addRepairs("Via Neri", 3);
        dittaRiparazioni.addRepairs("Via Verdi", 2);

        System.out.println(dittaRiparazioni.pendingRepairs());
        System.out.println(dittaRiparazioni.priorityRepair());

        dittaRiparazioni.addTechnician("Mario Rossi");
        dittaRiparazioni.addTechnician("Giulio Verdi");

        dittaRiparazioni.addRepairToTechnician("Via Verdi", "Mario Rossi");

        System.out.println(dittaRiparazioni);

        dittaRiparazioni.repairCompleted("Mario Rossi");

        System.out.println(dittaRiparazioni);

        dittaRiparazioni.onVacation(new String[] {"Mario Rossi", "Giulio Verdi"});

        System.out.println(dittaRiparazioni);
    }

}
