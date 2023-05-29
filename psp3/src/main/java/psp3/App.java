package psp3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) 
    {
        // Table 1: Data for LOC and method counts
        int[] locValues = {
            18, 18, 25, 31, 37, 82, 82, 87, 89, 230, 85, 87, 558
        };
        int[] methodCounts = {
            3, 3, 3, 3, 3, 5, 4, 4, 4, 10, 3, 3, 10
        };

        // Table 2: Data for page counts by chapter
        int[] pageCounts = {
            7, 12, 10, 12, 10, 12, 12, 12, 12, 8, 8, 8, 20, 14, 18, 12
        };

        // Calculate size ranges for LOC
        double[] locLogarithmicValues = new double[locValues.length];
        for (int i = 0; i < locValues.length; i++) {
            locLogarithmicValues[i] = Math.log(locValues[i]);
        }
        double locMean = StatisticsCalculator.calculateMean(locLogarithmicValues);
        double locVariance = StatisticsCalculator.calculateVariance(locLogarithmicValues, locMean);
        double locStandardDeviation = Math.sqrt(locVariance);
        double lnPPLoc = locMean - 2 * locStandardDeviation;
        double lnPLoc = locMean - locStandardDeviation;
        double lnMLoc = locMean;
        double lnGLoc = locMean + locStandardDeviation;
        double lnGGLoc = locMean + 2 * locStandardDeviation;
        double PPLoc = Math.exp(lnPPLoc);
        double PLoc = Math.exp(lnPLoc);
        double MLoc = Math.exp(lnMLoc);
        double GLoc = Math.exp(lnGLoc);
        double GGLoc = Math.exp(lnGGLoc);

        // Calculate size ranges for page counts
        double[] pageLogarithmicValues = new double[pageCounts.length];
        for (int i = 0; i < pageCounts.length; i++) {
            pageLogarithmicValues[i] = Math.log(pageCounts[i]);
        }
        double pageMean = StatisticsCalculator.calculateMean(pageLogarithmicValues);
        double pageVariance = StatisticsCalculator.calculateVariance(pageLogarithmicValues, pageMean);
        double pageStandardDeviation = Math.sqrt(pageVariance);
        double lnPPPage = pageMean - 2 * pageStandardDeviation;
        double lnPPage = pageMean - pageStandardDeviation;
        double lnMPage = pageMean;
        double lnGPage = pageMean + pageStandardDeviation;
        double lnGGPage = pageMean + 2 * pageStandardDeviation;
        double PPPage = Math.exp(lnPPPage);
        double PPage = Math.exp(lnPPage);
        double MPage = Math.exp(lnMPage);
        double GPage = Math.exp(lnGPage);
        double GGPage = Math.exp(lnGGPage);

        // Display the results for LOC
        System.out.println("Size Ranges for LOC:");
        System.out.println("PP: " + PPLoc);
        System.out.println("P: " + PLoc);
        System.out.println("M: " + MLoc);
        System.out.println("G: " + GLoc);
        System.out.println("GG: " + GGLoc);
        System.out.println();

        // Display the results for page counts
        System.out.println("Size Ranges for Page Counts:");
        System.out.println("PP: " + PPPage);
        System.out.println("P: " + PPage);
        System.out.println("M: " + MPage);
        System.out.println("G: " + GPage);
        System.out.println("GG: " + GGPage);
        System.out.println();
    }
}

    

