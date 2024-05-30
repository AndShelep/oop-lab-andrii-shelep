package org.example.springshop;

public interface IHashTable {
    public void put(Device device);
    public Device get(String model);
    public String remove(String model);

}
