package birsy.goblinsmod.core.capabilities.corruption;

public class CrownCorruption implements ICrownCorruption {
    private double corruption = 0;
    private static final double maxCorruption = 256;

    @Override
    public void corrupt(double amount) {
        if (this.corruption + amount < maxCorruption) {
            this.corruption += amount;
        }
    }

    @Override
    public void purify(double amount) {
        if (this.corruption - amount > 0) {
            this.corruption -= amount;
        }
    }

    @Override
    public void clearCorruption() {
        this.corruption = 0;
    }

    @Override
    public double getCorruption() {
        return this.corruption;
    }

    @Override
    public void setCorruption(double corruption) {
        this.corruption = corruption;
    }
}
