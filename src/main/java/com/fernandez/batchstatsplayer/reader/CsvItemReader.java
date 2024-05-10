package com.fernandez.batchstatsplayer.reader;

import com.fernandez.batchstatsplayer.model.dto.StatsPlayerBean;
import com.fernandez.batchstatsplayer.utils.Utils;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CsvItemReader extends FlatFileItemReader<StatsPlayerBean> {

    public CsvItemReader(@Value("${file}") String filePath) {
        setResource(new FileSystemResource(filePath));
        setLineMapper(createLineMapper(filePath));
        setLinesToSkip(1); // Skip the first line
    }

    private LineMapper<StatsPlayerBean> createLineMapper(String filePath) {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        DefaultLineMapper<StatsPlayerBean> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fields -> {
            String[] tokens = fields.getValues();
            StatsPlayerBean player = new StatsPlayerBean();
            // Asignar los valores a las propiedades del bean
            player.setName(tokens[0]);
            player.setTeam(tokens[1]);
            player.setPts(tokens[2]);
            player.setReb(tokens[3]);
            player.setAst(tokens[4]);
            player.setMin(tokens[5]);
            player.setFgm(tokens[6]);
            player.setFga(tokens[7]);
            player.set_2pm(tokens[8]);
            player.set_2pa(tokens[9]);
            player.set_3pm(tokens[10]);
            player.set_3pa(tokens[11]);
            player.setFtm(tokens[12]);
            player.setFta(tokens[13]);
            player.setPlusMinus(tokens[14]);
            player.setOffensiveRebounds(tokens[15]);
            player.setDr(tokens[16]);
            player.setPf(tokens[17]);
            player.setSt(tokens[18]);
            player.setTurnovers(tokens[19]);
            player.setBs(tokens[20]);
            player.setBa(tokens[21]);
            player.setTfm(tokens[22]);
            player.setMatchId(Utils.obtenerComponentes(filePath));
            return player;
        });
        return lineMapper;
    }
}
