import org.junit.*;
import static org.junit.Assert.assertEquals;

public class Tests {
	@Test
	public void testEntries() {
		DatasetCar data = new DatasetCar("../../../car.data.txt");
		NN nn = new NN(data);
		String carClass = "";

		carClass = nn.getNearestNeighbour(new int[]{0,0,0,1,1,1}); //vhigh,vhigh,2,4,med,med,unacc
		assertEquals("Classe esperada UNNAC, mas recebida: "+carClass, "UNACC", carClass);
		
		carClass = nn.getNearestNeighbour(new int[]{0,0,1,1,1,0}); //vhigh,vhigh,3,4,med,low,unacc
		assertEquals("Classe esperada UNACC, mas recebida: "+carClass, "UNACC", carClass);

		carClass = nn.getNearestNeighbour(new int[]{0,0,3,2,0,2}); //vhigh,vhigh,5more,more,small,high,unacc
		assertEquals("Classe esperada UNACC, mas recebida: "+carClass, "UNACC", carClass);

		carClass = nn.getNearestNeighbour(new int[]{3,3,3,1,2,2}); //low,low,5more,4,big,high,vgood
		assertEquals("Classe esperada VGOOD, mas recebida: "+carClass, "VGOOD", carClass);

		carClass = nn.getNearestNeighbour(new int[]{2,0,0,1,1,2}); //med,vhigh,2,4,med,high,acc
		assertEquals("Classe esperada ACC, mas recebida: "+carClass, "ACC", carClass);

		carClass = nn.getNearestNeighbour(new int[]{2,2,0,1,2,2}); //med,med,2,4,big,high,vgood
		assertEquals("Classe esperada VGOOD, mas recebida: "+carClass, "VGOOD", carClass);

		carClass = nn.getNearestNeighbour(new int[]{2,3,0,1,0,2}); //med,low,2,4,small,high,good
		assertEquals("Classe esperada GOOD, mas recebida: "+carClass, "GOOD", carClass);
	}
}