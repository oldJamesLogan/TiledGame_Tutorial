package dev.javagame.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.javagame.tilegame.Game;
import dev.javagame.tilegame.gfx.Assets;

public class Player extends Creature
{
	private Game game;
	
	private float player_speed = 3;

	public Player(Game game, float x, float y)
	{
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick()
	{
		getInput();
		move();
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {yMove = -speed;}
		if(game.getKeyManager().down) {yMove = speed;}
		if(game.getKeyManager().left) {xMove = -speed;}
		if(game.getKeyManager().right) {xMove = speed;}
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
	}

}
