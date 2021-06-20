package birsy.goblinsmod.core.capabilities.corruption;

/**
 * System for the crown corrupting entities.
 * Used to make the player big and makes enemies hostile.
 */
public interface ICrownCorruption {
    public void corrupt(double amount);
    public void purify(double amount);


    public void clearCorruption();

    public double getCorruption();
    public void setCorruption(double corruption);
}
