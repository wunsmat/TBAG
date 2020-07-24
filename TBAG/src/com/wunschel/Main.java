package com.wunschel;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = false;
        System.out.println("Welcome to the game. What is your name?");
        Location bedroom = new Location(new Descriptors("Bedroom", "A room with a bed."));
        Location hallway = new Location(new Descriptors("Hallway", "Long hallway with several doors"));
        Location bathroom = new Location(new Descriptors("Bathroom", "Very small bathroom with a standing shower"));
        Location kitchen = new Location(new Descriptors("Kitchen", "I see an oven."));
        bedroom.addExit(hallway);
        hallway.addExitList(Arrays.asList(bedroom, bathroom, kitchen));
        bathroom.addExit(hallway);
        kitchen.addExit(hallway);
        Scanner scanner = new Scanner(System.in);
        Descriptors playerDescriptors = new Descriptors(scanner.nextLine(), "");
        Stats playerStats = new Stats(10, 10, 1);
        Player player = new Player(playerDescriptors, playerStats, bedroom);
        player.getLocation().describe();
        while (!gameOver) {
            if (scanner.hasNextLine()) {
                String[] commands = scanner.nextLine().split(" ");
                if ("exit".equals(commands[0].toLowerCase())) {
                    gameOver = true;
                } else if ("go".equals(commands[0].toLowerCase())) {
                    if (commands.length > 1) {
                        player.getLocation()
                            .getExitList()
                            .parallelStream()
                            .filter(exit -> {
                                String exitName = exit.getDescriptors().getName().toLowerCase();
                                return exitName.equals(commands[1].toLowerCase());
                            })
                            .findAny()
                            .ifPresentOrElse(player::setLocation, () -> System.out.println(commands[1] + " does not exist."));
                    } else {
                        System.out.println("You must enter an exit name.");
                    }
                }
                player.getLocation().describe();
            }
        }
    }
}
