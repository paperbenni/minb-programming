package blatt10;

public class SysTextFile extends SysObjectBase {

	private String type;
	private String text;

	public SysTextFile(String name, String type) {
		super(name);
		this.setType(type);
	}

	/**
	 * Dateiinhalt verandern
	 * 
	 * @param Dateiinhalt
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Dateiinhalt bekommen
	 * 
	 * @return
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Dateityp setzen
	 * 
	 * @param Dateityp
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return String.format("%s, Type=%s, Length=%i: %s", super.toString(), this.type, this.text.length(), this.text);
	}

	public static void main(String[] args) {
		SysTextFile stf = new SysTextFile("Hello", "java");
		stf.setText("public class HelloWorld{/*...*/}");
		System.out.printf("%s:\n %s\n\n", stf, stf.getText());
	}

}
