package de.rainbow.chunk.api;

public class SurvivalChunk {

    private final int x;
    private final int z;
    private City city;

    public SurvivalChunk(int x, int z) {
        this(x, z, null);
    }

    public SurvivalChunk(int x, int z, City c) {
        this.x = x;
        this.z = z;
        this.city = c;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass().equals(this.getClass()) == false) return false;
        return ((SurvivalChunk)obj).x == x && ((SurvivalChunk)obj).z == z;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City c) {
        this.city = c;
    }

}
