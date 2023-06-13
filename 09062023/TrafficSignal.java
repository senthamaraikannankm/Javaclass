package com.dedalus;


public class TrafficSignal {
    private SignalState currentState; 

    public TrafficSignal() {
        currentState = new RedState();
    }

    public void changeState() {
        currentState.changeState(this);
    }

    public void setCurrentState(SignalState state) {
        currentState = state;
    }

    public void displaySignal() {
        currentState.displaySignal();
    }

    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();

        // Simulate the traffic signal for a certain duration
        for (int i = 0; i < 10; i++) {
            trafficSignal.displaySignal();
            trafficSignal.changeState();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

interface SignalState {
    void changeState(TrafficSignal trafficSignal);

    void displaySignal();
}

class RedState implements SignalState {
    public void changeState(TrafficSignal trafficSignal) {
        trafficSignal.setCurrentState(new GreenState());
    }


    public void displaySignal() {
        System.out.println("Current signal color: RED");
    }
}

class GreenState implements SignalState {

    public void changeState(TrafficSignal trafficSignal) {
        trafficSignal.setCurrentState(new YellowState());
    }


    public void displaySignal() {
        System.out.println("Current signal color: GREEN");
    }
}

class YellowState implements SignalState {

    public void changeState(TrafficSignal trafficSignal) {
        trafficSignal.setCurrentState(new RedState());
    }


    public void displaySignal() {
        System.out.println("Current signal color: YELLOW");
    }
}