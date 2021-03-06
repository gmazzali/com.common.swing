package com.common.swing.domain.icon;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * La clase que va a contener los m�todos gr�ficos que vamos a ocupar dentro del sistema.
 * 
 * @since 06/05/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class IconResources implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * El path de los recursos.
	 */
	public static final String RESOURCE_PATH = "com/common/swing/image/";

	/**
	 * La funci�n encargada de crear los iconos de acuerdo al path recibidos y al tama�o requerido de redimensi�n.
	 * 
	 * @param path
	 *            El path donde se encuentra la imagen que vamos a utilizar para crear el icono.
	 * @param width
	 *            El ancho con el que vamos a redimensionar el icono a crear.
	 * @param height
	 *            El alto con el que vamos a redimensionar el icono a crear.
	 * @return El icono que creamos de acuerdo a los par�metros recibidos.
	 */
	public static ImageIcon createStaticImage(String path, Integer width, Integer height) {
		return new ImageIcon(new ImageIcon(IconResources.class.getClassLoader().getResource(path)).getImage().getScaledInstance(width, height,
				Image.SCALE_SMOOTH));
	}

	/**
	 * La funci�n encargada de crear los iconos animado de acuerdo al path recibidos.
	 * 
	 * @param path
	 *            El path donde se encuentra la imagen en formato GIF que vamos a utilizar para crear el icono.
	 * @return El icono animado que creamos de acuerdo a los par�metros recibidos.
	 */
	public static ImageIcon createGifImage(String path) {
		return new ImageIcon(IconResources.class.getClassLoader().getResource(path));
	}
}