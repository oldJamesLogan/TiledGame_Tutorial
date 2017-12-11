package dev.javagame.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static SpriteSheet tileSet = new SpriteSheet(ImageLoader.loadImage("/Graphics/Tilesets/my_tile_01.png"));
	
	private static SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/Graphics/Characters/Actor1.png"));
	
	public static final int XS_SIZE = 8;
	public static final int S_SIZE = 16;
	public static final int M_SIZE = 32;
	public static final int l_SIZE = 64;
	public static final int XL_SIZE = 128;
	public static final int XXL_SIZE = 512;
	
	public static final double S_1X = 1.0;
	public static final double S_2X = 2.0;
	public static final double S_3X = 3.0;
	
	
	public static BufferedImage player;
	
	
	public static BufferedImage grass_C;
	
	
	public static BufferedImage sand_NW;
	public static BufferedImage sand_N;
	public static BufferedImage sand_NE;
	
	public static BufferedImage sand_W;
	public static BufferedImage sand_C;
	public static BufferedImage sand_E;
	
	public static BufferedImage sand_SW;
	public static BufferedImage sand_S;
	public static BufferedImage sand_SE;
	
	
	public static BufferedImage rock_NW;
	public static BufferedImage rock_N;
	public static BufferedImage rock_NE;
	
	public static BufferedImage rock_W;
	public static BufferedImage rock_C;
	public static BufferedImage rock_E;
	
	public static BufferedImage rock_SW;
	public static BufferedImage rock_S;
	public static BufferedImage rock_SE;
	
	public static void init()
	{
		player = spriteSheet.crop(2, 0, M_SIZE, M_SIZE);
		
		
		grass_C = tileSet.crop(0, 0, M_SIZE, M_SIZE);
		
		
		sand_NW = tileSet.crop(0, 2, S_SIZE, S_SIZE);
		sand_N = tileSet.crop(0, 4, M_SIZE, S_SIZE);
		sand_NE = tileSet.crop(1, 2, S_SIZE, S_SIZE);
		
		sand_W = tileSet.crop(0, 6, S_SIZE, M_SIZE);
		sand_C = tileSet.crop(2, 0, M_SIZE, M_SIZE);
		sand_E = tileSet.crop(1, 6, S_SIZE, M_SIZE);
		
		sand_SW = tileSet.crop(0, 3, S_SIZE, S_SIZE);
		sand_S = tileSet.crop(0, 5, M_SIZE, S_SIZE);
		sand_SE = tileSet.crop(1, 3, S_SIZE, S_SIZE);
		
		
		rock_NW = tileSet.crop(0, 8, S_SIZE, S_SIZE);
		rock_N = tileSet.crop(0, 10, M_SIZE, S_SIZE);
		rock_NE = tileSet.crop(1, 8, S_SIZE, S_SIZE);
		
		rock_W = tileSet.crop(0, 12, S_SIZE, M_SIZE);
		rock_C = tileSet.crop(4, 0, M_SIZE, M_SIZE);
		rock_E = tileSet.crop(1, 12, S_SIZE, M_SIZE);
		
		rock_SW = tileSet.crop(0, 9, S_SIZE, S_SIZE);
		rock_S = tileSet.crop(0, 11, M_SIZE, S_SIZE);
		rock_SE = tileSet.crop(1, 9, S_SIZE, S_SIZE);
	}
}
