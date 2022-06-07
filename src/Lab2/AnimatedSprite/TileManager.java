package Lab2.AnimatedSprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class TileManager {

    GamePanel panel;
    Tile[] tiles;
    int[][] mapTileNum;

    public TileManager(GamePanel panel){
        this.panel = panel;

        tiles = new Tile[6];

        mapTileNum = new int[panel.maxWorldCol][panel.maxWorldRow];

        getTilesImage();
        loadFileMap();
    }

    public void getTilesImage() {
        try{
            for(int i = 0; i < 6; ++i)
                tiles[i] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        Random rnd = new Random();

        for(int i = 0; i < panel.maxScreenCol; ++i){
            for(int j = 0; j < panel.maxScreenRow; ++j)
                mapTileNum[i][j] = rnd.nextInt(6);
        }
    }

    public void loadFileMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/world01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < panel.maxWorldCol && row < panel.maxWorldRow) {
                String line = br.readLine();

                while(col < panel.maxWorldCol){
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == panel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;

        while(col < panel.maxWorldCol && row < panel.maxWorldRow){

            int worldX = col * panel.tileSize;
            int worldY = row * panel.tileSize;
            int screenX = worldX - panel.player.worldX + panel.player.screenX;
            int screenY = worldY - panel.player.worldY + panel.player.screenY;

            if(worldX + panel.tileSize > panel.player.worldX - panel.player.screenX &&
               worldX - panel.tileSize < panel.player.worldX + panel.player.screenX &&
               worldY + panel.tileSize > panel.player.worldY - panel.player.screenY &&
               worldY - panel.tileSize < panel.player.worldY + panel.player.screenY) {

                g2.drawImage(tiles[mapTileNum[col][row]].image, screenX, screenY,
                        panel.tileSize, panel.tileSize, null);
            }

            col++;

            if(col == panel.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }
}
