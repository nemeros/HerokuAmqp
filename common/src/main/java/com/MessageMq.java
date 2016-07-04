package com;

import java.io.Serializable;

public class MessageMq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2969170622111975606L;
	
	
	
	public String name;
	public String valeur;

	@Override
	public String toString(){
		return "{name: '" + name + "' ,valeur: '" + valeur + "'}";
	}
	
}