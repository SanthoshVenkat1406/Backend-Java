import java.util.*;
public class Even
{
public static void main (String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number: ");
int n=sc.nextInt();
System.out.println("Even numbers less than or equal to" + n + " :");
for(int i=0;i<=n;i+=2)
{
System.out.println(i+" ");
}
}
}

