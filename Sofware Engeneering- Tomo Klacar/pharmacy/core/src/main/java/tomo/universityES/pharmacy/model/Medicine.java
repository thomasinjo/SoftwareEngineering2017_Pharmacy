package tomo.universityES.pharmacy.model;

import tomo.universityES.pharmacy.model.helpClasses.Availability;

public class Medicine {
    private final String medicineName;
    private Availability availability;

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability getAvailability() {
        return availability;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public Medicine(String medicineName, Availability availability) {
        this.medicineName = medicineName;
        this.availability = availability;
    }
}
