package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneFactory {

    //TODO: Initialize the phoneList attribute (as an ArrayList or a LinkedList) in the constructor and add a getter, setter for this attribute
    private List<Phone> phoneList;

    public PhoneFactory() {
        this.phoneList = new ArrayList<Phone>();
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    //TODO: Implement the producePhones method which adds the parameter phone to the phoneList

    public void producePhone(Phone phone){
        this.phoneList.add(phone);
    }
    //TODO: Implement the findPhones method which searches through the entire phoneList and returns the phone with the matching id. If no such phone exists, return a new phone with the brand "", price -1 and without touchscreen feature

    public Phone findPhone(int id){
        for ( Phone phone: phoneList){
            if (phone.getId() == id ){
                return phone;
            }
        }

        Phone newPhone = new Phone("",-1,false);

        return newPhone;
    }
    //TODO: Implement the removePhone method which removes the phone with the given id from the phoneList and returns the removed phone. If no phone with the given id exists, then follow the same rule in the findPhones method.

    public Phone removePhone(int id){
       if ( findPhone(id).getPrice() == -1 ) {
           return findPhone(id);
       }else {
           Phone removedPhone = findPhone(id);
           phoneList.remove(findPhone(id));
           return removedPhone;
       }
    }
    //TODO: Implement findTouchPhones method that iterates over the phoneList and store all touchscreen phones in a new list and return this list.

    public List<Phone> findTouchPhones(){

        List<Phone> touchPhones= new ArrayList<>();

        for(Phone phone: phoneList){
            if (phone.isTouchscreen()){
                touchPhones.add(phone);
            }
        }

        return touchPhones;

    }
    //TODO: Implement containsPhone that checks if the given phoneList contains the given phone. Return true if it does and false if it doesn't.

    public boolean containsPhone(List<Phone> phoneList, Phone phone){

        for (Phone i: phoneList){
            if (i.getId() == phone.getId()){
                return true;
            }
        }

        return false;
    }
    //TODO: Implement removeByBrand that removes all the phones with the brand from the list phones and returns a list that doesn't contain phones of this brand. If brand or phones is null, return an empty list.

    public List<Phone> removeByBrand(List<Phone> phones, String brand){

        if (phones.isEmpty() || brand == null){
            return new ArrayList<>();
        }else {
            // can't remove inside the loop -> ConcurrentModificationException
            phones.removeIf(phone -> phone.getBrand().equals(brand));

        }

        return phones;
    }
    //TODO: Implement findSmallestByLex method that returns the phone with the lexicographically smallest brand

    public Phone findSmallestByLex(List<Phone> phones){

        Phone smallest = phones.get(0);

        for (Phone phone: phones){
            if ( smallest.getBrand().compareTo(phone.getBrand()) > 0){
                smallest = phone;
            }
        }
        return smallest;
    }
    //TODO: Implement sortByTouch that stores all the phones with a touchscreen in the beginning of a list, the rest of the phones at the end and return this list of phones.

    public List<Phone> sortByTouch(){

        ArrayList<Phone> withTouchscreen = this.phoneList.stream().filter(Phone::isTouchscreen).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Phone> noTouchscreen = this.phoneList.stream().filter(phone -> !phone.isTouchscreen()).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Phone> sortedList = new ArrayList<Phone>(withTouchscreen);
        sortedList.addAll(noTouchscreen);

    return sortedList;
    }
    //TODO: Implement sortByBrand that sorts the phones lexicographically according to their brand and return a list of sorted phones.

    public List<Phone> sortByBrand(List<Phone> phones){

        if (phones.size() > 1){
            for ( int i=0; i<phones.size(); i++){
                for (int j=1; j<phones.size() -i; j++){
                    if ( phones.get(j-1).getBrand().compareTo(phones.get(j).getBrand()) > 0){
                        Phone temp = phones.get(j-1);
                        phones.set(j-1,phones.get(j));
                        phones.set(j,temp);

                    }
                }
            }
        }


    return phones;
    }
    //TODO: Implement sortByPrice that sorts the list of phones according to their price in increasing order and return the sorted list

    public List<Phone> sortByPrice(){
        ArrayList<Phone> phones = new ArrayList<Phone>(this.phoneList);

        if (phones.size() > 1){
            for ( int i = 0; i<phones.size(); i++){
                for ( int j = 1; j<phones.size() - i; j++){
                    if ( phones.get(j-1).getPrice() > phones.get(j).getPrice()){
                        Phone temp = phones.get(j-1);
                        phones.set(j-1,phones.get(j));
                        phones.set(j,temp);
                    }
                }
            }
        }

    return phones;
    }

    public static void main(String[] args) {
        Phone p1 = new Phone("Samsung",10,true);
        Phone p2 = new Phone("Apple",15,true);
        Phone p3 = new Phone("Nokia",5,false);


        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(p1);
        phoneList.add(p2);
        phoneList.add(p3);

        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.setPhoneList(phoneList);

        phoneFactory.producePhone(p1);
        List<Phone> sbt = phoneFactory.sortByTouch();

        List<Phone> sbb =  phoneFactory.sortByBrand(sbt);

        List<Phone> sbp = phoneFactory.sortByPrice();

        for(Phone phone: sbp){
            System.out.println(phone);
        }

        //System.out.println(phoneFactory.findPhone(1));



    }
}


