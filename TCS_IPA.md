# TCS iON IPA Java Assessment — Questions & Solutions

Compiled from your hands-on test reports (Test 1, Test 2, Test 3). Each question below shows your best-scoring, fully passing submission.


---

## Test 1

### Question 1

Write main method in Solution class.

In the main method,  read five values for an integer array and two int value which are the limits (limit1 and limit2). The main method should print the average of integer values which are greater than limit1 and less than limit2.
For example if the values are 1,2,3,4,5 and the limits are 2 and 6 then the average is 4((3+4+5)/3). The output should be in the format of sample output.

Note : The returned average value should be of int data type.

Sample input1:
1
2
3
4
5
2
6

Output:
4

Sample input2:
100
200
300
400
500
100
500

Output:
300

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your solution.
--------------------------------------------------

public class Solution
{

	public static void main(String[] args)
	{
		//code to read values 
		//code to display the result
	}

	}

-------------------------------------------------


**Result:** 15 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;
public class MyClass{
	public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
      	int[] arr = new int[5];
      	int limit1 = 0;
      	int limit2 = 0;
      	for(int i=0 ;  i<arr.length ;i++){
        	arr[i] =  sc.nextInt();
        }
      	limit1 = sc.nextInt();
      	limit2 = sc.nextInt();
      	
      	List<Integer>  list =  new ArrayList<>();
      	
      	for(int i = 0;i<arr.length;i++){
          if(arr[i]>limit1 && arr[i]<limit2){
          	list.add(arr[i]);
          }
        }
      	
      	int sum = 0;
      	
      for(int i = 0; i<list.size();i++){
      	sum+=list.get(i);
      }
      int avg = sum/list.size();
      
      System.out.println(avg);
      sc.close();
      
    }
}
```

### Question 2

Create a class Player with below attributes:

playerId - int
playerName - String
runs - int 
playerType - String
matchType - String

The above attributes should be private, write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement two static methods - findPlayerWithLowestRuns and findPlayerByMatchType in Solution class.

findPlayerWithLowestRuns method:
This method will take array of Player objects and a String value as input parameters. 
The method will return the least runs of the Player from array of Player objects for the given player type.
(String parameter passed). If no Player with the above condition are present in array of Player objects, 
then the method should return 0.

findPlayerByMatchType method:
This method will take array of Player objects and String value as input parameters and return the array of Player objects 
belonging to the match type passed as input parameter in Descending order of playerId.
If no Player with the above condition are present in the array of Player objects, then the method should return null.

Note : No two Players will have the same playerId and runs.
       All the searches should be case insensitive.

The above mentioned static methods should be called from the main method. 

For findPlayerWithLowestRuns  method - The main method should print the returned runs as it is
 if the returned value is greater than 0 or it should print "No such player".

Eg: 25
where 25 is the lowest runs of the Player.

For findPlayerByMatchType method - The main method should print the playerId from the returned Player array for each 
Player if the returned value is not null. 
If the returned value is null then it should print "No Player with given matchType".

Eg:
13
11
where 13 and 11 are the playerId's.

Before calling these static methods in main, use Scanner object to read the values of four Player
objects referring attributes in the above mentioned attribute sequence. 
Next, read the value of two String parameter for capturing player type and match Type.

Consider below sample input and output:

Input1:
11
Sachin
100
International
One day
12
Shewag
133
International
Test
13
Varun
78
State
Test
14
Ashwin
67
State
One day
State
One day

Output:
67
14
11

Input2:
11
Sachin
100
International
One day
12
Shewag
133
International
Test
13
Varun
78
State
Test
14
Ashwin
67
State
One day
District
T20

Output:
No such player
No Player with given matchType

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your Solution.
--------------------------------------------------
import java.util.Scanner;
public class Solution
{
  public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to display the result
 }
    
 //code the first method 
  
    
 //code the second method    

}
    
//code the class

-------------------------------------------------
Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
1001
Savings

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value Savings.Instead it may be "".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.


**Result:** 35 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;

class Player{
	private int playerId;
  	private String playerName;
  	private int runs;
  	private String playerType;
  	private String matchType;
  
  	public void setPlayerId(int playerId){
    	this.playerId =  playerId;
    }
  	
  	public void setPlayerName(String playerName){
  		this.playerName = playerName;
  	}
  	
  	public void setRuns(int runs){
    	this.runs = runs;
    }
  	
  	public void setPlayerType(String playerType){
    	this.playerType = playerType;
    }
  
  	public void setMatchType(String matchType){
    	this.matchType = matchType;
    }
  
  	public int getPlayerId(){
    	return this.playerId;
    }
  	
  	public String getPlayerName(){
    	return this.playerName;
    }
  	
  	public int getRuns(){
    	return this.runs;
    }
  
  	public String getPlayerType(){
    	return this.playerType;
    }
  
  	public String getMatchType(){
    	return this.matchType;
    }
  
  	 public Player(int playerId,String playerName,int runs,String playerType,String matchType){
    	this.playerId = playerId;
      	this.playerName = playerName;
      	this.runs = runs;
      	this.playerType = playerType;
      	this.matchType = matchType;
    }
  
  	 public Player(){}
  
}
public class MyClass{
  	 public static int findPlayerWithLowestRuns(Player[] players,String playerType){
      	int lowest = 0;
      	int current = 0;
    	for(int i = 0;i<players.length;i++){
        	if(players[i].getPlayerType().equalsIgnoreCase(playerType) ){
            	current = players[i].getRuns();
              	if(lowest ==0 ){lowest = current;}
              	else if(current<lowest){lowest = current;}
            }
        }
      	
      	return lowest;
       
    }
	
	 public static Player[] findPlayerByMatchType(Player[] players , String matchType){
    	List<Player> list = new ArrayList<>();
      	
      	for(int i = 0; i<players.length;i++){
        	if(players[i].getMatchType().toLowerCase().equals(matchType.toLowerCase())){
            	list.add(players[i]);
            }
        }
      
      	list.sort((a,b)->b.getPlayerId()-a.getPlayerId());
      
      	if(list.size()==0) return null;
      	
      	return list.toArray(new Player[0]);
    }

	public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
      	
      	Player[] players = new Player[4];
      	String playerTyps = "";
      	String matchTYpe = "";
      
      	int playerId;
      	String playerName;
      	int runs;
      	String playerType1;
      	String matchType1;
      
      	
      	for(int i = 0;i<players.length;i++){
        	playerId = sc.nextInt();
          	sc.nextLine();
          	playerName = sc.nextLine();
          	runs = sc.nextInt();
          	sc.nextLine();
          	playerType1 = sc.nextLine();
          	matchType1 =  sc.nextLine();
          
          Player p = new Player(playerId,playerName,runs,playerType1,matchType1);
          
          players[i] = p;
          
        }
      	String playerType = sc.nextLine();
      	String matchType = sc.nextLine();
      
      	int lowest = findPlayerWithLowestRuns(players,playerType);
      	Player[] l = findPlayerByMatchType(players,matchType);
      
      	if(lowest==0){
        	System.out.println("No such player");
        }else{
        	System.out.println(lowest);
        }
      
      	if(l == null) { System.out.println("No Player with given matchType");}
      	else {
        	for(Player p : l){
            	System.out.println(p.getPlayerId());
            }
        }
      	sc.close();
    }
}
```


---

## Test 2

### Question 1

Write main method in Solution class.

In the main method,  read an integer (containing only numeric digits without decimal and special characters) and check whether the sum of its digits is in multiple of 3. 
If the given input is in multiple of 3, then print TRUE(as a String) else print FALSE(as a String).
For example if the given value is 333, 3+3+3 is 9, which is multiple of 3, hence TRUE has to be printed

Sample input1:
333

Output:
TRUE

Sample input2:
Input:
200

Output:
FALSE

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your solution.
--------------------------------------------------

public class Solution
{

	public static void main(String[] args)
	{
		//code to read values 
		//code to display the result
	}

	}

-------------------------------------------------


**Result:** 15 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;

public class MyClass{
	public static void main(String[] args){
    	
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      
      int sum = 0;
      
      while(num>0){
      	sum += num%10;
        num = num/10; 
      }
      
      if((sum%3)==0){System.out.println("TRUE");}
      else{System.out.println("FALSE");}
    }
}
```

### Question 2

Create a class Laptop with the below attributes:

laptopId - int 
brand - String 
osType - String 
price - double 
rating - int

The above attributes should be private, write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement two static methods - countOfLaptopsByBrand and searchLaptopByOsType in Solution class.

countOfLaptopsByBrand method:
This method will take two input parameters - array of Laptop objects and a String parameter.
The method will return the count of laptops from array of Laptop object for the given brand(String parameter passed) whose rating is more than 3.
If no Laptop with the above condition is present in the array of Laptop objects, then the method should return 0. 

searchLaptopByOsType method:
This method will take two input parameters - array of Laptop objects and a String parameter.
The method will return Laptop object array in an descending order of their laptopId, from the array of Laptop objects whose os attribute matches with the given OS(String parameter passed).
If no Laptop with the given OS is present in the array of Laptop objects, then the method should return null.

Note : No two Laptop object would have the same laptopId.
       All the searches should be case insensitive. 

The above mentioned static methods should be called from the main method. 

For countOfLaptopsByBrand method - The main method should print the count of laptops as it is, if the returned value is greater than 0, or it
should print "The given brand is not available".

For searchLaptopByOsType method - The main method should print the laptopId and rating from the returned Laptop object array if the returned value is not null. 
If the returned value is null then it should print "The given os is not available".

Before calling these static methods in main, use Scanner object to read the values of  Four Laptop objects referring attributes in the above mentioned attribute sequence. 
Next, read two String values for capturing brand and os.

Consider below sample input and output:
TestCase1:
Input:
123
HP
Windows
35000
5
124
Apple
Mac OS
70000
5
125
Dell
Ubuntu
30000
4
126
HP
windows
40000
4
HP
windows

Output:
2
126
4
123
5

TestCase2:
Input:
123
HP
Windows
35000
5
124
Apple
Mac OS
70000
5
125
Dell
Ubuntu
30000
4
126
Asus
windows
40000
3
HP1
Ubuntu1

Output:
The given brand is not available
The given os is not available

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your Solution.
--------------------------------------------------
import java.util.Scanner;
public class Solution
{
  public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to display the result
 }
    
 //code the first method 
  
    
 //code the second method    

}
    
//code the class

-------------------------------------------------
Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
1001
Savings

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value Savings.Instead it may be "".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.


**Result:** 35 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;

class Laptop{

	private int laptopId;
  	private String brand ;
  	private String osType;
  	private double price;
  	private int rating;
  
  	public Laptop(){}
  	
  	public Laptop(int laptopId,String brand,String osType,double price,int rating){
    	this.laptopId = laptopId;
      	this.brand =  brand;
      	this.osType =  osType;
      	this.price = price;
      	this.rating = rating;
    }
  	
  	// Getter
  	public int getLaptopId(){ return this.laptopId; }
  	
  	public String getBrand(){ return this.brand; }
  
  	public String getOsType(){ return this.osType; }
  
  	public double getPrice(){ return this.price; }
  
  	public int getRating(){ return this.rating; }
  
  	// Setter
  	public void setLaptopId(int laptopId){
    	this.laptopId = laptopId;
    }
  
  	public void setBrand(String brand){
    	this.brand = brand;
    }
  
  	public void setOsType(String osType){
    	this.osType = osType;
    }
  
  	public void setPrice(double price){
    	this.price = price;
    }
  
  	public void setRating(int rating){
    	this.rating = rating;
    }
}
public class MyClass{
  
  	public static int countOfLaptopsByBrand(Laptop[] laptops,String brand){
    	int count = 0;
      
      	for(Laptop l : laptops){
        	if(l.getBrand().equalsIgnoreCase(brand) && l.getRating()>3){
            	count++;
            }
        }
      	
      	return count;
    }
  
  	public static Laptop[] searchLaptopByOsType(Laptop[] laptops,String osType){
    	List<Laptop> l = new ArrayList<>();
      
      	for(Laptop laptop : laptops){
        	if(laptop.getOsType().equalsIgnoreCase(osType)){
            	l.add(laptop);
            }
        }
      
      	if(l.size()==0) return null;
      	l.sort((a,b)->b.getLaptopId()-a.getLaptopId());
      	return l.toArray(new Laptop[0]);
    }
  	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      
      	String osType = "";
      	String brand = "";
      
      	int laptopId;
      	String brand1;
      	String osType1;
      	double price;
      	int rating;
      
      	Laptop[] laptops = new Laptop[4];
      
      	for(int i = 0;i<laptops.length;i++){
        	laptopId = sc.nextInt();
          	sc.nextLine();
          	brand1 = sc.nextLine();
          	osType1 = sc.nextLine();
          	price = sc.nextDouble();
          	rating = sc.nextInt();
          
          	Laptop l = new Laptop(laptopId,brand1,osType1,price,rating);
          	
          	laptops[i] = l;
        }
      
      	sc.nextLine();
      	brand = sc.nextLine();
      	osType = sc.nextLine();
      
      	int count = countOfLaptopsByBrand(laptops,brand);
      
      	Laptop[] result = searchLaptopByOsType(laptops,osType);
      
      	if(count==0){System.out.println("The given brand is not available");}
      	else{
        	System.out.println(count);
        }
      
      	if(result==null){
        	System.out.println("The given os is not available");
        }else{
        	for(Laptop l : result){
            	System.out.println(l.getLaptopId());
              	System.out.println(l.getRating());
            }
        }
      	sc.close();
    }
}
```


---

## Test 3

### Question 1

Write main method in the Solution class.

In the main method, read five values for an integer array. The main method should print the sum of odd numbers from the array of integers only if the sum value is greater than 8 and less than 50. Else it should print "NA".

For example, if the values are 1,2,3,5,7 the sum of odd numbers should be printed as 16. As in the array, 1,3,5,7 are odd numbers so their sum is 16(1+3+5+7) which is greater than 8 and less than 50. The output should be in the format of sample output.
Note: Sum of integers is based on their sign(+ or -) 
Example: If two numbers are 11 and -18, their sum will be -7.

Sample input1:
1
2
3
5
7

Output:
Sum of odd numbers:16

Sample input2:
1
2
3
4
8

Output:
NA

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your solution.
--------------------------------------------------

public class Solution
{

	public static void main(String[] args)
	{
		//code to read values 
		//code to display the result
	}

}

-------------------------------------------------


**Result:** 15 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;

public class MyClass{
	public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
      
      	int[] arr = new int[5];
      	int sum = 0;
      	for(int i = 0;i<arr.length;i++){
        	arr[i] = sc.nextInt();
          	if(arr[i]%2!=0) sum += arr[i];
        }
      	
      	if(sum>8 && sum<50) System.out.println("Sum of odd numbers:"+sum);
      	else System.out.println("NA");
      	sc.close();
    }
}
```

### Question 2

Create a class Hotel with the below attributes:
 
hotelId - int
hotelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
wifiFacility – String
totalBill- double

The above attributes should be private, write getters, setters and parameterized constructor as required.
 
Create class Solution with main method.
 
Implement two static methods – noOfRoomsBookedInGivenMonth and searchHotelByWifiOption in Solution class.
 
noOfRoomsBookedInGivenMonth method:
This method will take two input parameter - array of Hotel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Hotel objects for the given month(String parameter passed).
If no rooms are booked for the given month in the array of Hotel objects, then the method should return 0.

searchHotelByWifiOption method:
This method will take two input parameter - array of Hotel objects and a String parameter
The method will return Hotel object with second highest totalbill, from the array of Hotel objects where wifiFacility attribute matches with the given wifi facility(String parameter passed).
If no Hotel with the given wifi option is present in the array of Hotel objects, then the method should return null.
 
Note : 
No two Hotel object would have the same hotelId.
No two Hotel object would have the same totalbill.
The Array either has at least two objects with specified wifi option OR  no object with specified wifi option. 
All the searches should be case insensitive. 
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)
 
The above mentioned static methods should be called from the main method. 
 
For noOfRoomsBookedInGivenMonth method - The main method should print the total number of booked rooms as it is, if the returned value is greater than 0, else it
should print "No rooms booked in the given month"
 
For searchHotelByWifiOption method - The main method should print the hotelId from the returned Hotel object if the returned value is not null. 
If the returned value is null then it should print "No such option available".
 
Before calling these static methods in main, use Scanner object to read the values of four Hotel objects referring attributes in the above mentioned attribute sequence. 
Next, read the value of two String parameters for capturing the month and wifi option .

Consider below sample input and output:

Input1:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May
Yes
 
Output1:
5
103

Input2:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May1
Yes1

Output2:
No rooms booked in the given month
No such option available

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your Solution.
--------------------------------------------------
import java.util.Scanner;
public class Solution
{
  public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to display the result
 }
    
 //code the first method 
  
    
 //code the second method    

}
    
//code the class

-------------------------------------------------
Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
1001
Savings

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value Savings.Instead it may be "".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.


**Result:** 35 marks | Test Cases: Pass, Pass, Pass, Pass


**Solution:**

```java
import java.util.*;

class Hotel{
	// Fields
  	private int hotelId;
  	private String hotelName;
  	private String dateOfBooking;
  	private int noOfRoomsBooked;
  	private String wifiFacility;
  	private double totalBill;
  
  	// Getters
  	
  	public int getHotelId(){return this.hotelId;}
  	public String getHotelName(){return this.hotelName;}
  	public String getDateOfBooking(){return this.dateOfBooking;}
  	public int getNoOfRoomsBooked(){return this.noOfRoomsBooked;}
	public String getWifiFacility(){return this.wifiFacility;}
	public double getTotalBill(){return this.totalBill;}
  
  	// Setters
  
  	public void setHotelId(int hotelId){this.hotelId = hotelId;}
  	public void setHotelName(String hotelName){this.hotelName = hotelName;}
  	public void setDateOfBoooking(String dateOfBooking){this.dateOfBooking = dateOfBooking;}
  	public void setNoOfRoomsBooked(int noOfRoomsBooked){this.noOfRoomsBooked = noOfRoomsBooked;}
  	public void setWifiFacility(String wifiFacility){this.wifiFacility=wifiFacility;}
  	public void setTotalBill(double totalBill){this.totalBill = totalBill;}
  
  	public Hotel(){}
  
  	public Hotel(int hotelId,String hotelName,String dateOfBooking,int noOfRoomsBooked,String wifiFacility,double totalBill){
    	this.hotelId = hotelId;
      	this.hotelName = hotelName;
      	this.dateOfBooking = dateOfBooking;
      	this.noOfRoomsBooked = noOfRoomsBooked;
      	this.wifiFacility = wifiFacility;
      	this.totalBill = totalBill;
    }
  	
}

public class MyClass{
  
  	public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels,String dateOfBooking){
    	int count = 0;
      	for(Hotel hotel:hotels){
        	if(hotel.getDateOfBooking().contains(dateOfBooking)){
            	count += hotel.getNoOfRoomsBooked();
            }
        }
      	return count;
    }

  
  	public static Hotel[] searchHotelByWifiOption(Hotel[] hotels,String wifiFacility){
    	List<Hotel> list = new ArrayList<>();
      	for(Hotel hotel : hotels){
        	if(hotel.getWifiFacility().equalsIgnoreCase(wifiFacility)){
            	list.add(hotel);
            }
        }
      	if(list.size()==0) return null;
      	list.sort((a,b)->Double.compare(b.getTotalBill(),a.getTotalBill()));
      	
      	return list.toArray(new Hotel[0]);
    }
  
  	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      
      	Hotel[] hotels = new Hotel[4];
      
      	int hotelId;
      	String hotelName;
      	String dateOfBooking;
      	int noOfRoomsBooked;
      	String wifiFacility;
      	double totalBill;
      
      	String month = "";
      	String wifiOption = "";
      
      	for(int i = 0;i<hotels.length;i++){
        	hotelId = sc.nextInt();
          	sc.nextLine();
          	hotelName = sc.nextLine();
          	dateOfBooking = sc.nextLine();
          	noOfRoomsBooked = sc.nextInt();
          	sc.nextLine();
          	wifiFacility = sc.nextLine();
          	totalBill = sc.nextDouble();
          
          Hotel h = new Hotel(hotelId,hotelName,dateOfBooking,noOfRoomsBooked,wifiFacility,totalBill);
          
          hotels[i] = h;
          
        }
      	sc.nextLine();
      	
      	month = sc.nextLine();
      	wifiOption = sc.nextLine();
      
      	int count = noOfRoomsBookedInGivenMonth(hotels,month);
      
      	Hotel[] result = searchHotelByWifiOption(hotels,wifiOption);
      
      	if(count==0) System.out.println("No rooms booked in the given month");
      
      	else System.out.println(count);
      
      	if(result==null) {System.out.println("No such option available");}
      
      	else if(result.length==1) {
        	System.out.println(result[0].getHotelId());
        }else{
        	double smax = result[0].getTotalBill();
          	int id  = result[0].getHotelId();
          	for(int i = 1;i<result.length;i++){
            	if(result[i].getTotalBill()<smax){
                	smax = result[i].getTotalBill();
                  	id = result[i].getHotelId();
                  	break;
                }
            }
          	System.out.println(id);
        }
      
      	
      
      	sc.close();
    }
}
```