package com;

import dao.CityDAOIMPL;
import dao.HospitalDAOIMPL;
import entity.City;
import entity.Hospital;

/**
 * Created by User on 20.09.2018.
 */
public class Testing {
    public static void main(String[] args) {
        CityDAOIMPL city = new CityDAOIMPL();

        city.delete(0);

        City paris = new City(4, "Prilep",58.456);

        //city.update(paris);

        HospitalDAOIMPL hospitalDAOIMPL = new HospitalDAOIMPL();

        hospitalDAOIMPL.delete(0);

        Hospital hospital = new Hospital(6,"Voena", "Karposh", "drzhavna", 2);

        hospitalDAOIMPL.insert(hospital);





    }

    }

