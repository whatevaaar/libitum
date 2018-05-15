package libitum;

import java.util.ArrayList;

public class Escenario {
    //las características dependeran del núemero del escenario
    protected int numescenario;
    protected String nomesce;
    protected SubEscenario subEsc;
    protected String descripesce;

    //SETTERS Y GETTERS
    public void setNumescenario() {}
    public int getNumescenario(){ return numescenario;}

    public void setNomesce(){}
    public String getNomesce(){return nomesce;}

    public void setDescripesce(){}

    public String getDescripesce()
    {
        return descripesce;
    }
}
