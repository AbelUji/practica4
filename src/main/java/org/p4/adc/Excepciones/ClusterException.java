package org.p4.adc.Excepciones;

public class ClusterException extends Exception{
    public ClusterException(){
        super("Numero de K diferente a N");
    }

}
