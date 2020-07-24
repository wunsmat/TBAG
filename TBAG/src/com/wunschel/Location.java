package com.wunschel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Location {

    private Descriptors descriptors;
    private List<Location> exitList;

    public Location(Descriptors descriptors) {
        this.descriptors = descriptors;
        exitList = new ArrayList<>();
    }

    public void addExit(Location exit) {
        exitList.add(exit);
    }

    public void addExitList(List<Location> exitList) {
        this.exitList.addAll(exitList);
    }

    public void describe() {
        System.out.println(descriptors.getName());
        System.out.println(descriptors.getDescription());
        String exitNames = exitList.stream().map(exit -> exit.getDescriptors().getName()).collect(Collectors.joining(", "));
/*        String exitNames = exitList.parallelStream()
                .map(exit -> exit.getDescriptors().getName())
                .collect(Collectors.joining(", "));*/
        System.out.println("Exits: " + exitNames);
    }

    public Descriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(Descriptors descriptors) {
        this.descriptors = descriptors;
    }

    public List<Location> getExitList() {
        return exitList;
    }

    public void setExitList(List<Location> exitList) {
        this.exitList = exitList;
    }
}
