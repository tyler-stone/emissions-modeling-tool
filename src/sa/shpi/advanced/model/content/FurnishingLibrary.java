/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model.content;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Library;

/**
 * Dynamic furniture library with presets to add to rooms
 * @author Tyler
 *
 */
public class FurnishingLibrary extends Library {

	public FurnishingLibrary() {
		initialize();
	}

	@Override
	public void initialize() {
		lib.add(new EmissionsItem("TV", 1.8, 21.0));
		lib.add(new EmissionsItem("Computadora", 2.5, 10.0));
		lib.add(new EmissionsItem("Refrigerador", 2.22, 38.0));
		lib.add(new EmissionsItem("Lavaplatos", 1.62, 47.0));
		lib.add(new EmissionsItem("Microondas", 2.5, 19.0));
		lib.add(new EmissionsItem("Estufa", 2.5, 56.0));
		lib.add(new EmissionsItem("Lavadora", 2.43, 65.0));
		lib.add(new EmissionsItem("Secador", 2.5, 69.0));
		lib.add(new EmissionsItem("Silla tapizada", 1.6, 27.0));
		lib.add(new EmissionsItem("Sofá", 1.6, 42.0));
		lib.add(new EmissionsItem("Equipo de música", 2.5, 27.0));
		lib.add(new EmissionsItem("Mesita", 1.33, 14.0));
		lib.add(new EmissionsItem("Biblioteca", 0.29, 21.0));
		lib.add(new EmissionsItem("Asiento de amor", 1.6, 37.0));
		lib.add(new EmissionsItem("Otomana", 1.6, 11.0));
		lib.add(new EmissionsItem("Escritorio", 1.33, 27.0));
		lib.add(new EmissionsItem("Futón", 1.6, 35.0));
		lib.add(new EmissionsItem("Cama", 1.6, 50.0));
		lib.add(new EmissionsItem("Ropero", 1.33, 55.0));
		lib.add(new EmissionsItem("Silla", 1.9, 7.0));
		lib.add(new EmissionsItem("Mesa", 1.33, 29.0));
		lib.add(new EmissionsItem("Armarios", 1.33, 20.0));
		lib.add(new EmissionsItem("Ropa", 2.2, 6.0));
	}

	@Override
	public String getUnits() {
		return "kg";
	}
}
