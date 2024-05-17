package org.example.springshop;

import java.util.ArrayList;

public class HashTable {
    private int capacity = 5;
    protected int size = 0;
    private class Node{
        private String key;
        private Device device;
        private Node next;

        Node(Device device){
            this.key = device.model;
            key = key.replace(' ', '-');
            this.device = device;
            next = null;
        }
    }

    protected Node[] buckets = new Node[capacity];

    public void put(Device device){
        String key = device.model;
        key = key.replace(' ', '-');
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

    public Device get(String model){
        String key = model;
        key = key.replace(' ', '-');
        int i = getIndex(hashCode(model));
        if(buckets[i]==null){
            System.out.println("there is no this device");
        } else {
            Node current = buckets[i];
            while(!current.key.equals(key) && current.next!=null){
                current = current.next;
            }
            if(!current.key.equals(key)){
                System.out.println("there is no device with this name");
            } else {
                current.device.mainDescription();
                return current.device;
            }
        }
        return null;
    }

    public void remove(Device device) {
        String key = device.model.replace(' ', '-');  // Замініть пробіли на дефіси в ключі
        int index = getIndex(hashCode(key));  // Отримайте індекс для ключа

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    // Вузол, який потрібно видалити, є першим у списку
                    buckets[index] = current.next;  // Переміщуємо голову на наступний вузол
                } else {
                    // Вузол знаходиться десь у середині або в кінці
                    previous.next = current.next;  // Вилучаємо вузол із ланцюжка
                }
                size--;  // Зменшуємо розмір хеш-таблиці
                System.out.println("Device removed successfully");
                return;
            }
            previous = current;  // Зберігаємо поточний вузол як попередній перед переходом до наступного
            current = current.next;
        }

        // Якщо вузол не знайдено після проходження всіх вузлів
        System.out.println("There is no such device");
    }


    private int getIndex(long hash){
        int index = (int) (hash%capacity);
        return  index;
    }

    private long hashCode(String model) {
        long hash = 0;
        for(int i = 0; i < model.length(); i++){
            hash += hash*31 + model.charAt(i);
        }
        return hash;
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
