package rongid;

public class main {

	
	public static void startProcess() {

		Route route1 = new Route("marsruut1");
		Route route2 = new Route("marsruut2");
		Route route3 = new Route("marsruut3");
		Route route4 = new Route("marsruut4");
		Route route5 = new Route("marsruut5");
		Route route6 = new Route("marsruut6");
		
		
		// tavaliinid
		TrainStation st1 = new TrainStation("Tallinn");
		TrainStation st2 = new TrainStation("Kehra");
		TrainStation st3 = new TrainStation("Pedja");
		TrainStation st4 = new TrainStation("Tartu");
		route1.addStation(st1);
		route1.addStation(st2);
		route1.addStation(st3);
		route1.addStation(st4);
		
		// tavaliinid
		TrainStation st5 = new TrainStation("Tapa");
		TrainStation st6 = new TrainStation("Rakvere");
		TrainStation st7 = new TrainStation("Oru");
		route2.addStation(st1);
		route2.addStation(st5);
		route2.addStation(st6);
		route2.addStation(st7);
		
		// elektriliinid
		TrainStation st8 = new TrainStation("Tondi");
		TrainStation st9 = new TrainStation("Hiiu");
		TrainStation st10 = new TrainStation("Urda");
		TrainStation st11 = new TrainStation("Keila");
		route3.addStation(st1);
		route3.addStation(st8);
		route3.addStation(st9);
		route3.addStation(st10);
		route3.addStation(st11);
		
		// elektriliinid
		TrainStation st12 = new TrainStation("Vesse");
		TrainStation st13 = new TrainStation("Kulli");
		TrainStation st14 = new TrainStation("Aegviidu");
		route4.addStation(st1);
		route4.addStation(st12);
		route4.addStation(st13);
		route4.addStation(st14);

		// tavaliinid
		TrainStation st15 = new TrainStation("Liiva");
		TrainStation st16 = new TrainStation("Saku");
		TrainStation st17 = new TrainStation("Lohu");
		TrainStation st18 = new TrainStation("Lelle");
		route5.addStation(st1);
		route5.addStation(st15);
		route5.addStation(st16);
		route5.addStation(st17);
		route5.addStation(st18);
		
		// tavaliinid
		TrainStation st19 = new TrainStation("Rebase");
		TrainStation st20 = new TrainStation("Holvandi");
		TrainStation st21 = new TrainStation("Ruusa");
		route6.addStation(st4);
		route6.addStation(st19);
		route6.addStation(st20);
		route6.addStation(st21);

		SingleRail rail1 = new DoubleRail(st1, st2, 100);
		SingleRail rail2 = new SingleRail(st2, st3, 80);
		SingleRail rail3 = new SingleRail(st3, st4, 90);
		route1.addRails(rail1);
		route1.addRails(rail2);
		route1.addRails(rail3);

		SingleRail rail4 = new SingleRail(st5, st6, 105);
		SingleRail rail5 = new SingleRail(st6, st7, 90);
		SingleRail rail16 = new SingleRail(st1, st5, 200);
		route2.addRails(rail16);
		route2.addRails(rail4);
		route2.addRails(rail5);
		
		SingleRail rail6 = new SingleElectricRail(st8, st9, 98);
		SingleRail rail7 = new DoubleElectricRail(st9, st10, 93);
		SingleRail rail8 = new SingleElectricRail(st10, st11, 110);
		SingleRail rail17 = new SingleElectricRail(st1, st8, 70);
		route3.addRails(rail17);
		route3.addRails(rail6);
		route3.addRails(rail7);
		route3.addRails(rail8);
		
		SingleRail rail9 = new SingleElectricRail(st12, st13, 83);
		SingleRail rail10 = new SingleElectricRail(st13, st14, 89);
		SingleRail rail18 = new SingleElectricRail(st1, st12, 80);
		route4.addRails(rail18);
		route4.addRails(rail9);
		route4.addRails(rail10);
		
		SingleRail rail11 = new SingleRail(st15, st16, 120);
		SingleRail rail12 = new SingleRail(st16, st17, 101);
		SingleRail rail13 = new SingleRail(st17, st18, 113);
		SingleRail rail19 = new SingleRail(st1, st15, 90);
		route5.addRails(rail19);
		route5.addRails(rail11);
		route5.addRails(rail12);
		route5.addRails(rail13);
		
		SingleRail rail14 = new SingleRail(st19, st20, 100);
		SingleRail rail15 = new SingleRail(st20, st21, 70);
		SingleRail rail20 = new SingleRail(st4, st19, 110);
		route6.addRails(rail20);
		route6.addRails(rail14);
		route6.addRails(rail15);
		
		
		
		Thread generator1 = new Thread(new PassengerGenerator(route1));
		Thread generator2 = new Thread(new PassengerGenerator(route2));
		Thread generator3 = new Thread(new PassengerGenerator(route3));
		Thread generator4 = new Thread(new PassengerGenerator(route4));
		Thread generator5 = new Thread(new PassengerGenerator(route5));
		Thread generator6 = new Thread(new PassengerGenerator(route6));
		
		
		Passenger inspector1 = new InspectorPassenger();
		Passenger inspector2 = new InspectorPassenger();
		Passenger inspector3 = new InspectorPassenger();

		st1.addPassenger(inspector1);
		st4.addPassenger(inspector2);
		st10.addPassenger(inspector3);


		generator1.start();
		generator2.start();
		generator3.start();
		generator4.start();
		generator5.start();
		generator6.start();
		
		Thread train1 = new Thread(new DieselTrain("nr1", 10, route1));
		Thread train2 = new Thread(new DieselTrain("nr2", 12, route1));
		Thread train3 = new Thread(new DieselTrain("nr3", 11, route2));
		Thread train4 = new Thread(new DieselTrain("nr4", 9, route2));
		Thread train5 = new Thread(new ElectricTrain("nr5", 10, route3));
		Thread train6 = new Thread(new ElectricTrain("nr6", 9, route3));
		Thread train7 = new Thread(new ElectricTrain("nr7", 12, route4));
		Thread train8 = new Thread(new ElectricTrain("nr8", 8, route4));
		Thread train9 = new Thread(new DieselTrain("nr9", 10, route5));
		Thread train10 = new Thread(new DieselTrain("nr10", 12, route5));
		Thread train11 = new Thread(new DieselTrain("nr11", 11, route6));
		Thread train12 = new Thread(new DieselTrain("nr12", 10, route6));
		Thread train13 = new Thread(new ExpressTrain("express1", 4, route1));
		
		Thread train14 = new Thread(new ElectricTrain("nr14", 4, route1));
		train14.start();
		
		
		
		train1.start();
		train2.start();
		train3.start();
		train4.start();
		train5.start();
		train6.start();
		train7.start();
		train8.start();
		train9.start();
		train10.start();
		train11.start();
		train12.start();
		train13.start();
		
	}
	
	public static void main(String[] args) {
		startProcess();
	}
}

