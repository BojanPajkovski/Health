package com;

import dao.CityDAOIMPL;
import dao.DoctorDAOIMPL;
import dao.HospitalDAOIMPL;
import dao.PatientDAOIMPL;
import entity.City;
import entity.Doctor;
import entity.Hospital;
import entity.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.09.2018.
 */
public class Testing2 {

    public static void main(String[] args) {

        PatientDAOIMPL patientDAOIMPL = new PatientDAOIMPL();
        HospitalDAOIMPL hospitalDAOIMPL = new HospitalDAOIMPL();
        DoctorDAOIMPL doctorDAOIMPL = new DoctorDAOIMPL();
        CityDAOIMPL cityDAOIMPL = new CityDAOIMPL();

        List<Patient> patientList = new ArrayList<Patient>();
        List<Doctor> doctors = new ArrayList<Doctor>();
        List<City> cities = new ArrayList<City>();
        List<Hospital> hospitals = new ArrayList<Hospital>();


        /*patientList = patientDAOIMPL.searchPatientByText("n");

        System.out.println(patientList.get(0).getName());

        doctors = doctorDAOIMPL.searchDoctorsByText("pa");

        System.out.println(doctors.size());

        cities = cityDAOIMPL.searchCityByText("pr");

        System.out.println(cities.get(0).getName());

        hospitals = hospitalDAOIMPL.searchHospitalByText("centar");

        System.out.println(hospitals.size());

        System.out.println(patientDAOIMPL.getYoungestPatient().getName());
        hospitals = hospitalDAOIMPL.getHospitapByCity(1);
        System.out.println(hospitals.size());

*/
        System.out.println(doctorDAOIMPL.getDoctorsByHospitalId(2).size());

    }
}
