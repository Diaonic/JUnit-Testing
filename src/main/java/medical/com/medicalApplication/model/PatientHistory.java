package medical.com.medicalApplication.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * This class represents a patient history model in the system
 *
 */
public class PatientHistory {

	private List<Treatment> treatments;
	private List<Medication> medications;
	private List<Allergy> allergy;

	public PatientHistory() {
		this.treatments = new ArrayList<Treatment>();
		this.medications = new ArrayList<Medication>();
		this.allergy = new ArrayList<Allergy>();
	}

	public void addTreatment(Treatment providedTreatment) {
		treatments.add(providedTreatment);
	}

	public void addAllergy(Allergy providedAllergy) {
		allergy.add(providedAllergy);
	}

	public void addMedication(Medication providedMedication) {
		if(treatments != null){
			medications.add(providedMedication);
		}
	}

	public List<Allergy> getAllergies() {
		return allergy;
	}

	public List<Treatment> getAllTreatments() {
		return treatments;
	}

	public List<Medication> getAllMedications() {
		return medications;
	}

}
