package game;

import java.util.*;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actions.TeleportAction;
import game.actors.*;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.flora.*;
import game.scraps.regular.LargeBolt;
import game.scraps.special.*;
import game.scraps.regular.MetalSheet;
import game.spawners.AlienBugSpawner;
import game.spawners.HuntsmanSpiderSpawner;
import game.spawners.SuspiciousAstronautSpawner;
import game.types.Buyable;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Lachlan MacPhee
 */
public class Application {
    
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Sprout()) {
        };

        List<String> polymorphia = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~..........,.....,......",
                "...~~~.........,.,..,.........",
                ".....................,.,......",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        // Add Polymorphia game map
        GameMap polymorphiaOne = new GameMap(groundFactory, polymorphia);
        world.addGameMap(polymorphiaOne);

        List<String> staticFactory = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");

        // Add Static Factory game map
        GameMap staticFactoryOne = new GameMap(groundFactory, staticFactory);
        world.addGameMap(staticFactoryOne);

        // Add humanoid figure
        Humanoid humanoid = new Humanoid();
        staticFactoryOne.at(3, 9).addActor(humanoid);

        List<String> refactorio = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");

        // Add Refactorio game map
        GameMap refactorioOne = new GameMap(groundFactory, refactorio);
        world.addGameMap(refactorioOne);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Setup buyables for terminal
        ArrayList<Buyable> buyables = new ArrayList<>();
        buyables.add(new EnergyDrink());
        buyables.add(new DragonSlayerSword());
        buyables.add(new ToiletPaperRoll());
        buyables.add(new Astley());
        buyables.add(new Theseus());

        // Add travel actions for terminal in Polymorphia
        ArrayList<Action> travelActionPolymorphia = new ArrayList<>();
        travelActionPolymorphia.add(new TeleportAction("Static Factory", staticFactoryOne.at(3, 3)));
        travelActionPolymorphia.add(new TeleportAction("Refactorio", refactorioOne.at(15, 6)));

        // Place terminal at Polymorphia
        Terminal terminalPolymorphia = new Terminal(buyables, travelActionPolymorphia);
        polymorphiaOne.at(15, 5).setGround(terminalPolymorphia);

        // Add travel actions for terminal in Static Factory
        ArrayList<Action> travelActionStaticFactory = new ArrayList<>();
        travelActionStaticFactory.add(new TeleportAction("Polymorphia", polymorphiaOne.at(15, 6)));
        travelActionStaticFactory.add(new TeleportAction("Refactorio", refactorioOne.at(15, 6)));

        // Place terminal at Static Factory
        Terminal terminalStaticFactory = new Terminal(buyables, travelActionStaticFactory);
        staticFactoryOne.at(3, 2).setGround(terminalStaticFactory);

        // Add travel actions for terminal in Refactorio
        ArrayList<Action> travelActionRefactorio = new ArrayList<>();
        travelActionRefactorio.add(new TeleportAction("Polymorphia", polymorphiaOne.at(15, 6)));
        travelActionRefactorio.add(new TeleportAction("Static Factory", staticFactoryOne.at(3, 3)));

        // Place terminal at Refactorio
        Terminal terminalRefactorio = new Terminal(buyables, travelActionRefactorio);
        refactorioOne.at(15, 5).setGround(terminalRefactorio);

        // Add player with balance
        Player player = new Player("Intern", '@', 4);
        player.addBalance(1000);
        world.addPlayer(player, polymorphiaOne.at(15, 6));

        // Add large bolt and metal sheet
        Item largeBolt = new LargeBolt();
        polymorphiaOne.at(8, 7).addItem(largeBolt);

        Item metalSheet = new MetalSheet();
        polymorphiaOne.at(9, 7).addItem(metalSheet);

        // Add metal pipe
        Item metalPipe = new MetalPipe();
        polymorphiaOne.at(10, 7).addItem(metalPipe);

        // Add jar of pickles
        Item jarOfPicklesTwo = new JarOfPickles();
        polymorphiaOne.at(15, 10).addItem(jarOfPicklesTwo);

        Item jarOfPicklesThree = new JarOfPickles();
        polymorphiaOne.at(14, 10).addItem(jarOfPicklesThree);

        Item jarOfPicklesFour = new JarOfPickles();
        polymorphiaOne.at(13, 10).addItem(jarOfPicklesFour);

        // Create craters spawning HuntsmanSpiders
        Crater craterOne = new Crater(new HuntsmanSpiderSpawner());
        polymorphiaOne.at(26, 4).setGround(craterOne);

        // Create craters spawning AlienBugs
        Crater craterTwo = new Crater(new AlienBugSpawner());
        polymorphiaOne.at(6, 5).setGround(craterTwo);

        Crater craterThree = new Crater(new AlienBugSpawner());
        polymorphiaOne.at(26, 12).setGround(craterThree);

        // Create craters spawning SuspiciousAstronauts
        Crater craterFour = new Crater(new SuspiciousAstronautSpawner());
        polymorphiaOne.at(26, 13).setGround(craterFour);

        world.run();
    }
}
