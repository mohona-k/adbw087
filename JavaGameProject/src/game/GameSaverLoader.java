/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class GameSaverLoader {

    /**
     * Game saving to a file
     * <p>
     * Will allow storage of data when the program exits
     *
     * @param  level current level
     * @param fileName name of file game will be saved in
     * @return null
     */

    public static void save(GameLevel level, String fileName)
            throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getMain().getCoinCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    /**
     * Loads game
     * <p>
     * Reads stored game data
     *
     * @param  game the actual game
     * @param fileName the file that is read
     * @return null
     */
    public static GameLevel load(MainGame game, String fileName)
            throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int coinCount = Integer.parseInt(tokens[1]);

            GameLevel level = null;
            if (name.equals("Level1"))
                level = new Level1(game);
            else if (name.equals("Level2"))
                level = new Level2(game);
            else if (name.equals("Level3"))
                level = new Level3(game);

            level.getMain().setCoinCount(coinCount);

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

}
