package com.cab.jachaubachau.app;

import de.daslaboratorium.machinelearning.classifier.Classification;
import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingDataSet {
    //defining logger for this classs
    public static Logger logger= Logger.getLogger(ReadingDataSet.class.getName());
    private Classifier<String,String> bayes=new BayesClassifier<String, String>();

    public  String readingDataSet(String fileName){
        //getting location upto Desktop
        String location=System.getProperty("user.home")+System.getProperty("file.separator")+"Desktop";
        //keep your file in the desktop and it should be named as Book1.xlsx so that this code reads it
        String fileLocation=location+System.getProperty("file.separator")+fileName;

        //reading file using apache poi api
        try (Workbook workbook = WorkbookFactory.create(new File(fileLocation))){

            int numberOfSheets=workbook.getNumberOfSheets();
            logger.log(Level.INFO,"Number of sheets found in document is "+numberOfSheets);
            int currentSheet=numberOfSheets-1;
            logger.log(Level.INFO,"Getting sheet # "+currentSheet);
            Sheet sheet= workbook.getSheetAt(currentSheet);
            logger.log(Level.INFO,"Reading the sheet #"+currentSheet);
            Iterator<Row> rowIterator= sheet.rowIterator();
            logger.log(Level.INFO,"# of data taken for training is "+sheet.getPhysicalNumberOfRows());

            //starting to read data from excel and feeding it in bayes learn
            // bayes.learn will be used to learn the cell values of every row in excel
            while(rowIterator.hasNext()){
                //keeping row in Row class object
                Row row=rowIterator.next();
                //iterating with the cell of current row
                Iterator<Cell> cellIterator=row.cellIterator();
                //looping in the cell
                logger.log(Level.INFO,"Reading cell values for training ");
                int i=0;
                String disease=null;
                String symptom=null;
                while(cellIterator.hasNext()){
                    if(i==0){
                        disease=cellIterator.next().toString();
                        logger.log(Level.INFO,"Disease recognized "+disease);
                        i++;
                    }
                    else {
                        symptom=cellIterator.next().toString();
                        bayes.learn(disease, Arrays.asList(symptom.toLowerCase().split("\\s")));
                        logger.log(Level.INFO,"Symptom for disease "+disease+" is "+symptom+" is taken for training");
                        i++;
                    }

                }
                logger.log(Level.INFO,"=================================================");

            }

            return "success";
        }catch (Exception e){

            logger.log(Level.SEVERE,"Error while reading file");
            return e.toString();
        }

    }
Collection<Classification<String, String>> output=null;
    public String classifyTheSymptom(String[] symptomsList){
        String toPredictString=String.join(" ",symptomsList);

        Classification<String, String> result=bayes.classify(Arrays.asList(toPredictString.split("\\s")));
        System.out.println("Classification Result");
        System.out.println("Disease classified ="+result.getCategory());
        System.out.println("=====Probability Result=====");
        output= ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(toPredictString.split("\\s")));
       
  return result.getCategory();
    }
    
    public Collection<Classification<String, String>> getOther(){
        return output;
    }




}
