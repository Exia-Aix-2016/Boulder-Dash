package dao;

/**
 *Represente Parameters which used by CallStatement
 * the paramters with stocked routines can be IN OUT or INOUT
 */
public class Parameters {
    /**
     * Represente Object Parameter
     * @see Object
     * */
    private Object obj;
    /**
     * Type of this parameter (IN, OUT, INTOUT)
     * @see TypeParameters
     * */
    private TypeParameters typeParameters;

    /**
     * Contructor Parameters
     * @param o Object of this parameter
     * @param typeParameters Type of this Parameter OUT, IN, INOUT
     * @see TypeParameters
     * @see Object
     * */
    public Parameters(final Object o, final TypeParameters typeParameters){
        this.obj = o;
        this.typeParameters = typeParameters;
    }

    /**
     * Set parameter object
     * @param obj Take any type (Integer, String)
     * @see Object
     * */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * Set Type of this Parameter
     * @param typeParameters IN, OUT, INOUT
     *  @see TypeParameters
     * */
    public void setTypeParameters(TypeParameters typeParameters) {
        this.typeParameters = typeParameters;
    }

    /**
     * @return Object of this parameter
     * @see Object
     * */
    public Object getObj() {
        return obj;
    }

    /**
     * @return Type of this Parameter
     * @see TypeParameters
     * */
    public TypeParameters getTypeParameters() {
        return typeParameters;
    }
}
