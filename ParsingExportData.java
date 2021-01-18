import edu.duke.*;
import org.apache.commons.csv.*;
public class ParsingExportData {
        public static void countryInfo(CSVParser parser, String country)
        {
            for (CSVRecord record : parser)
            {
                String countryName = record.get("Country");
                String exportItems = record.get("Exports");
                String value = record.get("Value (dollars)");
                if (countryName.contains(country))
                {
                    System.out.println(countryName + ": " + exportItems +": " +value);
                    System.out.println();
                }
            }
        }
        public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
            for (CSVRecord record : parser) {
                String exportItem = record.get("Exports");
                if (exportItem.contains(exportItem1) && exportItem.contains(exportItem2)) {
                    String country = record.get("Country");
                    System.out.println(country);
                }
            }
              System.out.println();
        }
       public static void numberOfExporters(CSVParser parser, String exportItem) {
           int countOfCountries = 0;
           for (CSVRecord record : parser) {
               String export = record.get("Exports");
               if (export.contains(exportItem)) {
                   String country = record.get("Country");
                   countOfCountries++;
               }
           }
           System.out.println(countOfCountries + " countries export " + exportItem + "\n");
       }

       public static void bigExporters(CSVParser parser, String amount) {
         for (CSVRecord record : parser)
         {
             String value = record.get("Value (dollars)");
             if(value.length()> amount.length())
             {
               //  System.out.println(value.length());
                 //System.out.println(amount.length());
                 System.out.println(record.get(("Country"))+" "+value);
             }
         }
       }

       public static void tester() {
            FileResource fr = new FileResource("exportdata.csv");
            CSVParser parser = fr.getCSVParser();
            countryInfo(parser, "Malaysia");
            parser = fr.getCSVParser();
            listExportersTwoProducts(parser, "gold", "meat");
            parser = fr.getCSVParser();
            numberOfExporters(parser, "coffee");
            parser = fr.getCSVParser();
            bigExporters(parser, "$164,400,000,000");
        }

        public static void main(String[] args) {
            ParsingExportData parseData = new ParsingExportData();
            parseData.tester();
        }
    }

