/**
Programmer: K. Manigandan
StartDate:  21/08/2007
Version:    1.0
*/
package co.in.dayam;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
public class DayamMidlet extends MIDlet
{
     public DayamCanvas dayam;
     public DayamMidlet()
     {
          dayam = new DayamCanvas(this);
           
     }  
     public void startApp()
     {
          if(dayam != null)
          {  
               Display.getDisplay(this).setCurrent(dayam);
          }
     };
     public void pauseApp()
     {
     };
     public void destroyApp(boolean unconditional)
     {
        notifyDestroyed();
     };
     public void closeApp()
     {
        destroyApp(true);
     };
}