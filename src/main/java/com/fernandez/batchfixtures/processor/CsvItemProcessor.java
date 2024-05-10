package com.fernandez.batchfixtures.processor;

import com.fernandez.batchfixtures.model.dto.FixturesBean;
import com.fernandez.batchfixtures.model.entity.Fixtures;
import com.fernandez.batchfixtures.reader.CsvItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvItemProcessor implements ItemProcessor<FixturesBean, Fixtures> {

    private final CsvItemReader csvItemReader;

    @Autowired
    public CsvItemProcessor(CsvItemReader csvItemReader) {
        this.csvItemReader = csvItemReader;
    }

    @Override
    public Fixtures process(FixturesBean item) throws Exception {
        Fixtures results = new Fixtures();
        results.setMatchId(item.getMatchId());
        results.setHomeTeam(item.getHomeTeam());
        results.setAwayTeam(item.getAwayTeam());
        results.setMatchId(item.getMatchId());
        results.setEventTime(item.getEventTime());

        // Obtener los componentes del nombre del archivo utilizando CsvItemReader
        String[] componentes = csvItemReader.obtenerComponentesDelNombreDelArchivo();
        if (componentes.length >= 3) {
            results.setDateFile(componentes[0]);
            results.setCountry(componentes[1]);
            results.setCompetition(componentes[2]);
        } else {
            System.out.println("No se pudieron obtener todos los componentes del nombre del archivo.");
        }

        return results;
    }
}
