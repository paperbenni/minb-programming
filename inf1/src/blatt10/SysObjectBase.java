package blatt10;

public abstract class SysObjectBase {
	private String name;
	private String owner;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public SysObjectBase(String name) {
		this.setName(name);
		this.setOwner(System.getenv("USERNAME"));
	}

	@Override
	public String toString() {
		return String.format("Class=%s, Name=%s, User=%s", this.getClass(), this.name, this.owner);
	}
}
