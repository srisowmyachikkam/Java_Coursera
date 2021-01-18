import edu.duke.*;
import java.io.*;
public class Part1
    {
        public String findSimpleGene(String dna) {
            int startCodon = dna.indexOf("ATG");
            int stopCodon = dna.indexOf("TAA");
            if (startCodon == -1 || stopCodon == -1)
                return "";
            if ((stopCodon - startCodon) % 3 == 0) {
                return dna.substring(startCodon, stopCodon + 3);
            }
            else
                return "";
        }
        public void testSimpleGene() {
            String dna[] = new String[5];
            dna[0] = "CCAGGGAGGGATAAGA"; //NO ATG
            dna[1] = "AGGGGTTTATGACTGAA"; // NO TAA
            dna[2] = "CCCCATACTGGGTTTTC"; // NO ATG NO TAA
            dna[3] = "CCATGAAGACAGGGTAACTA"; //multiple of 3
            dna[4] = "ATGAGCCCCCTGTGTAA"; //not multiple of 3
            for (int i = 0; i < 5; i++) {
                String result = findSimpleGene(dna[i]);
                if (result != "")
                {
                    System.out.println("The DNA is : " + dna[i]);
                    System.out.println("The Gene is : " + result);
                }
                else
                    {
                    System.out.println("The DNA is : "+dna[i]);
                    System.out.println("It has no Gene, Empty String ");
                    }
            }
        }

        public static void main(String args[]) {
            Part1 p = new Part1();
            p.testSimpleGene();

        }

    }

