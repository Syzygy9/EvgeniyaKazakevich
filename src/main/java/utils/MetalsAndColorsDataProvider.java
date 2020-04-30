package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import hw_jdi.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class MetalsAndColorsDataProvider {

    private static final String PATH = "src/test/resources/metalsAndColorsDataSet.json";

    @DataProvider
    public Iterator<Object[]> dataProvider() {
        List<MetalsAndColorsData> students = MetalsAndColorsDataProvider.readData();
        Collection<Object[]> data = new ArrayList<Object[]>();
        students.forEach(item -> data.add(new Object[]{item}));
        return data.iterator();
    }

    public static List<MetalsAndColorsData> readData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = mapper.getTypeFactory();
        try {
            File json = new File(PATH);
            MapLikeType mapType =
                    factory.constructMapLikeType(Map.class, String.class, MetalsAndColorsData.class);
            Map<String,MetalsAndColorsData> map = mapper.readValue(json, mapType);
            return  new ArrayList<MetalsAndColorsData>(map.values());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }






}