/*
 * Modelo general
 * 
 * @Navarro
 * 31-01-25
 * 
 */
package model;

import java.util.ArrayList;

public class Model {
	
	private ArrayList<String> buttonTexts;				// Texto de los botones				
	private ArrayList<String> mainFieldsCoches;			// lista de nombres de los campos de los coches
	private ArrayList<String> mainFieldsPersonal;		// lista de los nombres de los campos del personal
	private ArrayList<ArrayList<String>> mainFields;	// Conjunto de listas con nombres de campos
	private ArrayList<String> tableNames;				// Nombre de cada tabla (y titulo de la ventana)
	private ArrayList<MoCoches> cochesList;				// Lista de objetos coches
	private ArrayList<MoPersonal> personalList;			// Lista de objetos ersonal
	private ArrayList<ArrayList<Object>> tablesList;	// Conjunto de listas de objetos

	public Model() {
		buttonTexts = new ArrayList<>();
		mainFieldsCoches = new ArrayList<>();
		mainFieldsPersonal = new ArrayList<>();
		mainFields = new ArrayList<>();
		tableNames = new ArrayList<>();
		cochesList = new ArrayList<>();
		personalList = new ArrayList<>();
		tablesList = new ArrayList<>();
		
		
		addButtonTexts(); 		// Anadir texto a los botones
		addMainFields();		// Anadir los campos base de cada tabla
		addTableNames(); 		// Anadir nombres de cada tabla
		addCochesDefault(); 	// Anadir coches por defecto en la tabla
		addPersonalDefault();	// Anadir personal por defecto en la tabla
	}

	
	private void addMainFields() {
		// Anadir campos de coches
		mainFieldsCoches.add("MARCA");
		mainFieldsCoches.add("COLOR");
		
		// Anadir campos de personal
		mainFieldsPersonal.add("NOMBRE");
		mainFieldsPersonal.add("CARGO");
		mainFieldsPersonal.add("SUELDO");
		
		// Anadir los Arrays de campos al array mainFields
		mainFields.add(mainFieldsCoches);
		mainFields.add(mainFieldsPersonal);
	}

	
	private void addCochesDefault() {
		cochesList.add(new MoCoches("Audi","Negro"));
		cochesList.add(new MoCoches("BMW","Blanco"));
		cochesList.add(new MoCoches("Toyota","Rojo"));
		cochesList.add(new MoCoches("Honda","Verde"));
		cochesList.add(new MoCoches("Citroen","Amarillo"));
		
		// Anadir el array de coches al array tableList
		tablesList.add(new ArrayList<>(cochesList));
		
	}
	
	private void addPersonalDefault() {
		personalList.add(new MoPersonal("Angel","Director",3000));
		personalList.add(new MoPersonal("Maria","Oficial",1500));
		personalList.add(new MoPersonal("juan","Medico",2700));
		personalList.add(new MoPersonal("Guadalupe","Informatico",1700));
		
		// Anadir el array de personal al array tableList
		tablesList.add(new ArrayList<>(personalList));
	}

	private void addTableNames() {
		tableNames.add("Tabla de Coches");		// 0
		tableNames.add("Tabla de Personal");	// 1
		
	}

	
	private void addButtonTexts() {
		buttonTexts.add("Anadir Coche");		//0
		buttonTexts.add("Anadir Persona");		//1
		
	}


	public ArrayList<String> getButtonTexts() {
		return buttonTexts;
	}


	public void setButtonTexts(ArrayList<String> buttonTexts) {
		this.buttonTexts = buttonTexts;
	}


	public ArrayList<String> getMainFieldsCoches() {
		return mainFieldsCoches;
	}


	public void setMainFieldsCoches(ArrayList<String> mainFieldsCoches) {
		this.mainFieldsCoches = mainFieldsCoches;
	}


	public ArrayList<String> getMainFieldsPersonal() {
		return mainFieldsPersonal;
	}


	public void setMainFieldsPersonal(ArrayList<String> mainFieldsPersonal) {
		this.mainFieldsPersonal = mainFieldsPersonal;
	}


	public ArrayList<ArrayList<String>> getMainFields() {
		return mainFields;
	}


	public void setMainFields(ArrayList<ArrayList<String>> mainFields) {
		this.mainFields = mainFields;
	}


	public ArrayList<String> getTableNames() {
		return tableNames;
	}


	public void setTableNames(ArrayList<String> tableNames) {
		this.tableNames = tableNames;
	}


	public ArrayList<MoCoches> getCochesList() {
		return cochesList;
	}


	public void setCochesList(ArrayList<MoCoches> cochesList) {
		this.cochesList = cochesList;
	}


	public ArrayList<MoPersonal> getPersonalList() {
		return personalList;
	}


	public void setPersonalList(ArrayList<MoPersonal> personalList) {
		this.personalList = personalList;
	}


	public ArrayList<ArrayList<Object>> getTablesList() {
		return tablesList;
	}


	public void setTablesList(ArrayList<ArrayList<Object>> tablesList) {
		this.tablesList = tablesList;
	}



}
