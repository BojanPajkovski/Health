package com;

import entity.Doctor;
import service.CityService;
import service.DoctorService;
import service.HospitalService;
import service.PatientService;

import java.util.Map;

/**
 * Created by User on 04.10.2018.
 */
public class Testing3 {

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        HospitalService hospitalService = new HospitalService();
        CityService cityService = new CityService();
        DoctorService doctorService = new DoctorService();


        /*patientService.printTheTheYoungestStudentIfEven();

        patientService.getOldestPatientDg(1);

        hospitalService.getHospitalType(1);*/
        /*patientService.getPatientsOver30();*/
       // patientService.getPatientCharacters(8);

       // cityService.getCityPopulationMax();
       Map<Integer, Doctor> doctorMap = doctorService.getDoctorsWithHospital(1);
        for (Integer key: doctorMap.keySet()){

            System.out.println(doctorMap.get(key).getName());

        }

    }
}
