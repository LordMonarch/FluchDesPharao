/**
 * Beschreiben Sie hier die Klasse Controller.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.awt.event.*;
public class Controller{
    private View _view;
    private Model _model;
    private boolean valid;
    
    /**
     * Konstruktor für Objekte der Klasse Controller
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
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    private void addListener(){
        this._view.setStartListener(new StartListener());
        this._view.setStepListener(new StepListener());
        this._view.setClearListener(new ClearListener());
       
    }
    
    public void isValidController(){
        this.valid = _model.isValid(_view.getAX(), _view.getAY(), 
            _view.getBX(), _view.getBY(),
            _view.getCX(), _view.getCY(), 
            _view.getPunktX(), _view.getPunktY(),
            _view.getStep());
            
            _view.farbe(valid); 
    }
    
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
