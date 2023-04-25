package org.p4.adc.Interfaces;

import org.p4.adc.Constructores.Table;
import org.p4.adc.Excepciones.ClusterException;

import java.util.List;

public interface Algorithm<T extends Table> {
    void train(T datos) throws ClusterException;
    Integer estimate(List<Double> dato);
}
