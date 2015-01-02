/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model;

import sa.shpi.simple.visual.Form;

public abstract class Room {
	protected String name;

	protected int damage;
	protected double percentDamage;

	protected Form damageForm;
	protected double weight;

	public Room() {
	}

	public Room(String name, int damage, Form damageForm) {
		this.name = name;
		this.damage = damage;
		this.percentDamage = damage * 0.2;
		this.damageForm = damageForm;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "No Data";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
		this.percentDamage = damage * 0.2;
	}

	public Form getDamageForm() {
		return damageForm;
	}

	public void setDamageForm(Form damageForm) {
		this.damageForm = damageForm;
	}

	public double getWeight() {
		return weight;
	}

	public double getPercentDamage() {
		return percentDamage;
	}

}
