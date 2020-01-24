package rongid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ElectricTrain extends DieselTrain implements Runnable{

	
	public ElectricTrain(String name, int maximumPassengerCount, Route route){
		super(name, maximumPassengerCount, route);
	}
	
	@Override
	public boolean isElectric(){
		return true;
	}
	
	@Override
	public void run() {
		TrainSchedule schedule = new TrainSchedule();
		for (int i = 0; i < getRoute().getStationSize(); i++){
			schedule.addStation(getRoute().getStationById(i));
			if (i>0){
				schedule.addTime(getRoute().getRail(i-1).getTime());
			}
		}
		for (int i = getRoute().getStationSize()-2; i > -1 ;i--){
			schedule.addStation(getRoute().getStationById(i));
			schedule.addTime(getRoute().getRail(i).getTime());
		}
		
		int position = 0;
		int tripCount = 0;
		boolean canDrive = true;
		
		while(tripCount < 6 && canDrive){
			int gotOn = 0;
			int gotOff = 0;
			boolean isInspector = false;
			try {
				for(int k = 0; k<schedule.getStationSize()-1; k++){
					gotOn = 0;
					gotOff = 0;
					isInspector = false;
					if(passengers.size() > 0){
						for(int i = 0; i < passengers.size(); i++){
							if(passengers.get(i).getDestination() == schedule.getStation(position).getName()){
								schedule.getStation(position).addPassenger(passengers.get(i));
								passengers.remove(i);
								gotOff++;
							}
						}
					}
					trainArrival(schedule.getStation(position).getName(), gotOff);
	
					for(int i = 0; i < passengers.size(); i++){
						if(passengers.get(i).isInspector()){
							isInspector = true;
						}
					}
					
					if(isInspector){
						int stowawayChance;
						for(int i = 0; i < passengers.size(); i++){
							stowawayChance = random.nextInt(100) + 1;
							if(!passengers.get(i).hasTicket() && stowawayChance < 71){
								try{
						             String content = "Kontrol�r p��dis kinni j�nest s�itvat reisijat rongis " + getName() 
						            		+ " liinis "
						            		+ getRoute().getStationById(0).getName() + "-" 
						     				+ getRoute().getStationById(getRoute().getStationSize()-1).getName();
						             String path="caughtStowaways.txt";
						             File file = new File(path);

						             if (!file.exists()) {
						                 file.createNewFile();
						             }

						             FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
						             BufferedWriter bw = new BufferedWriter(fw);
						             bw.append(content);
						             bw.newLine();
						             bw.close();
						       }catch(Exception e){
						           System.out.println(e);
						       }
							}
						}
					}
					int suurus = getMaxPassengerCount()-passengers.size();
					for(int i = 0; i < suurus; i++){
						for(int j = 0; j < schedule.getStation(position).getPassengerListSize(); j++){
							if(schedule.getStation(position).getPassengerInfo(j).getLastTrainName() != getName()){
								schedule.getStation(position).getPassengerInfo(j).setLastTrainName(getName());
								int stationId = position;
								while(stationId == position){
									stationId = random.nextInt(schedule.getStationSize());
								}
								schedule.getStation(position).getPassengerInfo(j).setDestination(schedule.getStation(stationId).getName());
								addPassenger(schedule.getStation(position).getPassenger(j));
								gotOn++;
								break;
							} else {
								
							}
						}
					}
					if(!getRoute().getRailByTime(schedule.getTime(position)).isElectric()){
						System.out.println(getName() + " s�idab mitteelektrilisel raudteel ja ei saa edasi s�ita!");
						canDrive = false;
						break;
					}
					trainDeparture(schedule.getStation(position).getName(), gotOn);
					while(getRoute().getRailByTime(schedule.getTime(position)).getTrainCount() > getRoute().getRailByTime(schedule.getTime(position)).getTrainLimit()-1){
						Thread.sleep(50);
					}
					
					getRoute().getRailByTime(schedule.getTime(position)).addTrain();
					Thread.sleep(schedule.getTime(position));
					getRoute().getRailByTime(schedule.getTime(position)).removeTrain();
					position++;
				}
				position = 0;
				tripCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tripCount == 6){
				if(passengers.get(0).getDestination() == schedule.getStation(position).getName()){
					schedule.getStation(position).addPassenger(passengers.get(0));
					passengers.remove(0);
					gotOff++;
				}
				trainArrival(schedule.getStation(position).getName(), gotOff);
			}
		}
		
	}

	
}
