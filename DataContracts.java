import java.util.Scanner;
/**
*Foward code
*/
public class DataContracts {

    public static void main(String[] args) {
        Scanner kb =new Scanner(System.in);
     double[] month={1,2,3,4,5,6}; 
     double[] vContract={0,0,0,0,0,0};
     double[] mContract={125000.00,205000.00,180000.00,230000.00,310000.00,65000.00};
     double[] cContract={120000.00,135000.00,200000.00,250000.00,350000.00,85000.00};
     double[] tContract={100000.00,99000.00,165000.00,205000.00,305000.00,55000.00};
     double[] avrSales={0,0,0,0,0,0};
     populateVContract(vContract);
     
     int Option=getUserOption();
     while(Option!=4)
     {
            switch (Option) {
                case 1:
                    displayContractDitails(vContract,mContract,cContract,tContract,month,determineTotal(vContract), determineTotal(mContract),determineTotal(cContract),determineTotal(tContract));
                    break;
                case 2:
                    System.out.println("Enter the month with the higest sale(1-6)");
                    int monthUser=kb.nextInt()-1;
                    System.out.println(determineHighestSales(vContract,mContract,cContract,tContract,monthUser));
                    break;
                case 3:
                    System.out.println("Avarage Sales");
                    calAvgSales(vContract,mContract,cContract,tContract,avrSales);
                    for (int i = 0; i < avrSales.length; i++)
                    {
                        
                        System.out.println("Month"+(i+1)+": "+avrSales[i]);

                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        Option=getUserOption(); 
     }
    }
    public static void populateVContract(double[] vCont)
    {
        Scanner kb=new Scanner(System.in);
        for (int i = 0; i < vCont.length; i++)
        {

                System.out.print("Enter the monthly sales amount for month "+(i+1)+": ");
                vCont[i]=kb.nextDouble();
                boolean val=validateSales(vCont[i]);
             while(val==false)
            {

                System.out.print("Reenter the monthly sales amount for month "+(i+1)+": ");
                vCont[i]=kb.nextDouble();
                val=validateSales(vCont[i]);

            }
        }
    }
    public static boolean validateSales(double sale)
    {
        boolean validate=false;
        if(sale>=0 && sale <=600000)
        {
            validate=true;
        }
     return validate;
    }
    public static int getUserOption()
    {
        Scanner keyb=new Scanner(System.in);
        System.out.println("Select any option to start:\n"
                + "1 Display all contract details\n"
                + "2 Check highest sales contract\n"
                + "3 Avarage Sales\n"
                + "4 Exit");
        int Option=keyb.nextInt();
        return Option;
    }
    public static double determineTotal(double[] contractType)
    {
        double totalCont=0;
        for (int i = 0; i < contractType.length; i++)
        {

            totalCont+=contractType[i];

        }
        return totalCont;
    }
    public static void calAvgSales(double[] vCont,double[] mCont, double[] cCont,double[] tCont,double[] avrSale)
    {
        for(int i = 0; i <avrSale.length ; i++) 
        {

            avrSale[i]=(vCont[i]+mCont[i]+cCont[i]+tCont[i])/4;

        }
    }
    public static String determineHighestSales(double[] vCont,double[] mCont, double[] cCont,double[] tCont, int month)
    {
        double highest=vCont[month];
        String data="Best sales for month "+(month+1)+": V contract ("+highest+")";
       
            if(highest<mCont[month])
            {
                highest=mCont[month];
                data="Best sales for month "+(month+1)+": M contract ("+highest+")";
            }
            if(highest<cCont[month])
            {
                 highest=cCont[month];
                 data="Best sales for month "+(month+1)+": C contract ("+highest+")";
            }
            if(highest<tCont[month])
            {
                 highest=tCont[month];
                 data="Best sales for month "+(month+1)+": T contract ("+highest+")";
            }
        return data;
    }
    public static void displayContractDitails(double[] vCont,double[] mCont, double[] cCont,double[] tCont,double[] month,double vTotal,double mTotal,double cTotal,double tTotal)
    {
        System.out.println("Month\tVContract\tMContract\tCContract\tTContract"); 
        for (int i = 0; i < vCont.length; i++) {
            System.out.println((int)month[i]+"\t"+vCont[i]+" \t"+mCont[i]+"\t"+cCont[i]+"\t "+tCont[i]);
        }
        System.out.println("==================================================================================================================================\n"
                + "\t"+vTotal+"\t"+mTotal+"\t"+cTotal+"\t"+tTotal);
    }
 
}