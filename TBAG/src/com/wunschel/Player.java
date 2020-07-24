package com.wunschel;

public class Player {
    private Descriptors descriptors;
    private Stats stats;
    private Location location;

    public Player(Descriptors descriptors, Stats stats, Location location) {
        this.descriptors = descriptors;
        this.stats = stats;
        this.location = location;
    }

    public Descriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(Descriptors descriptors) {
        this.descriptors = descriptors;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
