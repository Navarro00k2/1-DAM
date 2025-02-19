/*
 * Modelo de la ventana principal.
 * 
 * @Navarro
 * 18-02-25
 * 
 */
package model;

import java.util.ArrayList;

public class BudgetWindowMo {
					
	private ArrayList<String> texts;					// Lista de textos de la ventana (no de radioButtons)
	private ArrayList<String> sectionHeaders;			// Lista de cabeceras (los nombres sobre cada seccion)
	private ArrayList<ArrayList<OptionsMo>> sections;	// Lista de secciones. Cada una es un conjunto de opciones (OptionsMo) para usar posteriormente como radioButtons
	
	public BudgetWindowMo() {
		this.texts = new ArrayList<String>();
		this.sectionHeaders = new ArrayList<String>();
		this.sections = new ArrayList<ArrayList<OptionsMo>>();
		
		createTexts(); // Crear los textos		
		createSectionHeaders();	// Crear cabeceras
		createData(); // Crear las opciones de cada seccion
	}

	private void createTexts() {
		texts.add("Presupuesto de viaje");	// 0, Titulo de la ventana
		texts.add("Personas: ");			// 1, Texto junto al campo para introducir datos ("personas")
		texts.add("Precio");				// 2, Texto del precio final	
	}

	private void createSectionHeaders() {
		sectionHeaders.add("Transporte");	// 0
		sectionHeaders.add("Hotel");		// 1
		sectionHeaders.add("Comida");		// 2
		sectionHeaders.add("Ocio");			// 3	
	}

	private void createData() {
		// Anadir lista 0 con opciones al conjunto de secciones
		ArrayList<OptionsMo> listTransporte = new ArrayList<OptionsMo>();
		listTransporte.add(new OptionsMo("Autobus", 100));
		listTransporte.add(new OptionsMo("Avion", 800));
		listTransporte.add(new OptionsMo("Tren", 150));
		listTransporte.add(new OptionsMo("Propio", 50));
		listTransporte.add(new OptionsMo("Canoa", 10));
		sections.add(listTransporte);
		
		// Anadir lista 1 con opciones al conjunto de secciones
		ArrayList<OptionsMo> listHotel = new ArrayList<OptionsMo>();
		listHotel.add(new OptionsMo("Ibis", 500));
		listHotel.add(new OptionsMo("Hilton", 300));
		listHotel.add(new OptionsMo("Malaga Palacio", 200));
		sections.add(listHotel);
		
		// Anadir lista 2 con opciones al conjunto de secciones
		ArrayList<OptionsMo> listComida = new ArrayList<OptionsMo>();
		listComida.add(new OptionsMo("Completa", 200));
		listComida.add(new OptionsMo("Media", 100));
		listComida.add(new OptionsMo("Desayuno", 50));
		sections.add(listComida);
		
		// Anadir lista 4 con opciones al conjunto de secciones
		ArrayList<OptionsMo> listOcio = new ArrayList<OptionsMo>();
		listOcio.add(new OptionsMo("Cultural", 200));
		listOcio.add(new OptionsMo("Fiestas", 100));
		listOcio.add(new OptionsMo("Ocio", 50));
		listOcio.add(new OptionsMo("churros", 10));
		sections.add(listOcio);
	}

	public ArrayList<String> getTexts() {
		return texts;
	}

	public void setTexts(ArrayList<String> texts) {
		this.texts = texts;
	}

	public ArrayList<String> getSectionHeaders() {
		return sectionHeaders;
	}

	public void setSectionHeaders(ArrayList<String> sectionHeaders) {
		this.sectionHeaders = sectionHeaders;
	}

	public ArrayList<ArrayList<OptionsMo>> getSections() {
		return sections;
	}

	public void setSections(ArrayList<ArrayList<OptionsMo>> sections) {
		this.sections = sections;
	}
	
	
	
}
