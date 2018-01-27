/*

Programmer: K. Manigandan
StartDate:  21/08/2007
Version:    1.0

*/

package co.in.dayam;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class DayamCanvas extends Canvas implements CommandListener
{
 

     public Command ok   = new Command("sari", Command.OK, 0);
     public Command exit = new Command("Veliyae", Command.EXIT, 0);
     public Command back = new Command("Pinnal", Command.BACK, 0);
     public Command play   = new Command("Podu", Command.OK, 0);
     public Command repeat   = new Command("Marumurai", Command.OK, 0);
     public Command pick    = new Command("Edu", Command.OK, 0);
     public Command keep    = new Command("Vai", Command.OK, 0);
     public DayamMidlet midlet1;

     public GameData gd;

     DayamCanvas(MIDlet mid)
     {
          System.out.println("exit");
	    
//          GameData.screenWidth  = getWidth();        
//          GameData.screenHeight = getHeight();       
 GameData.screenWidth  = 128;        
          GameData.screenHeight = 160;  
          gd = new GameData();
        setFullScreenMode(true);
          midlet1 = (DayamMidlet)mid; 
          gd.screenFlag = 1;
          setCommandListener(this);
    

     };

     public void paint(Graphics g)
     {

           remove();

           switch(gd.screenFlag)
           {
                case 0://Resume
                     gd.MainMenu(g, true); 
                     addCommand(ok);
                     addCommand(exit);
                     break;

                case 1://without resume
                     gd.MainMenu(g, false);
//                     removeCommand(back);
//                     removeCommand(play);
                           
                     addCommand(ok);
                     addCommand(exit);
                     break;

                case 2://Game

                     gd.GamePage(g);

                     if(gd.repeatFlag == 0) 
                     {
                          addCommand(play);
System.out.println("play " + gd.repeatFlag);
//                          removeCommand(pick);
//                          removeCommand(keep);
//                          removeCommand(repeat);
                     }
                     else if(gd.repeatFlag == 1)
                     {
//                          removeCommand(play);
//                          removeCommand(pick);
//                          removeCommand(keep);
                          addCommand(repeat);
                     }
                     else if(gd.repeatFlag == 2)
                     {
//                          removeCommand(play);
                          addCommand(pick);
System.out.println("pick");
//                          removeCommand(keep);
//                          removeCommand(repeat);
                     }
                     else
                     {
//                          removeCommand(play);
//                          removeCommand(pick);
                          addCommand(keep);
//                          removeCommand(repeat);

                     }
//                     removeCommand(exit);
//                     removeCommand(ok);
                     addCommand(back);
                     break;


                case 5://Scores
                     gd.Scores(g);
//                     removeCommand(ok);
//                     removeCommand(exit);
                     addCommand(back);
                     break;


                case 3://Help
                     gd.Help(g);
//                     removeCommand(ok);
//                     removeCommand(exit);
                     addCommand(back);
                     break;

                case 4://About
                     gd.About(g);
//                     removeCommand(ok);
//                     removeCommand(exit);
                     addCommand(back);
                     break;


           }
       };
     
     public void commandAction(Command cmd, Displayable dis)
     {
         
           System.out.println("Command Action called...");
           if(cmd == ok)
           {      
               System.out.println("Command Action inside ok");
               gd.screenFlag = gd.menuItemIdx + 2;// + gd.resumeGameFlag? 1 : 0 ;
               repaint();
               
           }
           else if (cmd == exit)
           {
               System.out.println("Exit");
               midlet1.closeApp();
           }
           else if (cmd == back)
           {
               gd.screenFlag = 1;
               repaint();
           }
           else if (cmd == play)
           {
//thiraikku mattum than upayogam, thiraikkul 'repeatFlag' than ullathu. 
              gd.screenFlag = 2;
              gd.pandayamStr = "";
              gd.pandayamIdx = 0;
              gd.putDice();
 
//gd.AIPlay();
              repaint(); 
               
           }
           else if (cmd == repeat)
           {
//thiraikku mattum than upayogam, thiraikkul 'repeatFlag' than ullathu. 
              gd.screenFlag = 2;
              gd.putDice();
              repaint(); 
           }
           else if (cmd == pick)
           { 
             gd.pick();
             gd.screenFlag = 2;  
             repaint();
           }
           else if (cmd == keep)
           {
             gd.keep();
             gd.screenFlag = 2;
             repaint(); 
          } 
     }

     public void keyPressed(int keyCode)
     {
          System.out.println("Key Pressed");
       int ga;
       ga = getGameAction(keyCode);
       System.out.println("ga keycode " + ga+" "+ keyCode);   
       switch(gd.screenFlag)
       {  
          case 1:     
          switch(ga)
          {
            case Canvas.LEFT:
                 gd.menuItemIdx--;
                 if(gd.menuItemIdx < 0)
                 {
                   gd.menuItemIdx = 2;
                 } 
System.out.println("menuItemIdx" + gd.menuItemIdx);
                 break;
         
            case Canvas.RIGHT:
                 gd.menuItemIdx++;

                 if(gd.menuItemIdx > 2)
                 {
                   gd.menuItemIdx = 0;
                 } 
System.out.println("menuItemIdx" + gd.menuItemIdx);
                 break;
         
          }
          break;

          case 2:
          switch(keyCode)
          {

            case 48:
                      if(gd.munnarNilai != 0)
                      { 
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ; 
                      }
                      gd.munnarNilai = keyCode - 48;
                      break;

            case 49:
                      
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;

            case 50:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;
            case 51:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;

            case 52:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;


            case 53:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;

            case 54:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;

            case 55:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 48;
                      break;


//munnarNilai 79 ikku mel pogakudathu
            case 56:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 56;
                      break;

            case 57:
                      gd.cursorIdx = gd.munnarNilai * 10 + keyCode - 48 ;
                      gd.munnarNilai = keyCode - 57;
                      break;



             
              


          }
 
          switch(ga)
          {
            
            case Canvas.LEFT:

                 if(gd.cursorIdx == 13 )
                   {
                        gd.cursorIdx = 60;
                        gd.dx -= gd.gridSize;
                   }  
                 else if(gd.cursorIdx == 61) 
                   { 
                        gd.cursorIdx = 60;
                        gd.dx -= gd.gridSize;
                        gd.dy += gd.gridSize;
                   }   
                 else if(gd.cursorIdx > 1  && gd.cursorIdx <= 7                                    
                    || gd.cursorIdx > 12 && gd.cursorIdx <= 19 
                    || gd.cursorIdx > 55 && gd.cursorIdx <= 60
                    
                   )
                   { 
                        gd.cursorIdx--;
                        gd.dx -= gd.gridSize;
                   }
                  else if(gd.cursorIdx > 30 && gd.cursorIdx < 43)
                   { 
                        gd.cursorIdx++;
                        gd.dx -= gd.gridSize;
                   }
                   else if (gd.cursorIdx > 65 && gd.cursorIdx < 72) 
                   {
                        gd.cursorIdx++;
                        gd.dx -= gd.sgridSize ;

                   }
                   else if(gd.cursorIdx == 79)
                   {
                     gd.cursorIdx = 1;
                     gd.dx = 14 + 2;
                     gd.dy = 2 + gd.gridSize * 19 + gd.gridSize;
                   }   
                 break;
            case Canvas.RIGHT:
                 
                 if(gd.cursorIdx == 60)
                 {
                        gd.cursorIdx = 13;   
                        gd.dx += gd.gridSize;
                 }    
                 else if(gd.cursorIdx >= 1 && gd.cursorIdx < 7
                    || gd.cursorIdx >= 13 && gd.cursorIdx < 19 
                    || gd.cursorIdx >= 55 && gd.cursorIdx < 61
                   )
                   { 
                        gd.cursorIdx++;
                        gd.dx += gd.gridSize;
                        
                   }

                  else if(gd.cursorIdx > 31 && gd.cursorIdx <= 43)
                   {
                        gd.cursorIdx--;
                        gd.dx += gd.gridSize;
                   }     
                  else if(gd.cursorIdx > 66 && gd.cursorIdx <= 72)
                   {
                        gd.cursorIdx--;
                        gd.dx += gd.sgridSize ;
                   }  
                  else if(gd.cursorIdx == 79)
                   { 
                        gd.cursorIdx = 1;
                        gd.dx = 14 + 2;
                        gd.dy = 2 + gd.gridSize * 19 + gd.gridSize;

                   }    
                 break;

            case Canvas.UP:

 
                 if(gd.cursorIdx == 13)
                 {
                    gd.cursorIdx = 62;   
                    gd.dy -= 2*gd.gridSize;
                 }
                 else if(gd.cursorIdx >= 7 && gd.cursorIdx < 13
                    || gd.cursorIdx >= 19 && gd.cursorIdx < 31 
                    || gd.cursorIdx >= 61 && gd.cursorIdx < 66
                   )
                   { 
                     gd.cursorIdx++;  
                     gd.dy -= gd.gridSize;
                   }  
                 else if(gd.cursorIdx > 43 && gd.cursorIdx <= 55)
                 {
                   gd.cursorIdx--;
                   gd.dy -= gd.gridSize;
                 } 
                 else if(gd.cursorIdx >= 72 && gd.cursorIdx < 78 )
                 {
                     gd.cursorIdx++;  
                     gd.dy -= gd.sgridSize;
                 }
                 else if(gd.cursorIdx == 78)
                 {
                     gd.cursorIdx++;
                     gd.dx = gd.margin + gd.gridSize * 6 - gd.gridSize * 3;
                     gd.dy = gd.screenHeight - 15 * gd.gridSize - gd.gridSize * 3 - 2;
  
                 }
                 else if(gd.cursorIdx == 79)
                 {
                     gd.cursorIdx = 1;
                     gd.dx = 14 + 2;
                     gd.dy = 2 + gd.gridSize * 19 + gd.gridSize;
                 }           
                  

                 break;
            case Canvas.DOWN:
                 if(gd.cursorIdx == 62)
                 {
                    gd.cursorIdx = 13;
                    gd.dy += 2*gd.gridSize;// + gd.gridSize;  
                 } 
                 else if(gd.cursorIdx > 7 && gd.cursorIdx <= 13
                    || gd.cursorIdx > 19 && gd.cursorIdx <= 31 
                    || gd.cursorIdx > 62 && gd.cursorIdx <= 66
                   )
                   { 
                     gd.cursorIdx--;  
                     gd.dy += gd.gridSize;
                   }
                  else if(gd.cursorIdx >= 43 && gd.cursorIdx < 55)  
                   {  
                     gd.cursorIdx++;  
                     gd.dy += gd.gridSize;

                   }
                  else if (gd.cursorIdx > 72 && gd.cursorIdx <= 78) 
                   {
                     gd.cursorIdx--;  
                     gd.dy += gd.sgridSize;
  
                   }
                   else if(gd.cursorIdx == 79)
                   {
                     gd.cursorIdx = 1;
                     gd.dx = 14 + 2;
                     gd.dy = 2 + gd.gridSize * 19 + gd.gridSize;
                   }           
                 break;
          } 
          System.out.println("cursor Idx: " + gd.cursorIdx);
          break;

          case 3:
        
          
          switch(keyCode)
          { 
            case 35:
                      
                      gd.uyerMey = 247;
                      gd.uyermeyNilai2 = 0;
                      break;
   
            case 42:
                      gd.uyermeyNilai++;
                      if(gd.uyermeyNilai >= 3)
                      gd.uyermeyNilai = 0;
                      break;

            case 48:
                      gd.uyerMey = (gd.uyermeyNilai  + keyCode - 48 + 1) * 19+ gd.uyermeyNilai2; 
                      gd.uyermeyNilai2 = 0;
                      break;

            case 49:
                      
                      gd.uyerMey = (gd.uyermeyNilai + keyCode - 48 + 3) * 19 + gd.uyermeyNilai2 ;
                      gd.uyermeyNilai2 = 0;
                      break;

            case 50:
                      gd.uyerMey = (gd.uyermeyNilai + keyCode - 48 + 5) * 19 + gd.uyermeyNilai2 ;
                      gd.uyermeyNilai2 = 0;
                      break;
            case 51:
                      gd.uyerMey = (gd.uyermeyNilai + keyCode - 48 + 7) * 19 + gd.uyermeyNilai2 ;
                      gd.uyermeyNilai2 = 0;
                      break;

            case 52:
                      gd.uyerMey = gd.uyermeyNilai  + keyCode - 48 - 3; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;


            case 53:
                      gd.uyerMey =  gd.uyermeyNilai  + keyCode - 48 - 1; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;

            case 54:
                      gd.uyerMey =  gd.uyermeyNilai  + keyCode - 48 + 1; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;

            case 55:
                      gd.uyerMey = gd.uyermeyNilai  + keyCode - 48 + 3; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;

            case 56:
                      gd.uyerMey = gd.uyermeyNilai  + keyCode - 48  + 5; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;

            case 57:
                      gd.uyerMey = gd.uyermeyNilai  + keyCode - 48  + 7; 
                      gd.uyermeyNilai2 = gd.uyerMey;
                      break;
             
          }   
System.out.println("uyermey " + gd.uyerMey+" "+gd.uyermeyNilai2+" "+gd.uyermeyNilai);
          switch(ga)
          {
            case Canvas.LEFT:
                 gd.horizontalPage--;   
                 break;
            case Canvas.RIGHT:
                 gd.horizontalPage++;   
                 break;
            case Canvas.UP:
                 gd.neendaPakkam--;   
                 break;
            case Canvas.DOWN:
                 gd.neendaPakkam++;
                 break;
          } 
          break;    
       }
          repaint();
     }
     public void remove()
     {
        removeCommand(ok); removeCommand(back);
        removeCommand(exit);removeCommand(play);
        removeCommand(repeat);removeCommand(pick);
        removeCommand(keep);}}