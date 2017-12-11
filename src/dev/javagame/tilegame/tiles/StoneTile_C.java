package dev.javagame.tilegame.tiles;

import dev.javagame.tilegame.gfx.Assets;

public class StoneTile_C extends Tile
{

	public StoneTile_C(int id)
	{
		super(Assets.rock_C, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
