package fr.emile.redrose.test;


import java.util.Date;

import fr.emile.redrose.enums.Gender;
import fr.emile.redrose.utils.Utils;
import fr.redrose.entity.DataTest;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gender gender = DataTest.gender();

		Date startDate = Utils.string2Date("25/06/1965","dd/MM/yyyy");
		Date endDate = Utils.string2Date("25/06/2023","dd/MM/yyyy");
		Utils.trace(String.format("%s %s %s: %s, %s %s %s %s. née le : %s ",
				gender.getTitle(),
				DataTest.firstName(gender.getValue()),
				DataTest.lastname(),
				DataTest.number(),
				DataTest.streetType(),
				DataTest.street(),
				DataTest.zipcode(),
				DataTest.city(),
				Utils.date2String(DataTest.date(startDate,endDate),"dd/MM/yyyy"))
				);
		
		
		
		
		
	}

}
