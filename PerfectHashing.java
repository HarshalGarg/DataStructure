

package perfect.hashing;
import java.io.*;
import java.util.*;
/**
 *
 * @author honey
 */
public class PerfectHashing {
static long P[]={5915587277l,1500450271l,3267000013l,5754853343l,4093082899l,9576890767l,
    3628273133l,2860486313l,5463458053l,3367900313l};

    static long[] num=new long[1000000];//={546735300l, 1031524671l, 2028068429l, 882184373l, 2131688424l, 1783649060l, 2057432445l, 1568114351l, 
            //2083233261l, 1972347766l,}; 
static int a1,b1;
static long p1;
    /**
     * @param args the command line arguments
     */

static boolean verifyabp(int a,int b,long p,int m,int t,int f)
{
    if(m==0)
        return true;
long ht[]=new long[m];
for(int i=0;i<t;i++)
{
    Long val=((a*num[i]+b)%p)%m;
    int val1=val.intValue();
 
ht[val1]++;
    
}
if(f==0){
for(int i=0;i<m;i++)
{
if(ht[i]*ht[i]>t)
    return false;
}}
else
for(int i=0;i<m;i++)
{
    if(ht[i]>1)
        return false;
}
return true;
}
    public static void main(String[] args) throws Exception {
  //  BufferedReader br=new BufferedReader(new FileReader("F:\\input.txt")); 
    Scanner read = new Scanner (new File("F:\\input.txt"));
read.useDelimiter(" ");
int i4=0;
        while(read.hasNext())
        num[i4++]=read.nextLong();
      //  System.out.println(i4);
        Random rand=new Random();
        int i=0;int a=0,b=0;
             while(true){
             a=rand.nextInt();
              b=rand.nextInt();
              if(a<0)
     a*=(-1);
              if(b<0)
     b*=(-1);
            boolean flag=verifyabp(a,b,P[i],2000000,1000000,0);
            if(flag)
            {
            a1=a;
            b1=b;
            p1=P[i];
            break;
            }
             i=rand.nextInt()%10;
             }
             long[][] ht=new long[2000000][];
             int[]ht1=new int[2000000];
             for(int j=0;j<1000000;j++)
             {
             Long val=((a1*num[j]+b1)%p1)%2000000;
             int val1=val.intValue();
            ht1[val1]++;
             }
             int[] ns=new int[2000000];
             for(int j=0;j<2000000;j++)
             {
             ns[j]=ht1[j]*ht1[j];    
             ht[j]=new long[ns[j]];
             
             }
        
             int a2[]=new int[2000000];
             int b2[]=new int[2000000];
             long p2[]=new long[2000000];
             i=0;
             for(int ii=0;ii<2000000;ii++){
            if(ns[ii]==0)
                continue;
                 while(true){
           
             a=rand.nextInt();
              b=rand.nextInt();
              if(a<0)
     a*=(-1);
              if(b<0)
     b*=(-1);
            boolean flag=verifyabp(a,b,P[i],ns[ii],(int)Math.sqrt(ns[ii]),1);
            if(flag)
            {
            a2[ii]=a;
            b2[ii]=b;
            p2[ii]=P[i];
            break;
            }
            i=rand.nextInt();
            if(i<0)
                i*=-1;
             i=i%10;
             } 
             }
             
             for(int k=0;k<1000000;k++)
             {
             Long x=((a1*num[k]+b1)%p1)%2000000;
             int y=x.intValue();
             if(ns[y]==0)
                 continue;
             Long z=((a2[y]*num[k]+b2[y])%p2[y])%(ns[y]);
             int z1=z.intValue();
             ht[y][z1]=num[k];
             }
             /*for(int i1=0;i1<2000000;i1++)
             {
             for(int i2=0;i2<ns[i1];i2++)
             {
                 if(ht[i1][i2]!=0)
                 System.out.print(ht[i1][i2]+" ");
             }
                 System.out.println("");
             }*/
             
        //System.out.println(a1+" "+b1+" "+p1);
             long check=546735300l;
    Long xx=((a1*check+b1)%p1)%2000000;
    int yy=xx.intValue();
    xx=((a2[yy]*check+b2[yy])%p2[yy])%ns[yy];
    int yy1=xx.intValue();
        System.out.println(ht[yy][yy1]);
    }}
