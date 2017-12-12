package dev.javagame.tilegame.states;

import static dev.javagame.tilegame.tools.Loger.*;

import java.awt.Graphics;

import dev.javagame.tilegame.Game;
import dev.javagame.tilegame.entities.creatures.Player;
import dev.javagame.tilegame.gfx.Assets;
import dev.javagame.tilegame.tiles.Tile;
import dev.javagame.tilegame.worlds.World;

public class GameState extends State
{
	int x = 0;
	int y = 0;
	
	World world;
	Player player;
	
	public GameState(Game game)
	{
		super(game);
		world = new World(game, "res/worlds/world01.txt");
		player = new Player(game, world.getSpawnX(),world.getSpawnY());
	}

	@Override
	public void tick()
	{
//		x++;
//		y++;
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g)
	{
//		Tile.tiles[15].render(g, 0, 0);
//		Tile.tiles[25].render(g, 64, 0);
//		Tile.tiles[35].render(g, 128, 0);
		
		world.render(g);
		player.render(g);
	}

}
