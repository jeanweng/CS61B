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
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Fills the background with black TILES
     */
    private static void addCanvas(TETile[][] world){
        for (int i = 0; i < WIDTH; i += 1) {
            for (int j = 0; j < HEIGHT; j += 1) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(6);
        switch (tileNum) {
            case 0: return Tileset.TREE;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.FLOOR;
            case 3: return Tileset.GRASS;
            case 4: return Tileset.MOUNTAIN;
            case 5: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }
    /**
     * Draw a single hexagon
     * @param world
     * @param length
     * @param p
     */
    public static void addHexagon(TETile[][] world, int length, Position p, TETile pattern){
        int w = length + (length - 1) * 2;
        int j = p.y, k = 0;
        while(j < Math.min(p.y + 2 * length, HEIGHT)){
            if(j < p.y + length) k++;
            else if(j > p.y + length) k--;
            for(int i = p.x + length - k; i < Math.min(p.x + w - length + k, WIDTH); i++){
                    world[i][j] = pattern;
            }
            j++;
        }
    }
    private static Position topRightNeighbor(Position original, int length){
        int x = original.x +  2 * length - 1;
        int y = original.y + length;
        return new Position(x, y);
    }
    private static Position bottomRightNeighbor(Position original, int length){
        int x = original.x +  2 * length - 1;
        int y = original.y - length;
        return new Position(x, y);
    }

    private static void drawRandomVerticalHexes(TETile[][] world, int length, Position p, int num){
        for(int i = 0; i < num; i++){
            addHexagon(world, length, p, randomTile());
            p = new Position(p.x, p.y + 2 * length);
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        addCanvas(world);
        int length = 3;
        Position p1 = new Position(5, 15);
        drawRandomVerticalHexes(world, length, p1, 3);
        Position p2 = bottomRightNeighbor(p1,length);
        drawRandomVerticalHexes(world, length, p2, 4);
        Position p3 = bottomRightNeighbor(p2, length);
        drawRandomVerticalHexes(world, length, p3, 5);
        Position p4 = topRightNeighbor(p3, length);
        drawRandomVerticalHexes(world, length, p4, 4);
        Position p5 = topRightNeighbor(p4, length);
        drawRandomVerticalHexes(world, length, p5, 3);
        ter.renderFrame(world);
    }
}
