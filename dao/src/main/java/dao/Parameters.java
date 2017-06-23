package dao;

/**
 *Represente Parameters which used by CallStatement
 * the paramters with stocked routines can be IN OUT or INOUT
 * it is a generic Class
 * @version 1.0
 */
public class Parameters<T> {
    /**
     * Represente Object Parameter
     * @see Object
     * */
    private T obj;
    /**
     * Type of this parameter (IN, OUT, INTOUT)
     * @see TypeParameters
     * */
    private TypeParameters typeParameters;

    /**
     * Contructor Parameters
     * @param obj Object of this parameter
     * @param typeParameters Type of this Parameter OUT, IN, INOUT
     * @see TypeParameters
     * @see Object
     * */
    public Parameters(final T obj, final TypeParameters typeParameters){
        this.obj = obj;
        this.typeParameters = typeParameters;
    }

    /**
     * Set parameter object
     * @param obj Take any type (Integer, String)
     * @see Object
     * */
    public void setObj(T obj) {
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
    public T getParameter() {
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
