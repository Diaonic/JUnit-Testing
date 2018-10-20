package medical.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import medical.com.medicalApplication.services.TestDoctorService;
import medical.com.medicalApplication.services.TestMedicalRecordService;

@RunWith(Suite.class)
@SuiteClasses({ TestDoctorService.class, TestMedicalRecordService.class })
public class AllServiceTests {

}
