package dev.javagame.tilegame;

import static dev.javagame.tilegame.tools.Loger.*;
import static dev.javagame.tilegame.gfx.Assets.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.javagame.tilegame.display.Display;
import dev.javagame.tilegame.gfx.Assets;
import dev.javagame.tilegame.input.KeyManager;
import dev.javagame.tilegame.states.GameState;
import dev.javagame.tilegame.states.MenuState;
import dev.javagame.tilegame.states.State;
import dev.javagame.tilegame.worlds.World;



public class Game implements Runnable
{
	/*
	 * voy por el capitulo 16
	 */
	
	private int width, height;
	private String title;
	
	private Display display;
	private KeyManager keyManager;
	
	private Thread thread;
	private volatile boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	private World world;
	
	int x = 0, y = 0;
	int ticks = 0, renders = 0;
	
	public Game(String title, int width, int height)
	{
		log("constructor");
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
//		State.setState(menuState);
		
		world = new World("qwerty");
		
		Assets.init();
	}
	
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}
		ticks++;
	}
	
	private void render()
	{
		renders++;
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		//Draw Begin
		
		world.render(g);
		
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		//Draw End
		
		bs.show();
		g.dispose();
	}
	
	

	@Override
	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick = 1_000_000_000 / fps;
		double delta = 0;
		long now = 0;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				
				delta--;
			}
			
			render();
			
			if(timer >= 1_000_000_000)
			{
				String str = "Ticks: " + ticks + " Render: " + renders;
				log(str);
				timer = 0;
				ticks = 0;
				renders = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start()
	{
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running) return;
		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
}
