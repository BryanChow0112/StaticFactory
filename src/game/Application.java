package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.*;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.flora.Sapling;
import game.grounds.flora.Tree;
import game.scraps.regular.LargeBolt;
import game.scraps.special.*;
import game.scraps.regular.MetalSheet;
import game.types.Buyable;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Lachlan MacPhee
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Tree(), new Sapling());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.................t.....",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        "...T.........#___#...........~",
                        ".............#___#..t.......~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        "..t..~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Setup Terminal
        ArrayList<Buyable> buyables = new ArrayList<>();
        buyables.add(new EnergyDrink());
        buyables.add(new DragonSlayerSword());
        buyables.add(new ToiletPaperRoll());
        Terminal terminal = new Terminal(buyables);
        gameMap.at(16, 6).setGround(terminal);

        // Add player with balance
        Player player = new Player("Intern", '@', 4);
        player.addBalance(1000);
        world.addPlayer(player, gameMap.at(15, 6));

        // Add large bolt and metal sheet
        Item largeBolt = new LargeBolt();
        gameMap.at(8, 7).addItem(largeBolt);

        Item metalSheet = new MetalSheet();
        gameMap.at(9, 7).addItem(metalSheet);

        Item metalPipe = new MetalPipe();
        gameMap.at(10, 7).addItem(metalPipe);

        Crater craterOne = new Crater(new HuntsmanSpider());
        gameMap.at(26, 4).setGround(craterOne);

        Crater craterTwo = new Crater(new HuntsmanSpider());
        gameMap.at(6, 5).setGround(craterTwo);

        Crater craterThree = new Crater(new HuntsmanSpider());
        gameMap.at(26, 12).setGround(craterThree);

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();
    }
}
