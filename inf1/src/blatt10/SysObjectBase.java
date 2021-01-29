package blatt10;

public abstract class SysObjectBase {
	private String name;
	private String owner;
	
	/**
	 * 
	 * @param Objekt name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Besitzer setzen
	 * @param Besitzer
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	/**
	 * 
	 * @param Objekt Name
	 */
	public SysObjectBase(String name) {
		this.setName(name);
		this.setOwner(System.getenv("USERNAME"));
	}
	
	/**
	 * Objekt informationen ausgeben
	 */
	@Override
	public String toString() {
		return String.format("Class=%s, Name=%s, User=%s", this.getClass(), this.name, this.owner);
	}
}
