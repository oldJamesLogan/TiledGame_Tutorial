package dev.javagame.tilegame.worlds;

import java.awt.Graphics;

import dev.javagame.tilegame.Game;
import dev.javagame.tilegame.tiles.Tile;
import dev.javagame.tilegame.utils.Utils;

public class World
{
	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	public World(Game game, String path)
	{
		this.game = game;
		loadWorld(path);
	}

	public void tick()
	{

	}

	public void render(Graphics g)
	{
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				getTile(x, y).render(g, 
						(int) (x * Tile.TILEWIDTH - Game.getCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - Game.getCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) return Tile.grassTile_C;
		return t;
	}

	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parceInt(tokens[0]);
		height = Utils.parceInt(tokens[1]);
		spawnX = Utils.parceInt(tokens[2]);
		spawnY = Utils.parceInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tiles[x][y] = Utils.parceInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getSpawnX()
	{
		return spawnX;
	}
	
	public int getSpawnY()
	{
		return spawnY;
	}
}
