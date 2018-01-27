package co.in.dayam;

import javax.microedition.lcdui.*;
import java.io.*;
import java.util.Random;
import java.util.*;

public class GameData 
{

public String gameImages[] =
{
"KaygalL.png",
"dayamico.png",
"mukiya.png",
"thervu.png",
"padayal.png",
"bluebck.png",
"thayarippu.png",
"udavi.png",
"podu.png",
"marumurai.png",
"edu.png",
"vai.png",
"pinnal.png",
"va.png",
"var.png"
};

public int munnarNilai = 0;

public int uyermeyNilai = 0;
public int uyermeyNilai2 = 0;
public static int uyerMey = 0;


public Image gameImage[];

public  Random random;

public  String pandayamStr, aipandayamStr;

//used in checkVazhi
public int nilai1[] = new int[4];
public int nilai2[] = new int[4];

int attamCounter = 0;




// Kurippu 2
// enn athavathu kurikkum peyar - porul villakkam
//------------------------------------------------
//1. "pagadai" ill ulla ov-oru kattammum oru enn {0 to 98} varai 'point[0], point[1]'
//2. "daya kattai" ill ov-ondrum oru enn than 0 t0 15 piragu 1,2,3,4,5,6,12 endru matra padukindrathu
//   ivya 'pandayam' endru agikapadukindrathu
//3. irandu "kaigal" lluku thani enn 1,2,3,4 playercoin, aicoin/aicoin
//4. "kattam" alavu oru enn 7 gridsize
//5. "menu" oru enn {0 to 2} 'attam, udavi, padaippu'
//6. "thirai" oru enn {0 to 2} 'main, game, help, about'
//7. "attam" nilai oru enn {0 to 3} 'play, repeat, pick, keep'
//8. padam oru enn 0 to 6 munn thirai, idam-valam, thervu, thervu-peyar, kaigal, ezthu-uru
//9. solAduku oru enn 1 to 247 uyir, mey, uyir-mey, aitham serthathu
// end Kurippu 2

// kurripu 1
// padikka mattum filekku velia anumathi thanthu ullai
// eztha vendum endral parameter passing mechanisms than sirantha vadiappaipu
// payan padutha pattu ulathu TamilEzthu.java
// urupadi ezthuvathu DayamCanvas.java

public static int screenWidth, screenHeight;

public static int neendaPakkam = 0;

public  int menuItemIdx;


//entha thirai enbathu kondu sellum 

public  int screenFlag; 

//entha nilai attam 
public  int repeatFlag;

//therth-ethutha kattam kattum
public  int cursorIdx;

//end kurippu 1

//kay nagartha therth-ethutha kattam ninaivagam
public  int pickIdx;


//kattam enbathu vattam athai seriathu periathu akka
public  int  gridSize, dx, dy;

//nallu nillai ulla irandu daya kattai
public  int[] diceValue = {6,5,4,3,5,4,3,2,4,3,2,1,3,2,1,12};

//kattam varaiya uthavum pulli
public  int[] point = new int[2];


public  int aicoinIdx, aicoinendIdx, aipandayamIdx, prevaicoinIdx, prevaicoinendIdx;


public  byte[] aipandayam = new byte[5];
public  byte[] aicoin     = new byte[4];
public  byte[] prevaicoin = new byte[4];

public  byte[] pandayam = new byte[6];
public  int pandayamIdx , coinIdx, prevcoinIdx;
public  byte[] playercoin = new byte[4];
public  byte[] prevplayercoin = new byte[4];
public  int playermovecoinIdx;
public  int playercoinendIdx, prevplayercoinendIdx;
public  int pandayamLoop;

public  int horizontalPage,  playerrevert;

public  static int NOOFROWS = 8, COLUMNWIDTH = 6; 
public  int MothaVarisai = 11;

//soltrodar amaikum ezthu

public  int solAduku[] = {

};





public  boolean vettuFlag;
public  boolean resumeGameFlag;
public  int[] board = new int[100];
public  int x , y, sum, score;

public int pointx[] = {43,55,67,45,2,82};
public int pointy[] = {125,125,125,111,147,147};
public int sgridSize = 0;

//vadiva ennikai

public int layerPattern[]={
0,1,2,3,4,5,6,7,20,33,46,59,72,85,86,87,88,89,90,91,104,117,130,143,156,169,182,195,208,221,
234,247,246,245,244,243,242,241,240,239,238,237,236,235,222,209,196,183,170,157,144,131,118,105,92,
79,80,81,82,83,84,98,111,124,137,150,390,389,388,387,386,385,384,403,422,441,460,479,498,11,03,
13,12,11,10,9,8,391,392,393,394,395,396,415,434,453,472,491,510
};




int margin;

int thulliamLayer[] = {
0,
6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,
6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,
6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,
4,4,4,4,4,4,4,4,4,4,4,4,4,
00,
00,
6,6,6,6,6,6,
4,4,4,4,4,4,4,4,4,4,4,4
};



int smargin[] = {
0,
25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,
25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,
25,25,25,25,25,25,25,25,25,25,25,25,25,25,25,
25,25,25,25,25,25,25,25,25,25,25,25,25,
00,
00,
25,25,25,25,25,25,
25,25,25,25,25,25,25,25,25,25,25,25

};
/*
int thulliamLayer[] = {0,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,
12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,
12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,
8,8,8,8,8,8,8,8,8,8,8,8,8,
52,
00,
12,12,12,12,12,12,
8,8,8,8,8,8,8,8,8,8,8,8
};

int smargin[] = {
0,
42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,
42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,
42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,
42,42,42,42,42,42,42,42,42,42,42,42,42,
00,
00,
42,42,42,42,42,42,
42,42,42,42,42,42,42,42,42,42,42,42

};
*/

//

GameData()
{

    gameImage = new Image[gameImages.length];
    cursorIdx = 1;


    gridSize = screenHeight/(19+2);

    if(! (gridSize % 2 == 0))
    {
      gridSize--; 
    } 

gridSize  = 6;
 
System.out.println("screenWidth"+ screenWidth);
System.out.println("screenWidth"+ screenHeight);




    margin = (screenWidth - gridSize * 13)/2;  

    dx = margin;//14+2;
    dy = 2 + gridSize * 19 + gridSize;

   

    repeatFlag = 0;

    pandayamStr = "";

    aipandayamStr = "";

    pandayamIdx = 0;   

    playercoinendIdx = 4;

    aicoinendIdx = 4;  

    vettuFlag = false; 
    
    aicoin[0] = 80;
    aicoin[1] = 80;
    aicoin[2] = 80;
    aicoin[3] = 80;

    sgridSize = gridSize - gridSize/3;

    try
    {
         for(int count = 0; count < gameImages.length; count++)
         {
            gameImage[count] = Image.createImage("/co/in/dayam/" + gameImages[count]);// "/co/in/dayam/"+
            
         }
    }
    catch(IOException e) 
    {
    }

    random = new Random();

}


private void clearScreen(Graphics g, int backColour)
{
     g.setColor(backColour);
     g.fillRect(0, 0, screenWidth, screenHeight);

}

public void MainMenu(Graphics g, boolean resume)
{

    clearScreen(g, 0xFEFEFE);

//g.drawString("w "+screenWidth+" "+"h "+screenHeight, 20, 5, g.TOP|g.LEFT);

   g.drawImage(gameImage[2], 0, 0, g.TOP|g.LEFT);    

     g.setClip(pointx[3], pointy[3], gameImage[4].getWidth(), gameImage[4].getHeight()/3+1); 
     g.drawImage(gameImage[4], pointx[3],  pointy[3]-(menuItemIdx)*(gameImage[4].getHeight()/3 +1), g.TOP|g.LEFT);
     g.setClip(0, 0, screenWidth, screenHeight);

     g.drawImage(gameImage[3], pointx[menuItemIdx], pointy[menuItemIdx], g.TOP|g.LEFT);


}


public void GamePage(Graphics g)
{




//1 kattam
     int A1 = margin;//14+2, 
     int B1 = screenHeight - 22 * gridSize;
     int A2 = gridSize * 13, B2 = gridSize * 13; 
//2 kattam
     int A3 = A1 + gridSize, B3 = B1 + gridSize; 
     int A4 = gridSize * 11, B4 = gridSize * 11;
//3 kattam
     int A5 = margin;//14+2 
     int B5 = screenHeight - 4*gridSize ;
     int A6 = gridSize * 13, B6 = gridSize;
//4 kattam
     int A7 = margin + gridSize * 6;//14+2 
     int B7 =  screenHeight - 15 * gridSize;
     int A8 =  gridSize,  B8 = gridSize * 12;


//blue metalic  bckgrnd
     g.drawImage(gameImage[5], 0, 0, g.TOP|g.LEFT);    

     //g.setColor(0x00ff00);

//yellow kattam
     g.setColor(0xffff00);

     g.drawRect(A1, B1, A2, B2);
     g.drawRect(A3, B3, A4, B4);
     g.drawRect(A5, B5, A6, B6);
     g.drawRect(A7, B7, A8, B8); 
     

//horizontal arm
     int x1 =  margin + 3*sgridSize;
     int y1 = B7 - sgridSize - 3;
     int x1w = (sgridSize) * 13 , x1h = sgridSize;

     g.drawRect(x1, y1, x1w, x1h);
     

//vertical arm
     int x3 =  margin +  (sgridSize ) * 3;
     int y3 = y1 - 6 * sgridSize;
     x1w = (sgridSize ); 
     x1h = (sgridSize ) * 7;
     g.drawRect(x3, y3, x1w, x1h);

     int x4 =  margin + sgridSize  * 15;
     g.drawRect(x4, y3, x1w, x1h);

    
     for(int count = 1; count < 13; count++)
     {
       g.drawLine(A1, B1 + gridSize * count, A1 + gridSize, B1 + gridSize * count);
       g.drawLine(A1 + gridSize * 12, B1 + gridSize * ( 13 - count), A1 + gridSize * 13, B1 + gridSize * ( 13 - count));
       g.drawLine(A1 + gridSize * count, B1, A1 + gridSize * count, B1 + gridSize);
       g.drawLine(A1 + gridSize * (13 - count), B1 + gridSize * 13, A1 + gridSize *( 13 - count), B1 + gridSize * 12);
       g.drawLine(A5 + gridSize * count, B5, A5 + gridSize * count, B5 + gridSize);
       g.drawLine(A7, B7 + gridSize * count, A7 + gridSize, B7 + gridSize * count);
     }

     for(int count = 1; count < 7 ; count ++)
     {
       g.drawLine(x4, y3 + (sgridSize ) * count, x4 + sgridSize, y3 + (sgridSize ) * count);
       g.drawLine(x3, y3 + (sgridSize ) * count, x3 + sgridSize , y3 + (sgridSize) * count);
       g.drawLine(x1 + (sgridSize ) * count, y1, x1 + (sgridSize) * count, y1 + sgridSize);
       g.drawLine(x1 + (sgridSize ) * (6+count), y1, x1 + (sgridSize ) * (6+count), y1 + sgridSize );
     }
    
     g.drawLine(x1 + (sgridSize ) * (13), y1, x1 + (sgridSize ) * (13), y1 + sgridSize );

     g.fillRect(A7 - gridSize * 3 , B7 - gridSize * 4 - 2 ,gridSize * 7 - 2,gridSize * 3  );
     g.fillRect(A5 + gridSize  , B5 - gridSize * 4,gridSize * 4,gridSize * 3);
     g.fillRect(A5 + gridSize * 8, B5 - gridSize * 4,gridSize * 4, gridSize * 3); 

 //malai yellow      
     g.setColor(0xffff00);     
     convertBoard(7);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(61);
     g.fillRect(point[0], point[1], gridSize, 2*gridSize);     
     convertBoard(19);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(25);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(31);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(37);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(43);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(49);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(55);
     g.fillRect(point[0], point[1], gridSize, gridSize);     
     convertBoard(66);
     g.fillRect(point[0], point[1], sgridSize, sgridSize);     

     int x5, y5;
     x5 = A5 + gridSize;
     y5 = B5 - gridSize * 3;  

System.out.println("Playercoin Aicoin outside "+coinIdx +" "+aicoinIdx );
for (int count = 0; count < 4 ; count ++)
{ 
System.out.println("count pcoin acoin" +count+" "+ playercoin[count] + " " + aicoin[count]);
}


     
     for (int count = 0; count < (playercoinendIdx - coinIdx); count ++)
     { 
         g.setClip(x5 + gridSize * count, y5, gameImage[0].getWidth() / 2, gameImage[0].getHeight());
         g.drawImage(gameImage[0], x5 + gridSize * count, y5, g.TOP|g.LEFT); 
         g.setClip(0 , 0, screenWidth, screenHeight);
     } 

     x5 = A5 + gridSize * 8 - gameImage[0].getWidth()/2;
     y5 = B5 - gridSize * 3;  
     
     for (int count = 0; count < (aicoinendIdx - aicoinIdx);  count ++)
     { 
         g.setClip(x5 + gridSize * count + gameImage[0].getWidth()/2, y5, gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
         g.drawImage(gameImage[0], x5 + gridSize * count, y5, g.TOP|g.LEFT); 
         g.setClip(0 , 0, screenWidth, screenHeight);
     } 

     x5 = A7 - gridSize ;
     y5 = B7 - gridSize * 3 - 2 - gridSize;  

     for (int count = 0; count < 4 - playercoinendIdx; count ++)
     { 
         g.setClip(x5 + gridSize * count, y5  , gameImage[0].getWidth() / 2, gameImage[0].getHeight());
         g.drawImage(gameImage[0], x5 + gridSize * count, y5 , g.TOP|g.LEFT); 
         g.setClip(0 , 0, screenWidth, screenHeight);
     } 

     x5 = A7 - gridSize - gameImage[0].getWidth()/2;
     y5 = B7 - gridSize * 3 - 2 + gridSize;  
     
     for (int count = 0; count < 4 - aicoinendIdx; count ++)
     { 
         g.setClip(x5 + gridSize * count + gameImage[0].getWidth()/2, y5 , gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
         g.drawImage(gameImage[0], x5 + gridSize * count, y5  , g.TOP|g.LEFT); 
         g.setClip(0 , 0, screenWidth, screenHeight);
     } 




    if(aicoinendIdx != 0 && playercoinendIdx != 0)
    {
     g.setClip(margin/2+  gridSize*8 + gameImage[0].getWidth()/2, 2 , gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
     g.drawImage(gameImage[0], margin/2+gridSize*8 , 2  , g.TOP|g.LEFT); 
     g.setClip(0 , 0, screenWidth, screenHeight);
     g.drawString(aipandayamStr, margin + gridSize*8, 2, g.TOP|g.LEFT);

     g.setClip(margin/2, 2 , gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
     g.drawImage(gameImage[0], margin/2 , 2  , g.TOP|g.LEFT); 
     g.setClip(0 , 0, screenWidth, screenHeight);
     g.drawString(pandayamStr, margin, 2, g.TOP|g.LEFT);
    }
    else
    {

if(playercoinendIdx == 0)
{
     g.drawImage(gameImage[13], 2, 2 , g.TOP|g.LEFT); 
}

if(aicoinendIdx == 0)
{
     g.drawImage(gameImage[14], 2, 2, g.TOP|g.LEFT); 
}


    }
     
//aipandayamStr

     x5 = 2;
     y5 = 2 + gridSize * 19 + gridSize;

     int playerprevLoc = -1, coinprevLoc = -1;


     for(int count = 0; count < 4; count++)
     {
      
        if(playercoin[count] != 0 && playercoin[count] != 79)
        {  
        convertBoard(playercoin[count]);
        if(playerprevLoc == playercoin[count])
        {
//player malai blue
         g.setColor(0x0000ff); 
         if(count < 67)  
         g.fillRect(point[0]+1, point[1], gridSize, gridSize);
         else    
         g.fillRect(point[0]+1, point[1], sgridSize, sgridSize);
        }
        else
        {
         if(count < 67)    
         {
           point[0] += 2;
         }    
        g.setClip(point[0],  point[1] + 1, gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
        g.drawImage(gameImage[0], point[0], point[1], g.TOP|g.LEFT); 
        g.setClip(0 , 0, screenWidth, screenHeight);
        }
        playerprevLoc = playercoin[count];
        }

        if(aicoin[count] != 80 && aicoin[count] != 79)  
        { 
        convertBoard(aicoin[count]);
        if(coinprevLoc == aicoin[count])
        {
//ai malai green
         g.setColor(0x800080); 

         if(count < 87 )  
         g.fillRect(point[0]+1, point[1], gridSize, gridSize);
         else    
         g.fillRect(point[0]+1, point[1], sgridSize , sgridSize);

        }
        else
        {
         if(count < 87)    
         {
           point[0] += 2;
         }     
        point[0] -= gameImage[0].getWidth()/2;
        g.setClip(point[0] + gameImage[0].getWidth()/2, point[1] + 1 , gameImage[0].getWidth() / 2, gameImage[0].getHeight()); 
        g.drawImage(gameImage[0], point[0], point[1]+1 , g.TOP|g.LEFT); 
        g.setClip(0 , 0, screenWidth, screenHeight);
        } 
        coinprevLoc = aicoin[count];   
        }
//System.out.println("aicoin locations "+ count +" "+aicoin[count]);
     } 

//     convertBoard(61);
//     g.drawRect(point[0], point[1], gridSize, gridSize);     

//nagarum kattum

     g.setColor(0xff0000);

     convertBoard(cursorIdx);
     dx = point[0];
     dy = point[1]; 

     g.setColor(0xff0000);

     if(cursorIdx == 13)
     {
      g.drawRect(dx , dy - gridSize, gridSize, 2*gridSize);
     }     
     else if(cursorIdx == 61)
     {
      g.drawRect(dx , dy, gridSize, 2*gridSize);
     }     

     else if(cursorIdx <= 65)
     {   
      g.drawRect( dx , dy, gridSize, gridSize);
     }
     else if(cursorIdx == 79)
     {
      g.drawRect( A7 - gridSize * 3, B7 - gridSize * 4 - 2 , gridSize * 7 - 2, gridSize * 3 ); 
     }
     else   
     {   
      g.drawRect( dx , dy, sgridSize , sgridSize );

     }    


if(repeatFlag == 0)
{
        g.drawImage(gameImage[8], pointx[4], pointy[4], g.TOP|g.LEFT); 
}
else if(repeatFlag == 1)
{
        g.drawImage(gameImage[9], pointx[4], pointy[4], g.TOP|g.LEFT); 
}
else if(repeatFlag == 2)
{
        g.drawImage(gameImage[10], pointx[4], pointy[4], g.TOP|g.LEFT); 
}
else if(repeatFlag == 3)
{
  g.drawImage(gameImage[11], pointx[4], pointy[4], g.TOP|g.LEFT);       
}

 g.drawImage(gameImage[12], pointx[5], pointy[5], g.TOP|g.LEFT); 




}


// oru ennai thirai pullikku matrum 

//convertboard calculation should work with reference to drawgamepage logic

public void convertBoard(int count)

{

   int x = 0, y=0;
   int width;

if(count != 79)
{
System.out.println("thulliam count"+thulliamLayer[count]+" "+count );
 
   width = (screenWidth - 2 * smargin[count])/thulliamLayer[count];

   x = (((layerPattern[count] - 1) % width))*thulliamLayer[count];

System.out.println("x "+x );

   x += smargin[count];
   point[0] =  x;


//4th quad mapping -y which means height - y
//(0,y) is Screen origin which is shifted to (0,0)

   y = (((layerPattern[count] - 1)/ width) + 1)*thulliamLayer[count];

System.out.println("y "+y );

   y = screenHeight -3*thulliamLayer[count] - y;
   point[1] =  y;




System.out.println("width sc height thu "+width+" " + screenWidth+" " + screenHeight+" " + thulliamLayer[count]);
System.out.println("p0, p1, layer count"+" " + point[0]+" " + point[1]+" " + layerPattern[count]+" " + count);
}
}

public void Scores(Graphics g)
{
  clearScreen(g, 0x00ff5d);
  g.setColor(0xff0000);
  g.drawString("Your Score :" + score, 10, 10, g.TOP|g.LEFT);

}


public void Help(Graphics g)
{
//System.out.println("Help Screen");

//angila mozhi ellaku

/*
clearScreen(g, 0x00ff5d);//back ground
g.setColor(0xff0000);//fore ground

String instructions =
"????? ?????? ??????? ??? ????????? ??????????.";
//"";

int currentPage = 0, COLUMNWIDTH = 10;

for(int row = 0; row < NOOFROWS; row++)
{

g.drawString(instructions.substring((row+currentPage)*COLUMNWIDTH, (row+currentPage+1)*COLUMNWIDTH  ),1 ,row * 10 , g.TOP|g.LEFT);

}

*/

//clearScreen(g, 0x00ff5d);//back ground

//TamilEzthu.varaiSotrodar(g);

//TamilEzthu.varaiEzthu(g);


g.drawImage( gameImage[7],0 , -neendaPakkam*10 , g.TOP|g.LEFT);
g.drawImage( gameImage[12],161 ,265, g.TOP|g.LEFT);

}





public void About(Graphics g)
{
  //System.out.println("About Screen");

  g.drawImage( gameImage[6],0 , 0 , g.TOP|g.LEFT);

  /*clearScreen(g, 0x00ff5d);
  String aboutText = "Daayam \n V1.0.0 \n Qkadir Tech \n Copyright 2007 \n All Rights Reserved.";
  g.setColor(0xff0000);
  g.drawString("Daayam", 10, 10, g.TOP|g.LEFT);
  g.drawString("V2.0.0", 10, 30, g.TOP|g.LEFT);
  g.drawString("Neutech Software, Arcot ", 10, 50, g.TOP|g.LEFT);
  g.drawString("Copyright 2010", 10, 70, g.TOP|g.LEFT);
  g.drawString("All Rights Reserved", 10, 90, g.TOP|g.LEFT);
*/
}


public void putDice()
{

int pandayamkuttal = 0, pandayamvendum = 0;
int dayamVendum = 0;

int index1 = 0;

//thani kay matrum thani pandayam 60 il 15 il therchi adinthal than attam undu
//thani kay, thani pandayam nilai kuriedu

 
int kuttal = 0;

int counter1 = 0,counter2 = 0,counter3 = 0;

//kurippu 7 dayam viyunthal attam mudika
for(int ennikai = 0;ennikai < 4; ennikai++)
{

if(playercoin[ennikai] == 78)
{
dayamVendum++;
}

}



// kurippu 7

pandayamLoop = 0;

     int rno = Math.abs(random.nextInt());

//System.out.println("pandayam " + rno);

     pandayam[pandayamIdx] = (byte)(rno % 16);

//System.out.println("pandayam " + pandayam[pandayamIdx]);

     if((pandayam[pandayamIdx] == 0 ||
        pandayam[pandayamIdx] == 1 ||
        pandayam[pandayamIdx] == 4 ||
        pandayam[pandayamIdx] == 11 ||
        pandayam[pandayamIdx] == 14 ||
        pandayam[pandayamIdx] == 15 ) &&
        pandayamIdx <= 4
       )
       {

//kurippu 8
        if(dayamVendum == 1 && (pandayam[0] == 11 || pandayam[0] == 14))
        {

          repeatFlag = 2;
          
        }
        else
        {    
//end kurippu 8
         repeatFlag = 1;
        } 
       }
//     else if(pandayamIdx >= 4)
//       {
//

//         repeatFlag = 0;

//         pandayamIdx = 0;
         
//         pandayam[pandayamIdx] = (byte)convertPandayam(pandayam[pandayamIdx]);
        
//         pandayamIdx++; 

//         pandayamStr = ""; 

 
//         for(int count = 0; count < pandayamIdx ; count++)
//         {
//           pandayamStr += pandayam[count] + " ";
//         }


//       }

     else
       {
         repeatFlag = 2;
       } 


     if(pandayamIdx < 5)
       {

//System.out.println("pIndex " + pandayamIdx); 
//System.out.println("pIndex " + pandayam[pandayamIdx]); 

     pandayam[pandayamIdx] = (byte)convertPandayam(pandayam[pandayamIdx]);

//System.out.println("pIndex " + pandayamIdx);     

//kurippu "edu" edathukku vendum endral thallikollalam

     if(pandayam[pandayamIdx] == 1)
     {

       if((playercoinendIdx - coinIdx) > 0)

          {

            int index = 0;

            for(index = 0; playercoin[index] != 0 && index < 4; index++)
            {
               ;
            }

            pandayam[pandayamIdx] = 0;  
            playercoin[index] = 1;       
            coinIdx++;
            pandayamIdx--;

          }

        repeatFlag = 1;

     }

     //System.out.println("pandayam value repeatFlag "  + repeatFlag);

     pandayamIdx++; 

     pandayamStr = ""; 
 
     for(int count = 0; count < pandayamIdx ; count++)
     {
       pandayamStr += pandayam[count] + " ";
     }


     //System.out.println("pandayam string" + pandayamStr);       
     } 
 
 



/*cheat code

pandayam[0] = 4;
pandayam[1] = 0;
pandayam[2] = 0;
pandayam[3] = 0;
pandayam[4] = 0;


playercoin[0] = 75;
playercoin[1] = 79;
playercoin[2] = 79;
playercoin[3] = 79;

aicoin[0] = 79;
aicoin[1] = 79;
aicoin[2] = 94;
aicoin[3] = 79;


aicoinIdx = 1;
coinIdx=1;
aicoinendIdx=1;
playercoinendIdx=1 ;
pandayamIdx = 1;
repeatFlag = 2;
end cheat code
*/


// attam illai 



for(int count0 = 0; count0 < 4; count0++)
{

if(pandayam[count0] >= 0)
{

pandayamkuttal += pandayam[count0];

}

if(playercoin[count0] != 0)

{

  pandayamvendum += 79 - playercoin[count0];

}

}

if(pandayam[4] >= 0)
{

pandayamkuttal += pandayam[4];

}

System.out.println("pandayam kuttal" + pandayamkuttal +" "+ pandayamvendum);

if( pandayamkuttal > pandayamvendum || pandayamIdx >= 5)
{

System.out.println("pandayam gt kuttal");

AIPlay();

repeatFlag = 0;

for(int i = 0; i < 5; i++)
{

      pandayam[i] = 0;

}

pandayamIdx = 0;

}


pandayamLoop = pandayamIdx;



//oru nagarthal, irrandu nagarthal, mondru nagarthal, nangu nagarthal, iyanthu nagarthal kurikkum suyarchi 

// ov-oru pandayam maka kali iddam thedal


if(repeatFlag != 0 && pandayamIdx != 0  )
{

System.out.println("inside v & v");

kuttal = 0;

attamCounter = 0;

for(int count7 = 0; count7 < 4; count7++)
{

  nilai1[count7] = 0x0;
  nilai2[count7] = 0x11111;

}

counter1 = 0;

for(int count0 = 0; count0 < pandayamIdx ; count0++)
{

   kuttal = pandayam[count0];

   checkVazhi(kuttal, 0, 0); 

   if(attamCounter >= 1)
   {
    counter1++;
   }

attamCounter = 0;

}


attamCounter = 0;


// pandayam motham kutti kali iddam thedal

kuttal = 0;
counter2 = 0;

for(int count1 = 0; count1 < pandayamIdx ; count1++)
{
   kuttal += pandayam[count1];
   
}

checkVazhi(kuttal, 2, 0);
counter2 = attamCounter;

attamCounter = 0;

// naduvu pandayam pandayam kutti kali iddam thedal

kuttal = 0;
index1 = 0;
counter3 = 0;

for(int count2 = 0; count2 < pandayamIdx - 1; count2++)
{
   kuttal = 0;

for(int count3 = 0; count3 < pandayamIdx - 1; count3++)
{

   kuttal += pandayam[index1+1];
   index1++;
   index1 = index1 % (pandayamIdx - 1);
   
}

checkVazhi(kuttal, 1, count2);

if(attamCounter >= 1)
{  
counter3++;
}

attamCounter = 0;

}



System.out.println("atamcounter "+ counter1+ " "+ counter2+" "+counter3);

//idamKali 5 enna seya vendum ?
if(
   counter1 == pandayamIdx - 1  ||
   counter2 >= 1 ||
   counter3 >= 1
  )
{
 ;
}
else
{
 AIPlay();
 repeatFlag = 0;
for(int i = 0; i < 5; i++)
{
      pandayam[i] = 0;
}
pandayamIdx = 0;

}

}// end if repeatFlag!=0 check



}

public void checkVazhi(int kuttal, int kuttalFlag, int prevcount)
{

int counter = 0;

int gc = 0;

for(int count5 = 0; count5 < 4; count5++)
{

counter = 0;

for(int count6 = 0; count6 < 4; count6++)
{
//kai ondrodu ondru muttikitu nirkum eddam

gc++;

System.out.println("gc count5  ai count6 kuttal " +gc+" "+ playercoin[count5] + " " + aicoin[count6] + " " 
                                              + playercoin[count6] + " " + kuttal );

//kali, vettu, malai, kali

if(
     (playercoin[count5] != 0 &&  playercoin[count5] != 79) &&
     (
       

       ((playercoin[count5] + kuttal) !=  aicoin[count6]
        )  &&
     
        (
        aicoin[count6] != 7  &&
        aicoin[count6] != 13 &&
        aicoin[count6] != 19 &&
        aicoin[count6] != 25 &&
        aicoin[count6] != 31 &&
        aicoin[count6] != 37 &&
        aicoin[count6] != 43 &&
        aicoin[count6] != 49 &&
        aicoin[count6] != 55 &&
        aicoin[count6] != 66 
        ) ||

        ((playercoin[count5] + kuttal) ==  aicoin[count6]
        )  &&
     
       (
        aicoin[count6] != 7  &&
        aicoin[count6] != 13 &&
        aicoin[count6] != 19 &&
        aicoin[count6] != 25 &&
        aicoin[count6] != 31 &&
        aicoin[count6] != 37 &&
        aicoin[count6] != 43 &&
        aicoin[count6] != 49 &&
        aicoin[count6] != 55 &&
        aicoin[count6] != 66 
       ) ||
    

       ((playercoin[count5] + kuttal) !=  playercoin[count6] 
        ) &&
       ( 
        playercoin[count6] != 7  &&
        playercoin[count6] != 13 &&
        playercoin[count6] != 19 &&
        playercoin[count6] != 25 &&
        playercoin[count6] != 31 &&
        playercoin[count6] != 37 &&
        playercoin[count6] != 43 &&
        playercoin[count6] != 49 &&
        playercoin[count6] != 55 &&
        playercoin[count6] != 66 

       ) ||

       ((playercoin[count5] + kuttal) ==  playercoin[count6] 
        ) &&
       ( 
        playercoin[count6] == 7  ||
        playercoin[count6] == 13 ||
        playercoin[count6] == 19 ||
        playercoin[count6] == 25 ||
        playercoin[count6] == 31 ||
        playercoin[count6] == 37 ||
        playercoin[count6] == 43 ||
        playercoin[count6] == 49 ||
        playercoin[count6] == 55 ||
        playercoin[count6] == 66 
       )  

    )
  )

{

counter++;

System.out.println("chekvazhi counter " + counter);

}

if(counter == 4)
{

System.out.println("kuttalFlag counter " + kuttalFlag + " " +counter);

  attamCounter++;

if(kuttalFlag == 0)
{



nilai1[count5] |= 0x10000 >> count5 ;

System.out.println("nilai1 " + nilai1[count5]);

};

if(kuttalFlag == 1)
{

nilai2[count5] &= 0x10000 >> count5 ;

System.out.println("nilai2 " + nilai2[count5]);

if((nilai1[count5] & (0x10000 >> count5)) == 0x10000 >> count5 )
{

System.out.println("nilai2 ok");

 attamCounter = 0;

}

}

}

}// inner end for

}// mudal kazhi 



}




public int convertPandayam(int idx)
{
  //System.out.println("idx value " + idx);
  return diceValue[idx]; 
}

public void pick()
{


// payam sendra piraku suyarchi thattuka

  if(cursorIdx != 79) 
   {

      pickIdx = cursorIdx; 
      for(int i = 0; i < 4; i++)
      {
        if((playercoin[i] == pickIdx) || (playercoin[i] == 61 && pickIdx == 13) )
        {
           playermovecoinIdx = i;
           repeatFlag = 3; 
           break; 
        }  
      } 
   } 
  else
   {
      repeatFlag = 2;
   }   
 
   

}




public void keep()

{

int index  = 0;


// atahey idathil vaipathu thaduka matrum pinnal chelvathu thaduka

     if(cursorIdx == pickIdx )
       {
          repeatFlag = 2;   
       }



// oru pandayam, oru kai athuvum payam eduka mudiyavillai endral pudhiya attam thodanka

    if((playercoinendIdx == 1) && (cursorIdx == 79) && (pandayam[0] !=  (cursorIdx - pickIdx)))
    {
System.out.println("pand pick"+pandayam[0]+" "+pickIdx);
      repeatFlag = 0;
    }

// ondrukku mel pandayam, oru kai athuvum payam eduka mudiyavillai endral pudhiya attam thodanka

    for(index = 0; index < 4 && pandayam[index] == -1; index++) 
    {
      ;
    }

    if((playercoinendIdx == 1) && (cursorIdx == 79) && (pandayam[index] !=  (cursorIdx - pickIdx)))
    {
System.out.println("index pand pick"+index+" "+pandayam[index]+" "+pickIdx);
      repeatFlag = 0;
    }


// ondurkku mel pandayam , nagartha vazhi illai






 
 for(int count = 0; count <= pandayamLoop && repeatFlag == 3 ; count++)
 {

   for(int count1 = 0; count1 < 4; count1++)
   {
    if(pandayam[count] == (cursorIdx - pickIdx) &&
      cursorIdx == aicoin[count1] &&
      ( aicoin[count1] != 7  &&
        aicoin[count1] != 13 &&
        aicoin[count1] != 19 &&
        aicoin[count1] != 25 &&
        aicoin[count1] != 31 &&
        aicoin[count1] != 37 &&
        aicoin[count1] != 43 &&
        aicoin[count1] != 49 &&
        aicoin[count1] != 55 &&
        aicoin[count1] != 66 &&
        aicoin[count1] != 79
       )
      ) 
      {
        aicoin[count1] = 80;
        aicoinIdx--;
        vettuFlag = true;
//        repeatFlag = 2;
//        break;
      }

      if(pandayam[count] == (cursorIdx - pickIdx) &&
      cursorIdx == aicoin[count1] &&
      ( aicoin[count1] == 7  ||
        aicoin[count1] == 13 ||
        aicoin[count1] == 19 ||
        aicoin[count1] == 25 ||
        aicoin[count1] == 31 ||
        aicoin[count1] == 37 ||
        aicoin[count1] == 43 ||
        aicoin[count1] == 49 ||
        aicoin[count1] == 55 ||
        aicoin[count1] == 66 
       )
      ) 
      {
        repeatFlag = 0;
        break;
      }

      if(pandayam[count] == (cursorIdx - pickIdx) &&
      cursorIdx == playercoin[count1] &&
      ( playercoin[count1] != 7  &&
        playercoin[count1] != 13 &&
        playercoin[count1] != 19 &&
        playercoin[count1] != 25 &&
        playercoin[count1] != 31 &&
        playercoin[count1] != 37 &&
        playercoin[count1] != 43 &&
        playercoin[count1] != 49 &&
        playercoin[count1] != 55 &&
        playercoin[count1] != 66 &&
        playercoin[count1] != 79 
       )
      ) 
      {
        repeatFlag = 0;
        break;
      }

    }

//kurippu 3 61 ill vaikka atavathu cursorIdx == 13, playercoin to 61 matra

   if(pickIdx > 13 && cursorIdx == 13 && pandayam[count] == (61 - pickIdx) && repeatFlag == 3
     )  
   {

     playercoin[playermovecoinIdx] = 61;
     pandayamIdx--;
     pandayam[count] = 0;  
     if(pandayamIdx != 0)
     {
      repeatFlag = 2;
      break;    
     }
     else
     {
       repeatFlag = 0;
       break;    
     }
   }

//en kurippu 3

//kurippu 4

// cursorIdx == 13 and playercoin == 61


//end kurippu 4

if(playercoin[playermovecoinIdx] != 61 && pandayam[count] == (cursorIdx - pickIdx) && repeatFlag == 3 ||
      playercoin[playermovecoinIdx] == 61 && pickIdx == 13 && pandayam[count] == (cursorIdx - 61) && repeatFlag == 3 
     )  
   {
  
     playercoin[playermovecoinIdx] = (byte)cursorIdx;
     pandayamIdx--;
     pandayam[count] = 0;

     if(cursorIdx == 79) 
     {
       playercoinendIdx--;
       coinIdx--;
     }
 
     if(pandayamIdx != 0)
     {
      repeatFlag = 2;
      break;    
     }
     else
     {
       repeatFlag = 0;
       break;    
     }
   }
// else
// {
//      repeatFlag = 2;
//      break;    
// }  

 }

if(pandayamIdx != 0 && repeatFlag == 3)
{
      repeatFlag = 2;
      
}

     pandayamStr = ""; 
// Code added to take care of accessing pandayam array when pandayam index decrements
//     for(int count = 0; count < 4 && swapFlag == 1; count++)
//     {
//        pandayam[count] = pandayam[count+1];
//
//     }



     for(int count = 0; count <= 4 ; count++)
     {
       if(pandayam[count] != 0)
       {      
        pandayamStr += pandayam[count] + " ";
       }
     }


if(repeatFlag == 0)
{
//System.out.println("AIPlay called inside keep");
       AIPlay();
}


}

public void AIPlay()
{
     int rno;
     int temp = 0;
     int overlappedplayercoin = 0, overlappedaicoin = 0;
     int aipandayamcount = 0;
     int aidayamVendum = 0; 
     aipandayamIdx = 0;   

//kurippu 6 dayam viyunthal attam mudika
for(int ennikai = 0;ennikai < 4; ennikai++)
{

if(aicoin[ennikai] == 98)
{
aidayamVendum++;
}

}

// kurippu 6

if(aicoinendIdx == 0)
{
//aipandayamStr += "You Lost! Game Over";
}
aipandayamStr = " ";
//System.out.println("step 1");

     prevaicoinIdx = aicoinIdx;
     prevaicoinendIdx   = aicoinendIdx;
     prevcoinIdx    = coinIdx;
     prevplayercoinendIdx = playercoinendIdx;

     for(int count1 = 0; count1 < 4; count1++) 
     {
        prevplayercoin[count1] = playercoin[count1];  
        prevaicoin[count1] = aicoin[count1];  
        aipandayam[count1] = 0;
     } 
 aipandayam[4] = 0;
//System.out.println("step 2");
     while(aipandayamcount < 5)
     {
     rno = Math.abs(random.nextInt());
     aipandayam[aipandayamIdx] = (byte)(rno % 16);
     aipandayam[aipandayamIdx] = (byte)convertPandayam(aipandayam[aipandayamIdx]); 
aipandayamStr += aipandayam[aipandayamIdx] + " " ;

//System.out.println("step 2.1 " + aipandayamStr);

     if(aipandayam[aipandayamIdx] == 1 && (aicoinendIdx - aicoinIdx ) > 0)
     {
// oru mathiri coin thoyium poyuthu kadaisi kaiyai matrum kuraiyai sari seya 
         int index = 0;
         for(index = 0; aicoin[index] != 80 && index < 4; index++)
          {
             ;
          }  
         aicoin[index] = 81;
         aicoinIdx++;
         board[1]++;
         
     }   

     if(aipandayam[aipandayamIdx] == 1 ||
        aipandayam[aipandayamIdx] == 5 ||
        aipandayam[aipandayamIdx] == 6 ||
        aipandayam[aipandayamIdx] == 12 
       )
      {

//kurippu 5
        if(aidayamVendum == 1 && aipandayam[0] == 1)
        { 
          break;
        }    
//end kurippu 5

        if(aipandayam[aipandayamIdx] != 1 ||
           aipandayam[aipandayamIdx] == 1 && (aicoinendIdx - aicoinIdx )  == 0
          )
        {
        aipandayamIdx++;
        }
  
        aipandayamcount++;

        

 
        continue;  
      }
      else 
      {
        break;
      } 
    }
   
//System.out.println("step 3");

if(aipandayamcount >= 5 )
{
//aipandayamStr += "Exceeded Pandayam";
}

if(aicoinIdx == 0 )
{
//aipandayamStr += "No Dayam";
}


     if(aipandayamcount < 5 &&  aicoinIdx  != 0)
     {   

       for(int count1 = 0; count1 < 4; count1++)
       {

if(aicoin[count1] == 79)
{
continue;
}
         for(int count2 = 0; count2 < 5; count2++)
         {
            sum = 0;     
            for(int count3 = 0; count3 <= count2; count3++)
            {
                sum += aipandayam[count3];
            }  

//System.out.println("sum iteration "+ count2);

if(sum != 0)
{
temp = aicoin[count1];

//System.out.println("temp aicoin sum "+temp+" "+aicoin[count1]+" "+sum);

//Normalization

if(aicoin[count1] >= 81 && aicoin[count1] <= 86)
{
temp = temp - 80;
}
else if(aicoin[count1] > 13 && aicoin[count1] <= 37 )
{
temp = temp + (37 - temp) * 2;
}
else if(aicoin[count1] > 37 && aicoin[count1] <= 60 )
{
temp = temp - (temp - 37) * 2 ;
}
else if(aicoin[count1] > 86 && aicoin[count1] <= 98 )
{
temp = temp - 20;
}

//end Normalization


temp += sum;

if(temp < 7 )
{

temp = temp + 80;

//System.out.println("phase 1");

}

else if(temp > 66 && temp <= 78 )
{

temp = temp + 20;
//System.out.println("phase 2");
}

else if(temp > 13 && temp <= 37 )
{

temp = (37 - temp) * 2 + temp;
//System.out.println("phase 3 "+temp);
}

else if(temp > 37 && temp <= 60 )
{

temp = temp - (temp - 37) * 2 ;
//System.out.println("phase 4 "+temp);
}
else if(temp > 79)
{
continue;
} 

if(temp == 79)
{
aicoinendIdx -= 1;
aicoinIdx--;
aicoin[count1]= 79;
for(int count4 = 0; count4 <= count2; count4++)
{
   aipandayam[count4]=0;
}  
continue;
}
                        
for(int count5 = 0; count5 < 4; count5++)
{
if( (temp == playercoin[count5]) &&
       playercoin[count5] != 0  &&   
       playercoin[count5] != 7  &&
       playercoin[count5] != 13 &&
       playercoin[count5] != 19 &&
       playercoin[count5] != 25 &&
       playercoin[count5] != 31 &&
       playercoin[count5] != 37 &&
       playercoin[count5] != 43 &&
       playercoin[count5] != 49 &&
       playercoin[count5] != 55 &&
       playercoin[count5] != 66 &&
       playercoin[count5] != 79
     ) 
{

playercoin[count5] = 0;
coinIdx--;
aicoin[count1] = (byte)temp;

for(int count4 = 0; count4 <= count2; count4++)
{
   aipandayam[count4]=0;
}  


}//end if playercoin 

}//end for playercoin

for(int count7 = 0; count7 < 4 ; count7++)
{
 if( temp == playercoin[count7] &&
       (
       playercoin[count7] == 0  ||   
       playercoin[count7] == 7  ||
       playercoin[count7] == 13 ||
       playercoin[count7] == 19 ||
       playercoin[count7] == 25 ||
       playercoin[count7] == 31 ||
       playercoin[count7] == 37 ||
       playercoin[count7] == 43 ||
       playercoin[count7] == 49 ||
       playercoin[count7] == 55 ||
       playercoin[count7] == 66 
       ) 
     ) 
{
overlappedplayercoin = 1;
break;
}

}



for(int count8 = 0; count8 < 4 ; count8++)
{

if(count8 == count1)
{
break;
}


 if( temp == aicoin[count8] &&
       (
       aicoin[count8] != 80 &&   
       aicoin[count8] != 7  &&   
       aicoin[count8] != 13 &&   
       aicoin[count8] != 19 &&   
       aicoin[count8] != 25 &&   
       aicoin[count8] != 31 &&   
       aicoin[count8] != 37 &&   
       aicoin[count8] != 43 &&   
       aicoin[count8] != 49 &&   
       aicoin[count8] != 55 &&   
       aicoin[count8] != 66 &&   
       aicoin[count8] != 79 
       ) 
     ) 
{
overlappedaicoin = 1;
break;
}

}

if(overlappedplayercoin != 1 &&
   overlappedaicoin != 1
  )
{

//kurai 2 ullathaga santhekam ulla edam 

aicoin[count1] = (byte)temp;
for(int count4 = 0; count4 <= count2; count4++)
{
   aipandayam[count4]=0;
}  

}

}//end for pandayam
}//end for aicoin

}//end if sum!=0


////System.out.println("step 11");

     boolean revert = false;
     for(int count2 = 0; count2 < 5; count2++)
     {
        if(aipandayam[count2] != 0)
        {
////System.out.println("step 11.1");
          revert = true; 
          break;

        }      
     }     

     
     if(revert)
     {  

     aicoinIdx = prevaicoinIdx;
     aicoinendIdx   = prevaicoinendIdx;
     coinIdx    = prevcoinIdx;
     playercoinendIdx = prevplayercoinendIdx;

     for(int count1 = 0; count1 < 4; count1++) 
     {
        playercoin[count1] = prevplayercoin[count1];  
        aicoin[count1] =     prevaicoin[count1];  
     } 
     }             
////System.out.println("step 12");

    }//if


}                
}

