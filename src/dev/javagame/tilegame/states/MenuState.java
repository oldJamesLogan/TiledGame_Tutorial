package dev.javagame.tilegame.states;

import java.awt.Graphics;

import dev.javagame.tilegame.Game;

public class MenuState extends State
{
	public MenuState(Game game)
	{
		super(game);
	}
	

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g)
	{
		g.fillRect(0, 0, 512, 512);
	}

}
