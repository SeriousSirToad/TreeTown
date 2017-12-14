import java.awt.*;
import java.applet.*;
import java.util.*;
public class Tree extends everything{
  public static void main(String[] args){
      System.out.println("Welcome to Tree Town!");
      System.out.println("<Press enter to continue>");
      try{
          System.in.read();
      }
      catch (Exception e)
      {}
      Tree tre=new Tree();
      tre.stet();
  }
      public void stet(){
      Thread t=new Thread(this);
      t.start();
      stuff.prompt();
  } 
}
abstract class everything implements Runnable{ //Stored variables
   public void run(){ //Hunger loop
       while(hunger != 100){
           hunger++;
           if (hunger > 70){
               System.out.println("You are hungry.");
            }
           if (hunger >= 100){
                System.out.println("You are dead.");
               System.exit(0);
            }
           if (dayCounter % 30 == 0){
               allow = true;
           }
            try{
                Thread.sleep(10000);
            }
            catch(InterruptedException e){
                System.out.println("ERROR");
            }
       }
   }
    //buyable objects 
    public static int seeds=0;
    public static int candle=0;
    public static int syrup=0;
    public static int food=0;
    public static int lamp=0;
    public static int sugar=10;
    public static boolean sugarbush=false;
    public static boolean weight=false;
    //keys
    public static boolean allow=true;
    public static boolean key1=false;
    public static boolean key2=false;
    public static boolean key3=false;
    public static boolean storyStarted=false;
    public static boolean storyStarted2=false;
    //status
    public static int dayCounter=1;
    public static int n;
    public static int gains=0;
    public static int nice=100;
    public int hunger=0;
    public static boolean drunk=false;
    public static boolean end=false;
    public static boolean sad=true;
    public static boolean worked=false;
    public static boolean job=false;
    //other booleans
    public static boolean bT=false;
    public static boolean qbFp=false;
    public static boolean ps=false;
    public static boolean catCol=false;
    //housing
    public static int house=1;
    public static boolean hotelRoom=false;
    //money
    public static int money=100;
    //First visit checks
    public static boolean v1 = false;
    public static boolean v2 = false;
    public static boolean v3 = false;
    public static boolean v4 = false;
    public static boolean v5 = false;
    //tree things
    public static int unhappyTrees = 0;
    public static int trees = 500;
    public static int happyTrees = trees - unhappyTrees;
    //utility
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
}
class stuff extends everything{
    public static void prompt(){
        boolean leaff=false;
        if (dayCounter%30==0){
            allow=true;
        }
    System.out.println("Day "+dayCounter);
    System.out.println("What would you like to do?");
    System.out.println(">(rl)Read leaflet");
    System.out.println(">(ct)Check trees");
    System.out.println(">(t)Travel");
    System.out.println(">(la)Look around");
    String a=sc.next();
        switch(a){
    case "la": lookAround.home();
        break;
    case "t": travel.locations();
        break;
    case "rl": stuff.leaf();
    case "ct": Trees.check();
        break;
    default: System.out.println("I don't know how to do that.");
        stuff.prompt();
        }
    }
    public static void leaf(){
        System.out.println("Welcome to TreeTown. You will find that we are peaceful folk out here in Alberta, Canada.");
        System.out.println("We are a small town, but we like it here. You will find there is a shop, a lodge and your");
        System.out.println("own home. We tried to get into the maple syrup producing game back in '57, but it was too");
        System.out.println("expensive. We are searching for someone who can afford it. All residents are granted a shack");
        System.out.println("just for being a citizen, and you can buy bigger houses from the store. All food and drink");
        System.out.println("is complementary at the lodge, so feel free to fill up. Don't forget to be nice eh?");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        stuff.prompt();
    }
    
}
class Trees extends everything{
    public static void check(){
    if(unhappyTrees==0){
    System.out.println("All "+trees+" of your trees are happy.");
    }
    else if(unhappyTrees==trees){
    System.out.println("None of your trees are happy.");
    }
    System.out.println("What would you like to do?");
        System.out.println(">(cm)Collect money");
        if (syrup>0){
            System.out.println(">(gt)Glaze unhappy trees");
        }
        System.out.println(">(pt)Plant trees");
        if (sugarbush==true){
            System.out.println(">(cs)Collect syrup");
        }
        System.out.println(">(l)Leave");
        String yeno=sc.next();
        switch (yeno){
            case "cm": Trees.collect();
                break;
            case "pt": Trees.plant();
                break;
            case "gt": Trees.glaze();
                break;
            case "l": stuff.prompt();
            default: System.out.println("What?");
                Trees.check();
                break;
        }
    }
    public static void glaze(){
        if (syrup>0){
            System.out.println("You carefully glaze all of the sad trees with the syrup you bought.");
            syrup=syrup-1;
            unhappyTrees=0;
            if (nice < 85){
                nice=nice+15;
            }
            else{
                nice=100;
            }
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            Trees.check();
        }
        else{
            System.out.println("You don't have any maple syrup.");
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            Trees.check();
        }
    }
    public static void plant(){
        if(seeds>0){
            unhappyTrees=unhappyTrees-10;
            System.out.print("You plant "+seeds+" trees.");
            seeds=0;
            if (trees>1){
                System.out.println(" That made the surrounding trees happy.");
            }
            if (nice<=85){
                nice=nice+15; 
            }
            else{
                nice=100;
            }
        }
        else{
            System.out.println("You don't have seeds.");
        }
        trees=trees+seeds;
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        Trees.check();
    }
    public static void collect(){
        if (allow==true){
        System.out.println("You collect "+happyTrees+" dollars from your trees. That made them very unhappy.");
        unhappyTrees=unhappyTrees+100;
        nice=nice-15;
        allow=false;
        money=money+trees;
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        stuff.prompt();
        }
        else{
            System.out.println("You already did that.");
            stuff.prompt();
        }
    }
}
class travel extends everything{
    public static void locations(){
        Scanner loc=new Scanner(System.in);
        System.out.println("Where would you like to travel to?");
        System.out.println(">(h)Home");
        if (dayCounter==69){
            System.out.println(">(pt)Pound Town");
        }
        System.out.println(">(s)Shop");
        System.out.println(">(l)Lodge");
        if(sugarbush==true){
            System.out.println(">(sb)Sugarbush");
        }
        System.out.println(">(q)Quebec");
        String locs=loc.next();
        switch (locs){
            case "l": lodge.l();
                break;
            case "q": if (storyStarted==false||end==true){
                System.out.println("Nobody seems to like you here.");
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            travel.locations();
            }
            else{
                if(storyStarted2==true&&end==false){
                    if(qbFp==false){
                    quebec.beg();
                    }
                    else{
                    hotel.lobby();
                    }
                }
                else{
                System.out.println("Nobody seemse to like you here.");
                try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            travel.locations();
                }
            }
                break;
            case "s": shop.store();
                break;
            case "pt": if (dayCounter==69){ 
                System.out.println("You get off the bus at pound town, but as soon as you do");
                System.out.println("you notice the stench of garbage and drugs. You hear moans ");
                System.out.println("from across the street. You shouldn't have come to Pound Town.");
                System.out.println("New Jersey is a place for douchebags and drama queens. Out of ");
                System.out.println("fear for your virginity, you get back on the bus and leave.");
                System.out.println("Press Enter.");
                try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
                travel.locations();
            }
                else{
                    System.out.println("I don't know where that is.");
            travel.locations();
                }
            case "h": if(house==1){
                home.house1();
            }
            else if (house==2){
                home.house2();
            }
            else if (house==3){
                home.house3();        
            }
                break;
            case "sb": if (sugarbush==true){
                System.out.println("You collect 10 gallons of maple syrup. You donate 5 to the city, which earns you $10000");
                System.out.println("<Press enter to continue>");
                syrup=syrup+5;
                money=money+10000;
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                stuff.prompt();
            }
                else{
                    System.out.println("Nice try.");
                    stuff.prompt();
                }
                break;
            default: System.out.println("I don't know where that is.");
            travel.locations();
                break;
        }
    }
	public static void queb(){
	    System.out.println("Where would you like to go?");
	    System.out.println(">(h)Hotel");
	    System.out.println(">(lj)Lumberjack co.");
        System.out.println(">(s)Shop");
        System.out.println(">(b)Bar");
	    System.out.println(">(tt)Tree Town");
	    String lq=sc.next();
        switch (lq) {
            case "h": hotel.lobby();
                break;
            case "s": queShop.qs();
                break;
            case "tt": outside.def();
                break; 
            case "lj": ljout.co();
                break;
            case "b": 
                if (v1==false){
                    bar.stool();
                }
                else{
                    bar.stool1();
                }
                break;
            default: System.out.println("Not sure where that is.");
                travel.queb();
                break;
        }
	}
}
class shop extends everything{
    public static void store(){
        System.out.println("A bearded man to your left begins to speak to you.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        System.out.println("'Just holdin up me shop here eh. What would ya like to buy?'");
        System.out.println("**********************************************************");
        shop.itms();
    }
        public static void itms(){
            System.out.println("You have $"+money);
            System.out.println(">(se)Seeds - for planting trees. | $50");
                if (house>=2){
                    System.out.println(">(f)Food - For at home eating. | $10");
                    System.out.println(">(w)Weights - Do you even lift? | $500");
                }
                if (house>=3){
                    System.out.println(">()blank[err: no value]");
                }
            System.out.println(">(sy)World's finest maple syrup - Makes anything happy. Anything. | $100");
            System.out.println(">(lj)Lumberjack Service - Build things for ya.");
            
            System.out.println(">(e)exit");
            String itm=sc.next();
            if (itm.equals("f")){
                    if (house > 1){
                        if (money >= 10){
                            System.out.println("'Thank you for yer purchase.'");
                            food = food + 2;
                            System.out.println();
                            itms();
                        }
                        else{
                            System.out.println("'Sorry, but you can't afford that.'");
                            System.out.println();
                            itms();
                        }
                    }
                    else{
                        System.out.println("What?");
                        System.out.println();
                        itms();
                    }
            }
              if (itm.equals("lj")){
              System.out.println("'What kinda service?'");
              if (house==1){
                  System.out.println(">(sh)Small House | $500");
              }
              if (house==2){
                  System.out.println(">(mh)Medium House | $5000");
              }
              if (house==3){
                  System.out.println(">(lh)Large House | $10000");
              }
              System.out.println(">(sb)Sugarbush | $50000");
              String svc=sc.next();
                switch (svc){
                    
                    case "sb": if (money>=50000){
                        money=money-50000;
                        System.out.println("'Thank you for yer purchase.'");
                        sugarbush=true;
                         try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                       }
                       else{
                        System.out.println("'Sorry, but you can't afford that.'");
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                       }
                        break;
                    case "mh": if (money>=5000){
                        System.out.println("'Thank you for yer purchase.'");
                        money=money-5000;
                        house=3;
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                    }
                    else{
                        System.out.println("'Sorry, but you can't afford that.'");
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                    }
                        break;
                    case "sh": if (money>=500){
                        System.out.println("'Thanks for yer purchase.'");
                        house=2;
                        money=money-500;
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                        break;
                    }
                    else{
                        System.out.println("'Sorry, but you can't afford that.'");
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        shop.itms();
                    }   
                }
              }
              else if (itm.equals("moneymoneykrabssweg69")){
              money=money+100000;
              shop.itms();
          }
              else if(itm.equals("sy")){
              if (money>=100){
                  syrup=syrup+1;
                  money=money-100;
                  System.out.println("'Thank you for yer purchase.'");
                  try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    shop.itms();
              }
              else{
                  System.out.println("'Sorry, but you can't afford that.'");
                  try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    shop.itms();
              }
          }
              else if (itm.equals("w")){
                  if (house>=2){
                      System.out.println("'Thank you for yer purchase.'");
                      weight=true;
                      try{
                          System.in.read();
                      }
                      catch (Exception e)
                      {}
                  }
                  else {
                  System.out.println("Not sure what that is eh.");
                  itms();
                  }
          }
          else if (itm.equals("e")){
              System.out.println("'Thanks fer shoppin here eh.'");
              try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
              outside.shop();
          }
            else if (itm.equals("se")){
                if (money>=50){
                    System.out.println("'Thank you for yer purchase.'");
                    money=money-50;
                    seeds=seeds+10;
                    try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    shop.itms();
                }
            }
          else{
        	  System.out.println("'I don't know what that is.'");
        	  shop.itms();
          }
    }
}
class queShop extends everything{
    public static void qs(){
        System.out.println("Bienvenue à la boutique du québec.");
        System.out.println("Qu'aimerais-tu acheter?");
        queShop.qbs();
    }
    public static void qbs(){
        System.out.println("You have $"+money);
        System.out.println(">(c)Candle | $10");
        System.out.println(">(la)Lamp | $20");
        if (job==false){
        System.out.println(">(j)Ask for a job");
    }
        else{
            System.out.println(">(w)Work");
        }
        System.out.println(">(l)Leave");
        String bq=sc.next();
        switch (bq){
                case"j": System.out.println("The woman gets her manager.");
                try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
                System.out.println("She hands you a badge and uniform.");
                System.out.println("You work whenever.");
                job=true;
                try
                {
                    System.in.read();
                }  
                catch(Exception e)
                {}
                queShop.qbs();
                    break;
            case "w": if (job==true){
                if (key1==false){
                System.out.println("While on your shift, a man with a blue flannel comes in.");
                    money=money+50;
                System.out.println("He buys a candle and leaves.");
                    try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    queShop.pr();
                    }
                else{
                    if (worked==false){
                    System.out.println("It's a long shift, but it gets you $50.");
                    money=money+50;
                    worked=true;
                    try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    quebec.b();
                    }
                    else{
                        System.out.println("You already did that today.");
                        queShop.qbs();
                    }
                    break;
                    }
                }
                else{
                    System.out.println("You don't have a job here.");
                    queShop.qbs();
                }
                    break;
            case "c": if (money>=10){ 
            	System.out.println("You buy a candle.");
                money=money-10;
                candle=candle+1;
                try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                queShop.qbs();
            }
            else{
            	System.out.println("You can't afford that.");
            	queShop.qbs();
            }
                break;
                 case "la": if (money>=20){ 
                	 System.out.println("You buy a lamp.");
                        money=money-20;
                        lamp=lamp+1;
                        try
                        {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        queShop.qbs();
                 }
                 else{
                	 System.out.println("You can't afford that.");
                	 queShop.qbs();
                 }
                break;
            case "l": quebec.situations();
            default: System.out.println("What?");
                queShop.qbs();
        }
    }
    public static void pr(){
                System.out.println("On your way out, you notice he dropped one of his keys. Would you like to take it?");
                System.out.println(">(y)Yes");
                System.out.println(">(n)No");
                    String yn=sc.next();
                    switch(yn){
                        case "y": System.out.println("You pick up the key.");
                            key1=true;
                        try
                    {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                            quebec.b();
                            break;
                        case "n": System.out.println("You put it on a shelf and leave.");
                            quebec.b();
                            break;
                        default: System.out.println("Not sure what that means.");
                            queShop.pr();
                            break;
                    }
    }
}
class lookAround extends everything{
    public static void insideHome(){
    	System.out.println("The first thing you notice is the heat coming from your small fireplace. Your cat is already");
    	System.out.println("asleep on your messy bed. It's a one room shack, but it's still comfy. You feel safe here.");
    	System.out.println("Your mind is secure.");
    	try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
    	home.pro();
    }
    public static void insideHome2(){
        System.out.println("Your new slightly larger house is just a rennovation from your last one, so you are still in");
        System.out.println("the same location. You have more than one room now, with a kitchen, living room, dining room,");
        System.out.println("and bedroom all clearly defined. The fireplace being the main source of heat and light, your ");
        System.out.println("cat sleeps by it.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        home.pro();
    }
    public static void insideHome3(){
        System.out.println("Your house is now two stories, and in a different location from the other two. Your upstairs");
        System.out.println("is complete with two bedrooms, an office room, and a bathroom. Of course, your house wouldn't");
        System.out.println("be finished without a fireplace. It makes the living room downstairs feel like your old home, ");
        System.out.println("and is you and your cat's favourite room.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        home.pro();
    }
	public static void home(){
            System.out.println("You're in the middle of a seemingly endless forest. The surrounding");
            System.out.println("snow topped trees seem to be uniformly placed in a checker formation. The sun");
            System.out.println("is shining brightly through the leaves. A small wood house is to your left, the"); 
            System.out.println("glass roof glimmering in the sunlight. You see a brick lodge in the distance,");
            System.out.println("with a small gravel road going to it and past it. ");
         try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        stuff.prompt();
        }
    public static void lodge(){
        System.out.println("You look around the lodge. Tables are placed no more than two meters");
        System.out.println("apart, the same pattern as the windows. The only thing on the menu seems");
        System.out.println("to be pancakes, as it is the only thing being eaten. Everyone is wearing");
        System.out.println("a red flannel, except for a man in the corner, wearing a blue one.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        System.out.println("Would you like to greet the strange man?");
        System.out.println(">(y)Yes");
        System.out.println(">(n)No");
        String eet=sc.next();
        switch(eet){
            case"y": storyStarted=true;
            System.out.println("He tells you a story of where he came from, Quebec. He explains");
            System.out.println("that he owns a lumberjack company. He offers to do some work for");
            System.out.println("you. You accept his offer.");
            System.out.println("The man leaves the lodge, and you take his spot.");
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            lodge.lod();
                break;
            case"n": 
            lodge.lod();
                break;
		 default: System.out.println("Please answer with 'y' or 'n'.");
		try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
		lookAround.lodge();
		break;
        }
    }
    public static void lodge2(){
        System.out.println("You look around the lodge. Tables are placed no more than two meters");
        System.out.println("apart, the same pattern as the windows. The only thing on the menu seems");
        System.out.println("to be pancakes, as it is the only thing being eaten. Everyone is wearing");
        System.out.println("a red flannel, almost like there's a uniform for Canadians. The room is ");
        System.out.println("heated by the stoves that make the food.");
        try
        { 
            System.in.read();
        }  
        catch(Exception e)
        {}
        lodge.lod();
    }
    public static void hRoom(){
        System.out.println("Your room is on the east side, so there is a lot of sunlight in the mornings.");
        System.out.println("The walls are painted white, so you don't really have the need for a light most");
        System.out.println("of the day. You especially won't need a lamp that's more expensive than the candle");
        System.out.println("that actually has a function. Outside you see a river, and people occasionally");
        System.out.println("rowing on it. There is no fireplace here, and no cat.");
        try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        hotel.room();
    }
}
class home extends everything{
    public static void house1(){
            System.out.println("You live in a small, but cozy shack.");
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
            home.pro();
    }
    public static void prop(){
                if(drunk==false){
                        System.out.println("You wake up refreshed.");
                        try{
                            System.in.read();
                        }
                       catch(Exception e)
                        {}
                        home.pro();
                    }
                    else{
                        System.out.println("You wake up groggy.");
                        drunk=false;
                         try{
                            System.in.read();
                        }
                       catch(Exception e)
                        {}
                        home.pro();
                        }
        }
    public static void bad(){
                    System.out.println("You wake up to see that quite a few trees have been cut down.");
                    trees=trees-10;
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                home.pro();
    }
    public static void pro(){
        System.out.println("Day "+dayCounter);
        System.out.println("What do you want to do?");
        System.out.println("***************************************");
        System.out.println(">(s)Sleep");
        if (house>=2){
            System.out.println(">(e)Eat some food");
            if (weight=true){
                System.out.println(">(li)LIFT!");
            }
        }
        System.out.println(">(la)Look around");
        System.out.println(">(n)Talk to neighbours");
        System.out.println(">(ct)Check your things");
        System.out.println(">(pc)Pet your cat");
        System.out.println(">(l)leave");
                    String act=sc.next();
                    switch (act){
                        case "li": 
                            if (weight==true){
                                System.out.println("YOU GET 100% MAD GAINS!!");
                                System.out.println("******************************");
                                gains=gains+5;
                            }
                            else{
                                System.out.println("You can't get mad gains without weights.");
                                System.out.println("****************************************");
                            }
                            pro();
                            break;
                        case "e":
                            if (house>1){
                                if (food>0){
                                    home ho=new home();
                                    ho.eat();
                                }
                                else {
                                    System.out.println("You don't have any food.");
                                    System.out.println("************************");
                                    pro();
                                }
                            }
                            else{
                                System.out.println("You would need a larger house. Go to the lodge if you want food.");
                                System.out.println("****************************************************************");
                                pro();
                            }
                      case"la": if (house==1){
                          lookAround.insideHome();
                      }
                      else if (house==2){
                          lookAround.insideHome2();
                      }
                      else if (house==3){
                          lookAround.insideHome3();
                      }
                            break;
                      case "n": neighbors();
                            break;
                      case"l": System.out.println("You exit your house.");
                            try{
                            System.in.read();
                            }
                            catch(Exception e)
                            {}
                            stuff.prompt();
                            break;
                        case"pc": pet.cat();
                            break;
                        case "ct": home.things();
                        case"s": 
                            ljAttack.attack();
                            break;
                        default: System.out.println("What?");
                            home.pro();
                    }
    }
    public void eat(){
        if (hunger>=15){
            hunger=hunger-15;
        }
        else{
            hunger=0;
        }
        System.out.println("Yummy.");
        System.out.println("******************");
        pro();
    }
    public static void neighbors(){
        System.out.println("'Oh hey there. Would you like some sugar grains?'");
        System.out.println(">(y)Yes");
        System.out.println(">(n)No");
        String b=sc.next();
        switch (b){
            case "y": System.out.println("'Thanks for stoppin by eh!'");
                try{
                    System.in.read();
                }
                catch (Exception e)
                {}
                pro();
                break;
            case "n": System.out.println("'Oh. Well thanks fer sayin hi.'");
                try{
                    System.in.read();
                }
                catch (Exception e)
                {}
                pro();
        }
    }
    public static void house2(){
        System.out.println("You live in a small one story house, complete with a fireplace. It's nice here.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        home.pro();
    }
    public static void house3(){
        System.out.println("You live in a medium sized two story house. The fireplace is still the main source");
        System.out.println("of heat. It's a lot more open here, but it doesn't quite feel like home.");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        home.pro();
    }
    public static void things(){
        System.out.println("You have "+trees+" trees, "+money+" dollars, "+syrup+" gallons of");
        System.out.println("syrup, "+seeds+" seeds, "+food+" food items, "+sugar+" grains of " );
        System.out.println("sugar, "+gains+" mad gains, and you are "+nice+" percent nice.");
                try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
        home.pro();
    }
}
class pet extends everything{
    public static void cat(){
    if (catCol==false){
      System.out.println("While petting your cat, you notice a paper is hiding under him.");
    System.out.println(">(gp)Get 'paper'");
    System.out.println(">(l)leave");
        String s=sc.next();
          if (s.equals("gp")){
              System.out.println("It's 100 dollars!");
              money=money+100;
              catCol=true;
              try{
                      System.in.read();
                  }
                  catch(Exception e)
              {}
              home.pro();
          }
          else if (s.equals("l")){
              System.out.println("You walk to the centre of your house.");
              try{
                    System.in.read();
                }
                catch(Exception e)
              {}
              home.pro();
          }
          else{
           System.out.println("I only understand presets.");
              try{
                    System.in.read();
                }
                catch(Exception e)
                {}
              pet.cat();
          }
        }
        else{
            System.out.println("Your cat purrs with satisfaction.");
            try{
                    System.in.read();
                }
                catch(Exception e)
                {}
            home.pro();
        }
    }
}
class quebec extends everything{
    public static void beg(){
        System.out.println("You see strange things and strange people who do not speak your language. These people do");
        System.out.println("not seem like true Canadians. They act disgusted instead of understanding when they hear");
        System.out.println("the language you speak. The only english replies to your questions are remarks shaming you");
        System.out.println("for not speaking French. You stand at the foot of your hotel.");
        qbFp=true;
        try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
    }
    public static void situations(){ //This object is irrelevant now.
        System.out.println("What would you like to do?");
        System.out.println(">(l)Look around");
        System.out.println(">(t)Travel");
        String sit=sc.next();
        switch (sit){
            case "l": quebec.beg();
                break;
            case "t": travel.queb();
                break;
            default: System.out.println("I don't know what that means.");
                quebec.situations();
        }
    }
    public static void b(){ //this object barely matters, keep it closed.
        System.out.println("You stand at the foot of your hotel.");
        try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
    }
    
}
class lodge extends everything{
    public static void l(){
        System.out.println("A bearded man in a red flannel approaches.");
        try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        lodge.lo();
    }
     public static void lo(){
        System.out.println("'Oh hi there. Me shift's almost over but I can fix ye up if you like.'");
         lodge.lod();
     }
     public static void lod(){
         if(storyStarted==true&&storyStarted2==false){
             System.out.println("You should go home and sleep.");
         }
        System.out.println(">(la)Look around");
        System.out.println(">(d)Drink");
        System.out.println(">(f)Food");
        System.out.println(">(l)Leave");
         
        String l=sc.next();
        switch(l){
            case"la": 
                if (storyStarted==false){
                lookAround.lodge();
                    
                }
                else{
                lookAround.lodge2();
                }
                break;
            case"d": System.out.println("You feel a little woozy.");
                drunk=true;
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                lodge.lod();
                break;
            case"f": lodge.food();
                break;
            case"l": outside.lodge();
                break;
            default: System.out.println("'We don't do that here.'");
                lodge.lod();
                break;
        }
    }
    public static void food(){
        System.out.println("The menu:");
        System.out.println("(p)Pancakes");
        System.out.println("(w)Waffles");
        System.out.println("(n)Nothing");
        String fi=sc.next();
        switch(fi){
            case "p": System.out.println("'Ah, that one's a classic.'");
                        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
                System.out.println("You eat the pancakes with satisfaction.");
                lodge.lod();
                break;
            case "w": System.out.println("'What are you, American?'");
                    try
                    {
                    System.in.read();
                    }  
                    catch(Exception e)
                    {}
                System.out.println("You (sadly) eat the waffles.");
          try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
                lodge.lod();
                break;
            case "n": System.out.println("You eat a large plate of nothing.");
            try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
                lodge.lod();
        }
    }
}
class bar extends everything{
    public static void stool(){
        System.out.println("Nobody here speaks english, but you assume the men in the corner with ");
        System.out.println("blue flannels do, based on your previous experience with a similar man.");
        System.out.println("Unlike the lodge, it's cold here. The mixture of cool colors and blasting");
        System.out.println("AC might be contributing. You see rows of glass and alcohol. The bartender");
        System.out.println("has a funny mustache.");
        System.out.println("<Press enter to continue>");
        v1=true;
        try {
            System.in.read();
        }
        catch (Exception e)
        {}
        bar.stool1();
    }
    public static void stool1(){
        System.out.println("You have $"+money);
        System.out.println(">(d)Drink | $15");
        //System.out.println(">(la)Look around");
        System.out.println(">(l)Leave");
        System.out.println("*Tell me if you got here, it's not the end, just something I need to fix*");
        String a=sc.next();
        if (a.equalsIgnoreCase("d")||a.equalsIgnoreCase("drink")){
            System.out.println("You try to say your favorite alcohol brand, but the bartender doesn't ");
            System.out.println("understand you, so you just say beer. He gives you one. You drink it.");
            System.out.println("<Press enter to continue>");
            drunk=true;
            try{
                System.in.read();
            }
            catch (Exception e)
            {}
            bar.stool1();
        }
        if (a.equalsIgnoreCase("l")||a.equalsIgnoreCase("leave")){
            quebec.b();
        }
        
    }
}
class hotel extends everything{
    public static void lobby(){
        System.out.println("You sit on the lobby couch.");
        try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        System.out.println("What would you like to do?");
        System.out.println(">(w)Walk outside");
        if (hotelRoom==false){
            System.out.println(">(t)Talk to bellhop");
        }
        System.out.println(">(g)Go to your room");
        String c=sc.next();
        switch (c){
            case "w": quebec.b();
                break;
            case "t": System.out.println("You walk up to the bellhop.");
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                System.out.println("'Bonjour... Oh, you must speak english. Hello, welcome to Namaska ");
                System.out.println("Hotel. Would you like a room? They are $100.'");
                System.out.println("(y)Yes");
                System.out.println("(n)No");
                String b=sc.next();
                switch (b){
                    case "y":
                        if (money>=100){
                        System.out.println("'Thank you for choosing Namaska.'");
                        money=money-100;
                        hotelRoom=true;
                        hotel.lobby();
                    }
                    else{
                        System.out.println("'Looks like you can't afford it.'");
                        try{
                            System.in.read();
                        }
                        catch(Exception e)
                        {}
                    }
                    case "n": System.out.println("'Fine then.'");
                    try{
                    System.in.read();
                }
                catch(Exception e)
                {} 
                    hotel.lobby();
                        break;
                }
                break;
            case "g": if(hotelRoom==true){
                System.out.println("You take the elevator to your hotel room.");
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                hotel.room();
            }
                else{
                    System.out.println("You don't have a room.");
                    hotel.lobby();
                }
             break;
        }
    }
    public void roomE(){
        if (hunger>10){
            hunger=hunger-10;
        }
        else{
            hunger=0;
        }
        System.out.println("Yum.");
        System.out.println("********************");
        room();
    }
    public static void room(){
        System.out.println("Day "+dayCounter);
        System.out.println("What would you like to do?");
        System.out.println(">(s)Sleep");
        System.out.println(">(la)Look around");
        if (lamp>0){
            System.out.println(">(p)Place your lamp");
        }
        System.out.println(">(e)Eat");
        System.out.println(">(l)Leave");
        String a=sc.next();
        switch (a){
            case "e": hotel hot=new hotel();
                hot.roomE();
                case"s": System.out.println("You close your eyes...");
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                if(dayCounter%5==0){
                    System.out.println("You get word from TreeTown that a few trees have been cut down.");
                    System.out.println("<Press enter to continue>.");
                }
                else{
                    if (drunk==false){
                        System.out.println("You wake up refreshed.");
                        System.out.println("<Press enter to continue>.");
                    }
                    else{
                        System.out.println("You wake up groggy.");
                        System.out.println("<Press enter to continue>.");
                        drunk=false;
                    }
                }
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                hotel.room();
                break;
                case"la":lookAround.hRoom();
                break;
                case"p":if (lamp>0){
                System.out.println("You place a lamp on your bedside table.");
                    lamp=lamp-1;
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                    hotel.room();
                }
                else{
                    System.out.println("You don't have a lamp.");
                    hotel.room();
                }
                break;
                case"l":hotel.lobby();
                break;
            default: System.out.println("What?");
                hotel.room();
                break;
        }
    }
}
class ljout extends everything{
    public static void co(){
        System.out.println("You are standing at the base of a building with a sign that reads 'Lumberjack co.' on it.");
        ljout.com(); //teehee
    }
    public static void com(){    
        System.out.println("Go inside?");
        System.out.println(">(y)Yes");
        System.out.println(">(n)No");
        String gi=sc.next();
        switch(gi){
            case "y":if(key1==true){
                System.out.println("You unlock the door with the key from your job and go inside.");
                ljin.co();
            }
                else{
                    System.out.println("It's locked. You go to your hotel.");
                    try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
                }
                break;
            case "n": System.out.println("You leave.");
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
        }
        
    }
}
class ljin extends everything{
    static boolean distracted;
    public static void co(){
        System.out.println("It's awfully dark, and the air inside is colder than the winter air.");
        System.out.println("You would need a light to continue.");
        if (candle>0){
            System.out.println("Use candle?");
            System.out.println(">(y)Yes");
            System.out.println(">(n)No");
            String yn=sc.next();
            switch(yn){
                case "y": ljin.com();
                    break;
                case "n": System.out.println("Your lack of interest leads you back to your hotel.");
                    try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
                    break;
                default: System.out.println("huh?");
                    ljout.co();
                    break;
            }
        }
        else{
            System.out.println("The only problem is you don't have one, so you go to your hotel.");
            try{
                    System.in.read();
                }
                catch(Exception e)
                {}
        quebec.situations();
        }
    }
    public static void com(){
        System.out.println("Your area is dimly lit. There are three paths.");
        System.out.println(">(le)A door on the left");
        System.out.println(">(ri)A door on the right");
        System.out.println(">(lh)A long hallway in front of you");
        System.out.println(">(l)Leave");
        String rom=sc.next();
        switch(rom){
                case"l":System.out.println("What, you're scared?");
                    ljout.co();
                    break;
                case"le": ljin.fLeft();
                    break;
                case"ri":ljin.fRight();
                    break;
                case"lh":ljin.fHall();
                    break;
            default: System.out.println("*************");
                System.out.println("huh?");
                System.out.println("*************");
                ljin.com();
        }
    }
    public static void fLeft(){
        System.out.println("You walk in to see a large oval table in the middle of the room. A ");
        System.out.println("whiteboard is on the far end of the table. It reads in English, which");
        System.out.println("seems to be American dielect. It shows a plan to cut trees and get money.");
        System.out.println("There is a key on the table.");
        System.out.println(">(tk)Take key");
        System.out.println(">(l)Leave");
        String ac=sc.next();
        switch (ac){
                case"tk":System.out.println("You take the key and exit the room.");
                key2=true;
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                ljin.com();
                    break;
                case"l":System.out.println("Curiosity at its finest.");
                try{
                    System.in.read();
                }
                catch(Exception e)
                {}
                ljin.com();
                    break;
        }
    }
    public static void fRight(){
        if (key2==true){
            System.out.println("You open the door with the key you found in the board room.");
            System.out.println("**************************************************************************");
            System.out.println("You are blinded by the sunlight coming through the window. This room seems");
            System.out.println("almost like an exact copy of the left one, but instead of a key on the table,");
            System.out.println("there are shaving razors. You see a brown mass in the corner of the room.");
            System.out.println("Inspect mass?");
            System.out.println(">(y)Yes");
            System.out.println(">(n)No");
            String y=sc.next();
            switch (y){
                case "y": 
                    System.out.println("You realize it's shaved beard hair. There is a small paper on top of it");
                    System.out.println("all. You pick up the paper to read it, but it's in french. The only images");
                    System.out.println("are those of shaved men with chainsaws. Disturbed by a lack of facial hair,");
                    System.out.println("you begin to realize this room only contains lore.");
                    System.out.println("Press enter to leave.");
                    try{
                        System.in.read();
                    }
                    catch(Exception e)
                    {}
                    ljin.com();
                    break;
                case "n": 
                    System.out.println("Your lack of interest leads you to the hallway.");
                    System.out.println("*************************************************");
                    ljin.com();
            }
        }
        else{
            System.out.println("It's locked.");
            ljin.com();
        }
    }
    public static void fHall(){
        System.out.println("The long intimidating dark hallway is no match for your $10 candle.");
        System.out.println("As you're walking down, you see posters of former managers and C level");
        System.out.println("employees, all with only short mustaches. At the end you see a door.");
        System.out.println("Enter?");
        System.out.println(">(y)Yes");
        System.out.println(">(n)No");
        String nuts=sc.next();
        switch (nuts){
        case "y": ljin.bRoom();
        }
    }
    public static void bRoom(){
        System.out.println("As you open the door, you smell wood carvings. You see a group of blue-flanneled");
        System.out.println("men in the far right corner. You start to realize this room is really large, and");
        System.out.println("see the various wood products, like planks and paper. You also see large stacks of");
        System.out.println("money to your left. There is a door right past the guys in blue flannels.");
        ljin.bRoom1();
    }
    public static void bRoom1(){
        if (distracted==false){
        System.out.println(">(d)Distract lumberjacks");
        System.out.println(">(r)Run past them");
        }
        else{
            System.out.println(">(o)Go to the CEO's office");
        }
        System.out.println(">(g)Grab money");
        System.out.println(">(l)Leave");
        String c=sc.next();
        switch (c){
            case "d": System.out.println("How do you distract them?");
                System.out.println(">(t)Throw wood at them");
                System.out.println(">(y)Yell loudly and run away");
                System.out.println(">(d)Disguise yourself as one of them and sneak past");
                System.out.println(">(l)Decide not to do anything and leave");
                String d=sc.next();
                switch(d){
                    case "t": 
                        System.out.println("You successfully throw the largest plank you can, knocking all of them over and rendering them");
                        System.out.println("unconscious. You can now go in the door near them.");
                        System.out.println("Press enter to open door.");
                        try{
                            System.in.read();
                        }
                        catch (Exception e)
                        {}
                        ljin.offic();
                        break;
                    case "d": 
                        System.out.println("You slide on a blue flannel, but your bushy beard is a bit too obvious. You try to hide it with");
                        System.out.println("your hand, but as you walk by, the men talk to you.");
                        System.out.println("'Hey there pal, this is the CEO office.' He sounds very American.");
                        System.out.println("You feel defeated and walk to the door you came in through.");
                        ljin.bRoom1();
                        break;
                    case "y":
                        System.out.println("You yell the most offensive thing you can think of, 'stinky', at the top of your lungs. You then");
                        System.out.println("hide behind a conveyor belt as the men walk to your previous location. They exit the large room,");
                        System.out.println("leaving you with the oppourtunity to enter the room they were standing in front of.");
                        System.out.println("<Press enter to continue>.");
                        distracted=false;
                        try{
                            System.in.read();
                        }
                        catch (Exception e)
                        {}
                        ljin.offic();
                        break;
                    case "l": System.out.println("Smh.");
                        ljin.com();
                        break;
                }
                break;
            case "r": System.out.println("Your act of pure stupidity lands you in jail for a week for trespassing.");
                System.out.println("<Press enter to continue>.");
                dayCounter=dayCounter+7;
                try{
                    System.in.read();
                }
                catch (Exception e)
                {}
                hotel.lobby();
                break;
            case "g": 
                System.out.println("As you are taking the money, you hear yelling behind you, and you wake up");
                System.out.println("in the trunk of a car with a bag over your head.");
                System.out.println("<Press enter to continue>.");
                nice=0;
                try{
                    System.in.read();
                }
                catch (Exception e)
                {}
                FreeTown.car();
        }
    }
    public static void offic(){
        if (distracted==false){
            System.out.println("You walk in to see yet another man in a blue flannel sleeping with his");
            System.out.println("feet up on his desk. A large painting showing himself is in the back of");
            System.out.println("the room. A small tag on the man's desk reads 'CEO'. You recognize him ");
            System.out.println("as the man from the lodge. You wake him up.");
            System.out.println("'Oh, hey there. How'd you get in?'");
            distracted=true;
            ljin.office1();
        }
        else{
            System.out.println("'Welcome.'");
            ljin.office();
        }
    }
    public static void office1(){
        System.out.println(">(t)Tell him the truth");
        System.out.println(">(i)Ignore him");
        String a=sc.next();
        switch (a){
            case "t": 
                System.out.println("'Oh... That's interesting. Well I could offer you a job, but we recently");
                System.out.println("did work in your town. So that means a $500 fine.'");
                System.out.println("You have $"+money);
                System.out.println(">(p)Pay");
                System.out.println(">(r)Refuse");
                String b=sc.next();
                switch (a){
                    case "p":
                        if (money>=500){
                            money=money-500;
                            System.out.println("'Alright man, thanks. But what are you here for?'");
                            ljin.office();
                        }
                        else{
                            System.out.println("'You can't even pay for it! I'm calling the police on you for trespassing.'");
                            System.out.println("You end up in jail for a week.");
                            System.out.println("<Press enter to continue>.");
                            try{
                                System.in.read();
                            }
                            catch (Exception e)
                            {}
                            dayCounter=dayCounter+7;
                            hotel.lobby();
                        }
                        break;
                    case "r": System.out.println("'Fine then. I'm calling the police on you for trespassing.'");
                        System.out.println("You end up in jail for a week.");
                            System.out.println("<Press enter to continue>.");
                            try{
                                System.in.read();
                            }
                            catch (Exception e)
                            {}
                            dayCounter=dayCounter+7;
                            hotel.lobby();
                        break;
                    default: System.out.println("What?");
                        ljin.office1();
                }
                break;
            case "i": 
                System.out.println("'Pretty rude for a canadian. Anyways, you need to leave. I have to send");
                System.out.println("some people to your town so we can do maintenance on your trees. See, I");
                System.out.println("come from a place called FreeTown, in the US. So do all of my workers. ");
                System.out.println("Down there, capitalism is key. We cut down trees, sell the products, and");
                System.out.println("get money. Simple process. Don't you agree?'");
                System.out.println("(Naturally, as a canadian, you disagree with enviromental destruction.)");
                
                ljin.office();
                break;
        }
    }
    public static void office(){
        System.out.println(">(a)Ask him about his feelings");
        System.out.println(">(g)Glaze him");
        System.out.println(">(r)Run away");
        String a=sc.next();
        switch (a){
            case "a":
                if (sad==true){
                    System.out.println("'Oh. I guess it makes me feel sad. A lot of trees die. And you know I don't");
                    System.out.println("replant them.'");
                    ljin.office();
                }
                else{
                    System.out.println("'I feel like going on a hike, or maybe... Maybe Prince Edward Island. I always ");
                    System.out.println("wanted to go there. Will you go with me? It could be fun.'");
                    System.out.println(">(y)Yes");
                    System.out.println(">(n)No");
                    String l=sc.next();
                    switch (l){
                        case "y": System.out.println("Wonderful, please do follow.");
                            System.out.println("<Press enter to continue>");
                            try{
                                System.in.read();
                            }
                            catch (Exception e)
                            {}
                            PEI.a();
                    }
                }
                break;
            case "g": if (syrup>0){
                System.out.println("You quickly dump a gallon of World's Finest Maple Syrup on the man. He");
                System.out.println("seems frustrated at first, but after a minute or so, but eventually he");
                System.out.println("shows signs of happiness.");
                System.out.println("'Wow' He says. He shakes your hand. It feels sticky from the syrup.");
                System.out.println();
                System.out.println("*If you're seeing this, you need to tell me. I must have forgotten to code it.*");
            }
                else{
                    System.out.println();
                    System.out.println("You don't even have syrup. How could you do that?");
                    ljin.office();
                }
                break;
            case "r": System.out.println("You run to the front door.");
                ljout.com();
        }
    }
}
class FreeTown extends everything{
    public static void car(){
        System.out.println(">(p)Pull the escape cord");
        System.out.println(">(y)Yell loudly");
        System.out.println(">(w)Wait");
        String act=sc.next();
        switch (act){
            case "y": 
                System.out.println("You yell, but you get no response.");
                FreeTown.car();
                break;
            case "p": 
                System.out.println("You take the bag off of your head, and pull the cord. The");
                System.out.println("trunk opens instantly, revealing that you are in the middle");
                System.out.println("of a city. This should be concerning to you, but hey, whatever");
                System.out.println("you wanna do.");
                System.out.println(">(w)Wait");
                System.out.println(">(j)Jump out");
                String b=sc.next();
                switch (b){
                    case "w": FreeTown.outCar();
                        break;
                    case "j": FreeTown.street();
                        break;
                    default: System.out.println("You decide to use command I don't understand.");
                        FreeTown.car();
                        break;
                }
        }
    }
    public static void outCar(){
        System.out.println("After quite a bit of waiting, your kidnappers take you out of the trunk.");
        System.out.println("'Welcome to FreeTown USA.' one of them says.");
        System.out.println("The bag coming off of your head is a shock to your eyes. The bright light disorients");
        System.out.println("you for a moment, but you get normal eventually.");
        System.out.println("'It's time to meet the main boss.'");
        outCar1();
    }
    public static void outCar1(){
        System.out.println(">(r)Run away");
        System.out.println(">(m)Meet the boss");
        String a=sc.next();
        switch (a){
            case "r": rw();
                int raw = rw();
                if (raw > 25)
                    runawayA();
                else
                    runawayB();
                break;
            case "m": bos();
                break;
            default: System.out.println("'"+a+"' is not recognized as a command.");
                System.out.println();
                outCar1();
        }
    }
    private static int rw(){
        return rand.nextInt(50);
    }
    private static void runawayA(){
        System.out.println("To your surprise, both of your attackers trip on each other as you escape. After");
        System.out.println("a lot of running, you go into an alley, and wait until you are sure the kidnappers");
        System.out.println("have lost you.");
    }
    private static void runawayB(){
        System.out.println("Your sad attempt to run away (unsuprisingly) failed. Your kidnappers grab you before");
        System.out.println("you can make it more than 10 feet. They drag you to who you assume is 'the boss'.");
        System.out.println("<Press enter to continue>");
        try{
            System.in.read();
        }
        catch(Exception e)
        {}
        bos();
    }
    private static void bos(){
        System.out.println("You are in a board room similar to the one inside of Lumberjack co. You see a man with an ");
        System.out.println("especially funny mustache sitting in a spinny chair. ");
        System.out.println();
        System.out.println("*Tell me if you get here, right now it's the end.*");
    }
    private static void street(){
        System.out.println("After (stupidly) jumping out of the car trunk, you notice the many cars on the road, and ");
        System.out.println("you quickly run to the traffic island.");
    }
}
class PEI extends everything{
    public static void a(){
        System.out.println("After about an hour flight, you arrive at Summerside Airport. You ");
        System.out.println("both agree that you should stay at a hotel in Summerside. It has a");
        System.out.println("nice view.");
        System.out.println("*TELL ME IF YOU GET HERE*");
    }
}
class outside extends everything{
    public static void shop(){
        System.out.println("You stand outside the white brick shop.");
            stuff.prompt();
    }
    public static void lodge(){
        System.out.println("You stand outside the brick lodge.");
            stuff.prompt();
    }
    public static void def(){
        System.out.println("You stand in the centre of town.");
        //fuckin canadians I swear to god    ^^^^^^
            stuff.prompt();
    }
}
class ljAttack extends everything{
    public static void attack(){
        if (storyStarted==true&&storyStarted2==false){
            storyStarted2=true;
            home.bad();
        }
        else{
            if (dayCounter%5==0&&storyStarted2==true){
               home.bad();
            }
            else{
                home.prop();
            }
        }
    }
}
class end extends everything{
    public static void space(){
        System.out.println("The end.");
        end=true;
        int counter=0;
        while (end==true){
            counter++;
            switch (counter){
                case 1: System.out.println("Main Storywriting:"); System.out.println("Asher Kingery");
                    break;
                case 2: System.out.println("Main Programming:"); System.out.println("Asher Kingery");
                    System.out.println("Van Alexander");
                    break;
                case 3: System.out.println("Thank you for playing.");
                    break;
                default: stuff.prompt();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                
            }
        }
    }
}
