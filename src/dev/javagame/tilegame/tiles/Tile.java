package dev.javagame.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile_C = new GrassTile_C(0);
	public static Tile sandTile_C = new SandTile_C(1);
	public static Tile stoneTile_C = new StoneTile_C(2);
	
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, texture.getWidth() * 2, texture.getHeight() * 2, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public int getId()
	{
		return id;
	}
}
