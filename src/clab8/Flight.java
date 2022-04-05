package clab8;

public class Flight {
    private int startDate;
    private int endDate;
    private int NumOfPassengers;

    public Flight(int start, int end, int numPassengers){
        startDate = start;
        endDate = end;
        NumOfPassengers = numPassengers;
    }

    public int startTime(){
        return startDate;
    }

    public int endTime(){
        return endDate;
    }

    public int passengers(){
        return NumOfPassengers;
    }
}
