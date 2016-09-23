
import com.sun.xml.internal.ws.util.StringUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

public class table_frequency {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // initializing unsorted double array
//        double dArr[] = {99.52, 99.62, 98.8842};
//        double dArr1[] = {98.9, 98.96, 97.536 };
//        
//        System.out.println("dArr:" + dArr[0]);
//        ArrayList k = new ArrayList();
//        ArrayList max = new ArrayList();
//        ArrayList getMax = new ArrayList();
//
//        System.out.println("--------------------------FIRST ALGORITHM---------------------------------------");
//        k.add(table_frequency1(dArr, 10));
//
//        System.out.println("--------------------------SECOND ALGORITHM---------------------------------------");
//        table_frequency1(dArr1, 10);
//        k.add(table_frequency1(dArr1, 10));
//
//        System.out.println("kkkkkkkkkkkkkkkkkkk:" + k);
//        checkDuplicate(k);
//
//        for (int uy = 0; uy < k.size(); uy++) {
//            String ju = k.get(uy).toString();
//            String ju1 = ju.substring(ju.length() - 2, ju.length() - 1);
//            max.add(ju1);
//            final double before = Double.parseDouble(ju.split("-")[0].substring(1)); // "Before"
//            final String after = ju.split("-")[1]; // "After"
//            final double after1 = Double.parseDouble(after.split("=")[0]); // "After"
//            
//            
//            getMax.add(before);
//            System.out.println("before: " + before);
//            System.out.println("after: " + after1);
//            
//        }
//        System.out.println("\nThe max total of Interval: " + Collections.max(max));
//        for (int y = 0; y < k.size(); y++) {
//            String ko = Collections.max(max).toString();
//            String io = Collections.max(getMax).toString();
//            
//            if (k.get(y).toString().contains("="+ko) && k.get(y).toString().contains(io)) {            
//                
//                if(dArr.toString().contains(io)){
//                    System.out.println("FIRST ALGORITHM:"+k.get(y));
//                }
//                else if(dArr1.toString().contains(io))
//                {
//                    System.out.println("SECOND ALGORITHM:"+k.get(y));
//                }
//            }
//        }
    }

    public static ArrayList table_frequency1(double dArr[], double clsInterval, JTextArea jt) {
        // sorting array
        double nmbrClsInterval;
        String ki = "";
        String iy = "";
        String lastToken = "";
        String SAMPLE_STRING = "";
        String StringEnds = "";

        int counter = 0;
        int count = 0;

        double aDouble11 = 0;
        double aDouble1 = 0, aDouble = 0;
        double rounded = 0;
        double rounded1 = 0;

        ArrayList elementList = new ArrayList();
        ArrayList cb = new ArrayList();
        ArrayList roundedList = new ArrayList();
        ArrayList rounded1List = new ArrayList();
        ArrayList ki1 = new ArrayList();
        ArrayList h = new ArrayList();
        ArrayList intervalAll = new ArrayList();

        Arrays.sort(dArr);
        ArrayList<Double> dList = new ArrayList<Double>(dArr.length);
        System.out.println("Sorted data:");
        jt.append("\n" + "Sorted data:");

        for (double d : dArr) {
            dList.add(d);
        }
        System.out.println(dList);
        jt.append("\n" + dList);

        //tableFrequency(dArr);
        double difference = getMaxValue(dArr) - getMinValue(dArr);
        System.out.println("\nMax: " + getMaxValue(dArr));
        jt.append("\n" + "\nMax: " + getMaxValue(dArr));
        System.out.println("Min: " + getMinValue(dArr));
        jt.append("\n" + "Min: " + getMinValue(dArr));
        System.out.println("Difference: " + difference);
        jt.append("\n" + "Difference: " + difference);
        nmbrClsInterval = difference / clsInterval;
        System.out.println("\nNumber of Class Interval: " + bulat(nmbrClsInterval));
        jt.append("\n\n" + "Number of Class Interval: " + bulat(nmbrClsInterval));

        int chunk = dList.size() / (int) bulat(nmbrClsInterval); // chunk size to divide


        for (int i = 0; i < dArr.length; i += chunk) {
            iy = Arrays.toString(Arrays.copyOfRange(dArr, i, i + chunk));
            String f = iy.split(",")[0].substring(1);
            aDouble = Double.parseDouble(f);
            rounded = (double) Math.floor(aDouble * 10) / 10;

            String[] f1 = iy.split(",");

            for (int y = 1; y < f1.length; y++) {
                String lastToken1 = f1[y];
                aDouble11 = Double.parseDouble(lastToken1.replaceAll("]", ""));
                if (aDouble11 == 0.0) {
                    counter++;
                }
            }
            if (aDouble11 == 0.0) {
                lastToken = f1[f1.length - (counter + 1)].replace("[", "");
            } else {
                lastToken = f1[f1.length - 1];
            }
            aDouble1 = Double.parseDouble(lastToken.replaceAll("]", ""));
            rounded1 = (double) Math.ceil(aDouble1 * 10) / 10;

            System.out.println(aDouble + " rounded is " + rounded);
            System.out.println(aDouble1 + " rounded1 is " + rounded1);

            for (int u = 0; u < dArr.length; u++) {

                if (dArr[u] > rounded && dArr[u] < rounded1) {
                    SAMPLE_STRING = dArr[u] + " Interval: " + aDouble + " - " + aDouble1;
                    System.out.println(SAMPLE_STRING);
                    jt.append("\n" + SAMPLE_STRING);
                    cb.add(SAMPLE_STRING);

                }
            }
            elementList.add(iy);
            roundedList.add(rounded);
            rounded1List.add(rounded1);
            Pattern p = Pattern.compile(aDouble + " - " + aDouble1);
            Matcher m = p.matcher(cb.toString());
            count = 0;

            while (m.find()) {
                count += 1;
            }
            h.add(count);
            ki = aDouble + " - " + aDouble1 + "=" + count;
            System.out.println("Count data on the same interval : " + ki + "\n");
            jt.append("\n" + "Count data on the same interval : " + ki + "\n");
            ki1.add(ki);

        }
        StringEnds = Collections.max(h).toString();
        for (int ui = 0; ui < ki1.size(); ui++) {
            if (ki1.get(ui).toString().endsWith(StringEnds)) {
                System.out.println("The most data appear in interval :" + ki1.get(ui) + "\n");
                jt.append("\n" + "The most data appear in interval :" + ki1.get(ui) + "\n");
                intervalAll.add(ki1.get(ui));
            }

        }
//        System.out.println("intervalAll::::" + intervalAll);
//        jt.append("\n" + "intervalAll::::" + intervalAll);
        return intervalAll;

    }

    public static boolean checkDuplicate(ArrayList list, JTextArea jt) {
        HashSet set = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            boolean val = set.add(list.get(i));
            if (val == false) {
                System.out.println("true");
                System.out.println("Same Interval:" + list.get(i));
                jt.append("Same Interval:" + list.get(i));
                return val;
            }
        }
        return true;
    }

    // getting the maximum value
    public static double getMaxValue(double[] array) {
        double maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];

            }
        }
        return maxValue;
    }

// getting the miniumum value
    public static double getMinValue(double[] array) {
        double minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static double bulat(double r) {
        int decimalPlace = 0;
        BigDecimal bd = new BigDecimal(r);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_UP);
        r = bd.doubleValue();

        return r;
    }

    public static void tableFrequency(ArrayList elementList) {
        Hashtable frequencyHash = new Hashtable();

        ArrayList uniqueList = new ArrayList();

        for (int i = 0; i < elementList.size(); i++) {
            if (uniqueList.contains(elementList.get(i))) {
                int elementCount =
                        Integer.parseInt(frequencyHash.get(elementList.get(i)).toString());

                elementCount++;
                frequencyHash.put(elementList.get(i), elementCount);
            } else {
                uniqueList.add(elementList.get(i));
                frequencyHash.put(elementList.get(i), 1);
            }
        }
        System.out.println(frequencyHash);
    }
}
