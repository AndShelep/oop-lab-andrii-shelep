package org.example.springshop;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class HashTable implements IHashTable{
    private int capacity = 5;
    protected int size = 0;
    private class Node{
        private String key;
        private Device device;
        private Node next;

        Node(Device device){
            this.key = device.model.replace(' ', '-');
            this.device = device;
            next = null;
        }
    }

    protected Node[] buckets = new Node[capacity];

    @Override
    public void put(Device device){
        String key = device.model.replace(' ', '-');
        int i = getIndex(hashCode(key));
        Node newNode = new Node(device);
        if(size==capacity){
            capacity*=2;
            size = 0;
            resize();
        }
        if(buckets[i]==null){
            buckets[i] = newNode;
        } else {
            Node current = buckets[i];
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public Device get(String model){
        String key = model.replace(' ', '-');
        int i = getIndex(hashCode(key));
        if(buckets[i]==null){
            return null;
            //System.out.println("there is no this device");
        } else {
            Node current = buckets[i];
            while(!current.key.equals(key) && current.next!=null){
                current = current.next;
            }
            if(!current.key.equals(key)){
                return null;
                //System.out.println("there is no device with this name");
            } else {
                current.device.mainDescription();
                return current.device;
            }
        }
    }

    @Override
    public String remove(String model) {
        String key = model.replace(' ', '-');
        int index = getIndex(hashCode(key));

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    // Вузол, який потрібно видалити, є першим у списку
                    buckets[index] = current.next;
                } else {
                    // Вузол знаходиться десь у середині або в кінці
                    previous.next = current.next;
                }
                size--;
                //System.out.println("Device removed successfully");
                return "Device removed";
            }
            previous = current;
            current = current.next;
        }

        return "Device not found";
        //System.out.println("There is no such device");
    }

    private int getIndex(long hash){
        int index = (int) (hash%capacity);
        return  index;
    }

    public long hashCode(String model) {
        long hash = 0;
        for(int i = 0; i < model.length(); i++){
            hash += hash*31 + model.charAt(i);
        }
        return (long) abs(hash);
    }

    private void resize(){
        Node[] newBuckets = new Node[capacity];
        for(int i = 0; i < capacity/2; i++){
            Node node = buckets[i];
            while(node!=null){
                Node newNode = new Node(node.device);
                String key = node.device.model;
                key = key.replace(' ', '-');
                int j = getIndex(hashCode(key));
                if(newBuckets[j]==null){
                    newBuckets[j] = newNode;
                } else {
                    Node current = newBuckets[j];
                    while(current.next!=null){
                        current = current.next;
                    }
                    current.next = newNode;
                }
                node = node.next;
                size++;
            }
        }
        buckets = newBuckets;
    }
}
