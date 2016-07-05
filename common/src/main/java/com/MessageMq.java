package com;

import java.io.Serializable;

public class MessageMq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2969170622111975606L;
	
	
	public MessageMq(){
		
	}
	
	
	public MessageMq(String name, String valeur){
		this.name = name;
		this.valeur = valeur;
	}
	
	
	private String name;
	private String valeur;

	@Override
	public String toString(){
		return "{name: '" + name + "' ,valeur: '" + valeur + "'}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}