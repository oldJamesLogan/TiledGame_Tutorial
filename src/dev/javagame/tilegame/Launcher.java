package dev.javagame.tilegame;

public class Launcher
{
	public static void main(String[] args)
	{
		Game game = new Game("Java Game", 800, 600);
		
		game.start();
	}
}
