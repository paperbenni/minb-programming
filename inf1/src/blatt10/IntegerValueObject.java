package blatt10;

public class IntegerValueObject {

    final int i;
    IntegerValueObject(int i) {
        this.i = i;
    }
    
    /**
    * Werte zusammenzählen
    * @param j zweiter Summand
    * @return this.i + j als neues Value-Object
    */
    public IntegerValueObject add(int j) {
        return new IntegerValueObject(this.i + j);
    }
    
    /**
    * Werte zusammenzählen
    * @param j zweiter Summand
    * @return this.i + j als neues Value-Object
    */

    public IntegerValueObject mul(int j) {
        return new IntegerValueObject(this.i * j);
    }

    @Override
    public String toString() {
        return Integer.toString(this.i);
    }

}
