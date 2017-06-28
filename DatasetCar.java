import java.io.*;
import java.util.*;

public class DatasetCar {
	private ArrayList<Car> cars;

	public void readDatasetFile(String path) {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
	}


}


class Car {
	private Buying buyingPrice;
	private Maint maintPrice;
	private Doors doorsNumber;
	private Persons personsNumber;
	private Luggage luggageVolume;
	private Safety safety;

	private CarClass class;

	public Car(String[] attrs) {

	}
}


public enum Buying  {
	V_HIGH, HIGH, MED, LOW;
	public static Buying get(int index) {return Buying.values()[index];}
}
public enum Maint   {
	V_HIGH, HIGH, MED, LOW;
	public static Maint get(int index) {return Maint.values()[index];}
}
public enum Doors   {
	2, 3, 4, 5_MORE;
	public static Doors get(int index) {return Doors.values()[index];}
}
public enum Persons {
	2, 4, MORE;
	public static Persons get(int index) {return Persons.values()[index];}
}
public enum Luggage {
	SMALL, MED, BIG;
	public static Luggage get(int index) {return Luggage.values()[index];}
}
public enum Safety  {
	LOW, MED, HIGH;
	public static Safety get(int index) {return Safety.values()[index];}
}
public enum CarClass  {
	UNACC, ACC, GOOD, V_GOOD;
	public static Safety get(int index) {return Safety.values()[index];}
}