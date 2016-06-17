/**
 * Der Controller schickt die Eintraege der View
 * Zum Model was damit rumrechnet und das Ergebnis 
 * wieder zurück zur View
 * 
 * 
 */
import java.awt.event.*;
public class Controller{
    private View _view;
    private Model _model;
    private boolean valid;
    
    /**
     * erstellt ein Model und ein View
     * und fügt die ActionListener Hinzu
     */
    public Controller(){
       this._model = new Model();
       this._view = new View();
       addListener();
    }
    
    public void showView(){
        this._view.setVisible(true);
    }
    /**
     * Fügt die 3 ActionListener der 3 Knöpfe hinzu
     * 
     *
     */
    private void addListener(){
        this._view.setStartListener(new StartListener());
        this._view.setStepListener(new StepListener());
        this._view.setClearListener(new ClearListener());
       
    }
    /**
     * Prueft bei jedem Knopfdruck
     * ob die Eintraege alle Korrekt sind
     */
    public void isValidController(){
        this.valid = _model.isValid(_view.getAX(), _view.getAY(), 
            _view.getBX(), _view.getBY(),
            _view.getCX(), _view.getCY(), 
            _view.getPunktX(), _view.getPunktY(),
            _view.getStep());
            
            _view.farbe(valid); 
    }
    //hier kommen dann die ganzen Aktionen rein
    class StartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isValidController();
               
        }
    }
    class StepListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isValidController();
           
            
        }
    }
    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            isValidController();
        }
    }
}
