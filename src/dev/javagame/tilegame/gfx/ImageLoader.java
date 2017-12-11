package dev.javagame.tilegame.gfx;

import static dev.javagame.tilegame.tools.Loger.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader
{
	public static BufferedImage loadImage(String path)
	{
		try
		{
			return ImageIO.read(ImageLoader.class.getResource(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			log("no se pudo cargar la imagen");
			System.exit(1);
		}
		
		return null;
	}
}
