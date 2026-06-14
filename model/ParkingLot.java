package model;

import gate.EntryGate;
import gate.ExitGate;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static volatile ParkingLot instance;

    private final String name;
    private final List<Floor> floors;

    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;

    public ParkingLot(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public String getName() {
        return name;
    }
}