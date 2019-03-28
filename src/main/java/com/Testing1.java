package com;

import dao.CityDAOIMPL;
import dao.DoctorDAOIMPL;
import dao.HospitalDAOIMPL;
import entity.Doctor;
import entity.Hospital;
import model.PatientsPerDoctorDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 23.09.2018.
 */
public class Testing1 {

    public static void main(String[] args) throws SQLException {

        HospitalDAOIMPL hospitalDAOIMPL = new HospitalDAOIMPL();
        CityDAOIMPL cityDAOIMPL = new CityDAOIMPL();
        DoctorDAOIMPL doctorDAOIMPL = new DoctorDAOIMPL();
        //cityDAOIMPL.insert(new City( "New York", 2000000.00));
        //cityDAOIMPL.update(new City(5, "Dubai last update", 100030203.00));



        Doctor doctor = doctorDAOIMPL.getById(1);

        System.out.println(doctor.getName());

       /* List<PatientsPerDoctorDTO> patientsPerDoctors = doctorDAOIMPL.getPatientsByDoctor(1);

        System.out.println(patientsPerDoctors.get(0).getDoctorName());


        List<Hospital> hospitals = hospitalDAOIMPL.getHospitalsByLocation("Centar");

        System.out.println(hospitals.size());

        hospitalDAOIMPL.getAll();*/



        //System.out.println());

       /* List<Hospital> hospitals = hospitalDAOIMPL.getAll();

        System.out.println(hospitals.size());

        System.out.println(hospitalDAOIMPL.getById(1).getName());*/

    }
}
