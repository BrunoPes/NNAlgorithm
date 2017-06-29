import java.util.*;

public class NN {
	private DatasetCar data;

	public NN(DatasetCar data) {
		this.data = data;
	}

	private String getNearestNeighbour(int[] vector) {
		Car nearest = new Car();
		ArrayList<Car> cars = this.data.getDataset();
		int[] vetCar;
		double distance = 0;
		double minorDist = -1;
		for(Car car : cars) {
			distance = this.getDistance(vector, car.getAttributes());
			if(minorDist == -1 || distance < minorDist) {
				minorDist = distance;
				nearest = car;
			}
		}
		
		CarClass carClass = nearest.getCarClass();
		System.out.print("O vetor de atributos de carro ");
		for(int i=0; i<vector.length; i++) System.out.print(" "+vector[i]);
		System.out.print("Provavelmente é um " + carClass.toString());

		return nearest.getCarClass().toString();
	}

	private double getDistance(int[] vetA, int[] vetB) {
		try {
			if(vetA.length == vetB.length) {
				double diff = 0;
				double sum = 0;
				for(int i=0; i<vetA.length; i++) {
					diff = Integer.valueOf(Math.abs(vetA[i]-vetB[i])).doubleValue();
					sum += Math.pow(diff, new Double("2"));
				}
				
				return Math.sqrt(sum);
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}


	public static void main(String[] args) {
		DatasetCar data = new DatasetCar();
		NN nnObject = new NN(data);
		nnObject.getNearestNeighbour(new int[]{2,2,2,2,2,0});
	}
}