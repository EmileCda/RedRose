package fr.redrose.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import fr.emile.redrose.common.IConstant;
import fr.emile.redrose.enums.Gender;
import fr.emile.redrose.utils.Utils;

public class DataTest implements IConstant {

	private static List<String> firstnameList;
	private static List<String> lastnameList;
	private static List<String> numberTypeList;
	private static List<String> streetNameList;
	private static List<String> cityList;
	private static List<String> streetTypeList;

//---------------------------------------------------------------------------------------------------
	public static String firstName(String gender) {

		Utils.trace(gender);
		if (firstnameList == null) {
			firstnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("FirstName."+gender);
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				firstnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, firstnameList.size() - 1);

		return firstnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String lastname() {
		if (lastnameList == null) {
			lastnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("LastName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				lastnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, lastnameList.size() - 1);

		return lastnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberType() {
		if (numberTypeList == null) {
			numberTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("NumberType");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				numberTypeList.add(value);
			}
		}
		int position = Utils.randInt(0, numberTypeList.size() - 1);

		return numberTypeList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String street() {
		if (streetNameList == null) {
			streetNameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetNameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetNameList.size() - 1);

		return streetNameList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String streetType() {
		if (streetTypeList == null) {
			streetTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetType");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetTypeList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetTypeList.size() - 1);

		return streetTypeList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String city() {
		if (cityList == null) {
			cityList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("CityName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				cityList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, cityList.size() - 1);

		return cityList.get(position);
	}

//---------------------------------------------------------------------------------------------------

	public static String zipcode() {

		return String.format("%05d", Utils.randInt(1000, 99999));
	}

//---------------------------------------------------------------------------------------------------
	public static String number() {

		String numberType = DataTest.numberType();
		if (numberType.equals("")) {
			return String.format("%d", Utils.randInt(0, 999));
		}

		return String.format("%d %s", Utils.randInt(0, 999), numberType);
	}

	// ---------------------------------------------------------------------------------------------------
	public static Date date(Date lowerDate, Date upperDate) {
			
		Date  randomDate=  null; 
		LocalDate  localDate = null; 
		
		LocalDate loDate = Utils.date2localDate(lowerDate);
		LocalDate upDate = Utils.date2localDate(upperDate);
		long periode = loDate.until(upDate, ChronoUnit.DAYS);
		int nbDays = Utils.randInt(0,(int)periode);
		localDate = loDate.plusDays(nbDays);
	
		return Utils.localDate2Date(localDate) ; 
	}

	// ---------------------------------------------------------------------------------------------------
	public static Gender gender() {
		
		Gender[] genderTab = Gender.values();
		
		int genderSize = Gender.values().length;
		
		int genderRendom = Utils.randInt(0, genderSize-2); // do not user last value : Null
		
		
		
		return genderTab[genderRendom] ;
	}

	// ---------------------------------------------------------------------------------------------------
	public static LocalDate localDate(LocalDate lowerDate, LocalDate upperDate) {
//			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		long periode = lowerDate.until(upperDate, ChronoUnit.DAYS);

		int nbDays = Utils.randInt(0, (int) periode);

		Utils.trace(String.format("%s %s %d %d", upperDate.toString(), lowerDate.toString(), periode, nbDays));

		return lowerDate.plusDays(nbDays);
	}

//---------------------------------------------------------------------------------------------------

}
