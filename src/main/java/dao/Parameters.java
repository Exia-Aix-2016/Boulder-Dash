package dao;

/**
 *
 */
public class Parameters {
    private Object obj;
    private TypeParameters typeParameters;

    public Parameters(final Object o, final TypeParameters typeParameters){
        this.obj = o;
        this.typeParameters = typeParameters;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setTypeParameters(TypeParameters typeParameters) {
        this.typeParameters = typeParameters;
    }

    public Object getObj() {
        return obj;
    }

    public TypeParameters getTypeParameters() {
        return typeParameters;
    }
}
