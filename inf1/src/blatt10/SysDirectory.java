package blatt10;

public class SysDirectory extends SysObjectBase {
	private SysObjectBase[] sysObjects;

	/**
	 * 
	 * Konstruktor
	 * 
	 * @param name Name des Verzeichnisses
	 * @param sysObjects Inhalt
	 */
	public SysDirectory(String name, SysObjectBase... sysObjects) {
		super(name);
		this.setObjects(sysObjects);
	}
	
	/**
	 * 
	 * @return Inhalt des Verzeichnisses
	 */
	public SysObjectBase[] getObjects() {
		return this.sysObjects;
	}
	
	/**
	 * Inhalt verandern
	 * @param objects neuer Inhalt
	 */
	public void setObjects(SysObjectBase[] objects) {
		this.sysObjects = objects;
	}

	
	@Override
	public String toString() {
		return String.format("%s, NumberOfObjects=%i", super.toString(), this.sysObjects.length);
	}

	/**
	 * Filetree ausgeben
	 * @param indent Tiefenmarkierung
	 * @param depth
	 * @return
	 */
	public String dirStructure(String indent, int depth) {
		// default indent
		if (indent.equals("")) {
			indent = "| - ";
		}
		String ret;
		ret = String.format("\n%s%s", indent.repeat(depth), this.toString());
		for (SysObjectBase object : this.sysObjects) {
			if (object instanceof SysDirectory) {
				ret = ret + dirStructure(indent, depth + 1);
			}
		}
		return ret;
	}

	/**
	 * Test methode
	 * @param args
	 */
	public static void main(String[] args) {
		SysTextFile hello = new SysTextFile("Hello", "java");
		hello.setText("public class HelloWorld{/*...*/}");
		SysTextFile test = new SysTextFile("Test", "java");
		SysTextFile prt = new SysTextFile("PrintClass", "java");
		SysDirectory srcDir = new SysDirectory("SRC", hello, test, prt);
		SysTextFile todo = new SysTextFile("Todos", "txt");
		SysTextFile toget = new SysTextFile("Eggs", "rtm");
		SysDirectory txtDir = new SysDirectory("txt", todo, toget);
		SysDirectory home = new SysDirectory("home", srcDir, txtDir);
		srcDir.setName("SRC");
		toget.setName("Einkaufsliste");
		home.setName("HOME");
		home.setOwner("brul0001");
		System.out.printf("%s\n", home);
		System.out.printf("%s\n", home.dirStructure("", 0));

	}

}
