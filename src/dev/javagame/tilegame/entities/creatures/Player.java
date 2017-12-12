package dev.javagame.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.javagame.tilegame.Game;
import dev.javagame.tilegame.gfx.Assets;

public class Player extends Creature
{
	private float player_speed = 2;

	public Player(Game game, float x, float y)
	{
		super(game, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
	}

	@Override
	public void tick()
	{
		getInput();
		move();
		game.getCamera().centerOnEntity(this);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {yMove = -speed * player_speed;}
		if(game.getKeyManager().down) {yMove = speed * player_speed;}
		if(game.getKeyManager().left) {xMove = -speed * player_speed;}
		if(game.getKeyManager().right) {xMove = speed * player_speed;}
		
//		if(game.getKeyManager().up) {Game.getCamera().move(0,-speed * player_speed);}
//		if(game.getKeyManager().down) {Game.getCamera().move(0, speed * player_speed);}
//		if(game.getKeyManager().left) {Game.getCamera().move(-speed * player_speed, 0);}
//		if(game.getKeyManager().right) {Game.getCamera().move(speed * player_speed, 0);}
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(Assets.player, (int) (x - game.getCamera().getxOffset()), (int) (y - game.getCamera().getyOffset()), width, height, null);
	}

}
