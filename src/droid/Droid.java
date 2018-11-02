/**
 * 
 */
package droid;

/**
 * @author kjay
 *
 */
public class Droid {
	
	//CONSTANTES DE DROID
	static final int DEFAULT_BATTERY_CAPACITY = 200;
	static final int DEFAULT_BATTERY_LEVEL = 100;
	static final int DEFAULT_ENGINE_POWER = 5;
	static final String DEFAULT_COLOR = "WHITE";
	static final String DEFAULT_NAME = "DROID";
	static final boolean DEFAULT_LOG_BATTERY_LEVEL = true;
	//unite mesure de l'energie des batteries
	static final String BATTERY_UNIT_STRING = "BT";
	
	//nom du droid
	String mName;
	//couleur du droid
	String mColor;
	//par defaut a 100, plus le droid a de la 
	//batterie plus ce chiffre est elevee
	int mBatteryCapacity;
	//determinerera la consommation des differentes actions
	//Ce nombre est la conso d'energie du droid pour chaque action
	int mEnginePower;
	//NB : pour simplifier, 1 hour de charge remplit 1unit de battery
	int mBatteryLevel;
	boolean mLogBatteryLevel;
	
	
	
	
	/**
	 * 
	 */
	public Droid() {
		// TODO Auto-generated constructor stub
		defaultInitialisation();
	}
	
	/**
	 * 
	 */
	public Droid(String name, boolean logBatteryLevel) {
		// TODO Auto-generated constructor stub
		defaultInitialisation();
		mLogBatteryLevel = logBatteryLevel;
		mName = name;
	}
	
	private void defaultInitialisation() {
		mName = DEFAULT_NAME;
		mColor = DEFAULT_COLOR;
		mBatteryCapacity = DEFAULT_BATTERY_CAPACITY;
		mEnginePower = DEFAULT_ENGINE_POWER; 
		mLogBatteryLevel = DEFAULT_LOG_BATTERY_LEVEL;
		mBatteryLevel = DEFAULT_BATTERY_LEVEL;
	}
	
	public boolean isBatteryFull() {
		if (mBatteryLevel == mBatteryCapacity) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int calcBatteryPercentage() {
		return ((mBatteryLevel / mBatteryCapacity)*100);
	}
	
	
	public void showBatteryLevel() {
		String message = "Battery Level : "+mBatteryLevel+BATTERY_UNIT_STRING;
		message+=" Soit "+ calcBatteryPercentage()+ " %";
		if (isBatteryFull()) message+=" (FULL)";
		System.out.println(message);
	}
	
	/*
	 * Affiche systematiquement le niveau de batterie a chaque action
	 * si logBatteryLevel est a true
	 */
	private void logBatteryLevel() {
		if (mLogBatteryLevel == true) {
			showBatteryLevel();
		}
	}
	
	public void activate() {
		System.out.println("Droid "+mName+" Activated.");
		mBatteryLevel-=(1*mEnginePower);
		logBatteryLevel();
	}
	
	public void showStatus() {
		System.out.println("-------------------------------------------");
		System.out.println("Name: "+mName);
		System.out.println("Color: "+mColor);
		System.out.println("Battery Capacity: "+mBatteryCapacity);
		showBatteryLevel();
		System.out.println("Power: "+mEnginePower);
		System.out.println("LogBatteryLevel: "+mLogBatteryLevel);

		System.out.println("-------------------------------------------");
	}
	
	public void chargeBattery(int hours) {
		logBatteryLevel();
		System.out.println("Charging for "+hours+" hours...");
		
		int timeForChargeFull = mBatteryCapacity-mBatteryLevel;
		if (timeForChargeFull < hours) {
			System.out.println("... charge complete after "+timeForChargeFull+" hours...");
			System.out.println("... please unplug charge cable.");
			mBatteryLevel = mBatteryCapacity;
		}
		else {		
			mBatteryLevel+=hours;		
		}
		logBatteryLevel();
	}


	/**
	 * @return the mName
	 */
	private String getmName() {
		return mName;
	}


	/**
	 * @param mName the mName to set
	 */
	private void setmName(String mName) {
		this.mName = mName;
	}


	/**
	 * @return the mColor
	 */
	private String getmColor() {
		return mColor;
	}


	/**
	 * @param mColor the mColor to set
	 */
	private void setmColor(String mColor) {
		this.mColor = mColor;
	}


	/**
	 * @return the mBatteryCapacity
	 */
	private int getmBatteryCapacity() {
		return mBatteryCapacity;
	}


	/**
	 * @param mBatteryCapacity the mBatteryCapacity to set
	 */
	private void setmBatteryCapacity(int mBatteryCapacity) {
		this.mBatteryCapacity = mBatteryCapacity;
	}


	/**
	 * @return the mEnginePower
	 */
	private int getmEnginePower() {
		return mEnginePower;
	}


	/**
	 * @param mEnginePower the mEnginePower to set
	 */
	private void setmEnginePower(int mEnginePower) {
		this.mEnginePower = mEnginePower;
	}


	/**
	 * @return the mBatteryLevel
	 */
	private int getmBatteryLevel() {
		return mBatteryLevel;
	}


	/**
	 * @param mBatteryLevel the mBatteryLevel to set
	 */
	private void setmBatteryLevel(int mBatteryLevel) {
		this.mBatteryLevel = mBatteryLevel;
	}


	/**
	 * @return the mLogBatteryLevel
	 */
	private boolean ismLogBatteryLevel() {
		return mLogBatteryLevel;
	}


	/**
	 * @param mLogBatteryLevel the mLogBatteryLevel to set
	 */
	private void setmLogBatteryLevel(boolean mLogBatteryLevel) {
		this.mLogBatteryLevel = mLogBatteryLevel;
	}

}
