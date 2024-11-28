package com.star.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConmonImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> imports = new ArrayList<String>();
        InputStream is = ConmonImportSelector.class.getClassLoader().getResourceAsStream("common.imports");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        try {
            while((line = br.readLine()) != null){
                imports.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return imports.toArray(new String[imports.size()]);
    }
}
