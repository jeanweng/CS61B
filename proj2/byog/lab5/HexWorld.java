package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public void addHexagon(int length, int x, int y){
        for(int i = x; i < x + length; i++){

        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        HexWorld hw = new HexWorld();

        TETile[][] HexTiles = new TETile[WIDTH][HEIGHT];
        hw.addHexagon(2, 10,10);
        ter.renderFrame(HexTiles);
    }
}
