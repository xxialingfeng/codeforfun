package clab8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FlightSolver {
    int maxPassengers = 0;

    public FlightSolver(ArrayList<Flight> flight){
        Comparator<Flight> startTimeCmp = (Flight f1, Flight f2) -> (f1.startTime() - f2.startTime()); //比较器的写法
        Comparator<Flight> endTomeCmp = (Flight f1, Flight f2) -> (f1.endTime() - f2.endTime());

        PriorityQueue<Flight> startMinPQ = new PriorityQueue<>(startTimeCmp);
        PriorityQueue<Flight> endMinPQ = new PriorityQueue<>(endTomeCmp);

        startMinPQ.addAll(flight);
        endMinPQ.addAll(flight);

        int nowPassengers = 0;
        while(startMinPQ.peek() != null){
            if(startMinPQ.peek().startTime() <= endMinPQ.peek().endTime()){
                nowPassengers += startMinPQ.poll().passengers();
                if(nowPassengers > maxPassengers){
                    maxPassengers = nowPassengers;
                }
            }else{
                nowPassengers -= endMinPQ.poll().passengers();
            }
        }
    }

    public int solve(){
        return maxPassengers;
    }
}
