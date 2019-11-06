

import java.util.Observable;
import java.util.Observer;

//Implements the observer methods
public class ObservableShip extends Observable {
	
	public void addObserver(Observer ob) {
		super.addObserver(ob);
	}
	public void setChanged() {
		super.setChanged();
	}
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}
}