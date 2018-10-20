package medical.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import medical.com.medicalApplication.model.TestAllergy;
import medical.com.medicalApplication.model.TestDoctor;
import medical.com.medicalApplication.model.TestEmployee;
import medical.com.medicalApplication.model.TestMedicalRecord;
import medical.com.medicalApplication.model.TestMedication;
import medical.com.medicalApplication.model.TestPatient;
import medical.com.medicalApplication.model.TestPatientHistory;
import medical.com.medicalApplication.model.TestTreatment;
import medical.com.medicalApplication.services.TestDoctorService;
import medical.com.medicalApplication.services.TestMedicalRecordService;

@RunWith(Suite.class)
@SuiteClasses({ TestAllergy.class, TestDoctor.class, TestEmployee.class, TestMedicalRecord.class, TestMedication.class,
		TestPatient.class, TestPatientHistory.class, TestTreatment.class, TestDoctorService.class, TestMedicalRecordService.class })
public class AllTests {

}
