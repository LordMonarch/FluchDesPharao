
/**
 * Beschreiben Sie hier die Klasse Model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.util.*;
public class Model 
{
    private int rechts = 200;
    private int links = 100;
    private int oben = 50;
    private int unten = 200;
    
    public boolean punkteInZeichenebene(int AX, int AY, int BX, int BY, int CX, int CY, int PX, int PY){
        if(AX >= links && AX <= rechts &&
        BX >= links && BX <= rechts &&
        CX >= links && CX <= rechts &&
        PX >= links && PX <= rechts &&
        AY >= oben && AY <= unten &&
        BY >= oben && BY <= unten &&
        CY >= oben && CY <= unten &&
        PY >= oben && PY <= unten){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean punktImDreieck(int AX, int AY, int BX, int BY, int CX, int CY, int PX, int PY){
        int ABC, ABCP, ABPC, APBC;
        
        ABC = AX * (BY-CY) + BX * (CY-AY) + CX * (AY-BY);
        ABCP = AX * (BY-PY) + BX * (CY-AY) + CX * (PY-BY) + PX * (AY-CY);
        ABPC = AX * (BY-CY) + BX * (PY-AY) + PX * (CY-BY) + CX * (AY-PY);
        APBC = AX * (PY-CY) + PX * (BY-AY) + BX * (CY-PY) + CX * (AY-BY);
        if(ABC < 0){ABC *= -1;}
        if(ABCP < 0){ABCP *= -1;}
        if(ABPC < 0){ABPC *= -1;}
        if(APBC < 0){APBC *= -1;}
        
        if( (ABCP-ABC) > 0 || (ABPC-ABC) > 0 || (APBC-ABC) > 0){
            return false;
        }
        
        return true;
    }
    
    public boolean isValid(String AX, String AY, String BX, String BY, String CX, String CY, String PunktX, String PunktY, String Step){
        boolean temp = true;
       
        try{
        try{
        Integer.parseInt(AX);
        Integer.parseInt(AY);
        Integer.parseInt(BX);
        Integer.parseInt(BY);
        Integer.parseInt(CX);
        Integer.parseInt(CY);
        Integer.parseInt(PunktX);
        Integer.parseInt(PunktY);
        Integer.parseInt(Step);
       
        if(Integer.parseInt(AX) == Integer.parseInt(BX) && 
        Integer.parseInt(AY) == Integer.parseInt(BY) ||
        Integer.parseInt(AX) == Integer.parseInt(CX) &&
        Integer.parseInt(AY) == Integer.parseInt(CY) ||
        Integer.parseInt(BX) == Integer.parseInt(CX) &&
        Integer.parseInt(BY) == Integer.parseInt(CY) ){
            temp = false;
           
        }else{
            temp = true;
          
            if(Integer.parseInt(Step) <= 0 ){
                temp = false;
               
            }else{
                temp = true;
              
                
                temp = punktImDreieck(Integer.parseInt(AX),Integer.parseInt(AY), 
                Integer.parseInt(BX),  Integer.parseInt(BY),
                Integer.parseInt(CX),  Integer.parseInt(CY),
                Integer.parseInt(PunktX),  Integer.parseInt(PunktY));
                
                temp = punkteInZeichenebene(Integer.parseInt(AX),Integer.parseInt(AY), 
                Integer.parseInt(BX),  Integer.parseInt(BY),
                Integer.parseInt(CX),  Integer.parseInt(CY),
                Integer.parseInt(PunktX),  Integer.parseInt(PunktY));
            }
        }
        
        
        }catch(NumberFormatException e){
            temp = false;
        }
    }catch(NullPointerException p){
            temp = false;
        }
    
        return temp;
    }
    
    
   
}
