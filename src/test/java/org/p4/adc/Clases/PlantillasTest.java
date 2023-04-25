package org.p4.adc.Clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.p4.adc.Constructores.TableWithLabels;
import org.p4.adc.Patrones.EuclideanDistance;
import org.p4.adc.Patrones.ManhattanDistance;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlantillasTest {
    CSV miCSV;
    KNN miKNN;
    TableWithLabels table;
    private List<Double> lista0,lista1,lista2,lista3,lista4;

    @BeforeEach
    void antesDe() throws FileNotFoundException {
        miCSV=new CSV();
        miKNN=new KNN(new EuclideanDistance());

        lista0=Arrays.asList(5.0,0.0,7.0,1.0);
        lista1=Arrays.asList(5.0,5.0,5.0,5.0);
        lista2=Arrays.asList(3.6,3.9,1.9,6.4);
        lista3=Arrays.asList(-1.0,-1.0,-1.0,-1.0);
        lista4=Arrays.asList(0.0,0.0,0.0,0.0);

        table=miCSV.readTableWithLabels("src\\main\\resources\\files\\iris.csv");
        miKNN.train(table);
    }
    @Test
    void estimate() {
        assertEquals(3,miKNN.estimate(lista0));
        assertEquals(3,miKNN.estimate(lista1));
        miKNN.setDistance(new ManhattanDistance());
        assertEquals(1,miKNN.estimate(lista3));
        assertEquals(1,miKNN.estimate(lista4));
    }

}