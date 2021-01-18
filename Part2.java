public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        if( Character.isUpperCase(dna.charAt(0)) ) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startCodonIndex = dna.indexOf(startCodon);
        int stopCodonIndex = dna.indexOf(stopCodon, startCodonIndex+3);
        if (startCodonIndex == -1 || stopCodonIndex == -1)
            return "No Gene found in the DNA ";
        if ((stopCodonIndex - startCodonIndex) % 3 == 0)
            return dna.substring(startCodonIndex, stopCodonIndex + 3);
        else
            return "No Gene found in the DNA";
    }
    public void testSimpleGene() {
        String dna[] = new String[7];
        dna[0] = "CCAGGGAGGGATAAGA"; //NO ATG
        dna[1] = "AGGGGTTTATGACTGAA"; // NO TAA
        dna[2] = "CCCCATACTGGGTTTTC"; // NO ATG NO TAA
        dna[3] = "CCATGAAGACAGGGTAACTA"; //multiple of 3
        dna[4] = "ATGAGCCCCCTGTGTAA"; //not multiple of 3
        dna[5] = "ccagcatgccagtcagctaacag";
        dna[6] = "ccaagtagc";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        for (int i = 0; i <7; i++) {
            String result = findSimpleGene(dna[i], startCodon, stopCodon);
            System.out.println(result);
        }
    }
    public static void main(String[] args)
    {
        Part2 p = new Part2();
        p.testSimpleGene();
    }
}
